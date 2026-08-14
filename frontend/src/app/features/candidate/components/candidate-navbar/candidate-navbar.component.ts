import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-candidate-navbar',
  standalone: true,
  imports: [
    RouterLink,
    RouterLinkActive
  ],
  templateUrl: './candidate-navbar.component.html',
  styleUrl: './candidate-navbar.component.css'
})
export class CandidateNavbarComponent {

}