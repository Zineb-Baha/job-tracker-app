import { Routes } from '@angular/router';
import { SignupComponent } from './features/auth/signup/signup.component';
import { LoginComponent } from './features/auth/login/login.component';
import { HomeComponent } from './features/home/home.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'signup', component: SignupComponent },
    { path: 'login', component: LoginComponent },
    { path: 'candidate/home', loadComponent: () =>
    import('./features/candidate/pages/home/home.component')
      .then(m => m.HomeComponent)  },
      {
  path: 'candidate/profile',
  loadComponent: () =>
    import('./features/candidate/pages/profile/profile.component')
      .then(m => m.ProfileComponent)
}
   
];
