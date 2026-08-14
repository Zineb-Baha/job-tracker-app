import { Component } from '@angular/core';
import { CandidateNavbarComponent } from '../../components/candidate-navbar/candidate-navbar.component';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [CandidateNavbarComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
