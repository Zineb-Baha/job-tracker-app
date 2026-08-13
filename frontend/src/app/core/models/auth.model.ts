export interface SignupRequest {
  email: string;
  password: string;
  role: 'CANDIDATE' | 'RECRUITER';
}