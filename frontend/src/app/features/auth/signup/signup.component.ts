import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthService } from '../../../core/services/auth.service';
import { SignupRequest } from '../../../core/models/auth.model';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {

  private readonly fb = inject(FormBuilder);
  private readonly authService = inject(AuthService);
  private readonly router = inject(Router);

  isLoading = false;
  errorMessage: string | null = null;
  successMessage: string | null = null;

  signupForm = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(6)]],
    role: ['CANDIDATE', Validators.required]
  });

  onSubmit(): void {
    if (this.signupForm.invalid) {
      this.signupForm.markAllAsTouched();
      return;
    }

    this.isLoading = true;
    this.errorMessage = null;
    this.successMessage = null;

    const request: SignupRequest = {
      email: this.signupForm.value.email!,
      password: this.signupForm.value.password!,
      role: this.signupForm.value.role as 'CANDIDATE' | 'RECRUITER'
    };

    this.authService.signup(request).subscribe({
      next: (response) => {
        this.handleSuccess();
      },
      error: (error) => {
        // If backend returns status 200 or 201 with empty/text body, HttpClient triggers error parsing
        if (error.status === 200 || error.status === 201) {
          this.handleSuccess();
          return;
        }

        this.isLoading = false;
        console.error('Signup Error details:', error);
        
        if (typeof error.error === 'string') {
          this.errorMessage = error.error;
        } else {
          this.errorMessage = error.error?.message || 'Failed to create account. Please try again.';
        }
      }
    });
  }

  private handleSuccess(): void {
    this.isLoading = false;
    this.successMessage = 'Account created successfully! Redirecting to login...';
    this.signupForm.reset({ role: 'CANDIDATE' });

    setTimeout(() => {
      this.router.navigate(['/login']);
    }, 2000);
  }
}