import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { SignupRequest } from '../models/auth.model';
import { LoginRequest } from '../models/login-request';
import { LoginResponse } from '../models/login-response';
import { environment } from '../../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly http = inject(HttpClient);

  private readonly apiUrl = `${environment.apiUrl}/users/auth`;

  signup(request: SignupRequest): Observable<string> {
    if (environment.demoMode) {
      return of('Demo signup is disabled.');
    }

    return this.http.post<string>(
      `${this.apiUrl}/signup`,
      request
    );
  }

  login(request: LoginRequest): Observable<LoginResponse> {
    if (environment.demoMode) {
      return this.demoLogin(request);
    }

    return this.http.post<LoginResponse>(
      `${this.apiUrl}/login`,
      request
    );
  }

  private demoLogin(request: LoginRequest): Observable<LoginResponse> {
    if (
      request.email === 'demo@example.com' &&
      request.password === 'Demo123!'
    ) {
      const response: LoginResponse = {
        token: ''
      };

      return of(response);
    }

    return throwError(() => ({
      error: {
        message: 'For the live demo, use demo@example.com / Demo123!'
      }
    }));
  }
}