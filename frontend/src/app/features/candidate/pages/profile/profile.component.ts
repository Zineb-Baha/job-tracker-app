import { Component } from '@angular/core';
import {
  FormBuilder,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';

import { CandidateNavbarComponent } from '../../components/candidate-navbar/candidate-navbar.component';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CandidateNavbarComponent
  ],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {

  private readonly fb = new FormBuilder();

  profileForm = this.fb.nonNullable.group({
    firstName: ['Zineb', Validators.required],
    lastName: ['Baha', Validators.required],
    phoneNumber: ['+212 6 XX XX XX XX'],
    address: ['Casablanca, Morocco'],
    degree: ['State Engineer in Software Engineering'],
    headline: ['Java / Full Stack Software Engineer'],
    summary: [
      'Software Engineer specialized in Java, Spring Boot and Angular, with experience in ERP development and web applications.'
    ],
    profilePictureUrl: ['']
  });

  isSaving = false;
  successMessage = '';

  onSubmit(): void {

    if (this.profileForm.invalid) {
      this.profileForm.markAllAsTouched();
      return;
    }

    this.isSaving = true;
    this.successMessage = '';

    // Backend will be connected later.
    console.log('Profile data:', this.profileForm.getRawValue());

    setTimeout(() => {
      this.isSaving = false;
      this.successMessage = 'Profile updated successfully.';
    }, 800);
  }

  onCancel(): void {
    console.log('Cancel editing');
  }

}