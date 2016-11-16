import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { LocalStorageService } from 'angular-2-local-storage';
import { LoginService } from './login.service';
import { AuthResponse } from './auth-response';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public response: AuthResponse;

  constructor(
    private login: LoginService, 
    private router: Router,
    private localStorageService: LocalStorageService
  ) { }

  onSubmit(username: string, password: string): void {
    this.login.requestAuth(username, password).subscribe(
      data => {
        this.response = data;
        this.localStorageService.set('token', this.response.token);
        this.router.navigate(['home']);
      },
      err => {
        console.error(err);
      }
    );
  }

  ngOnInit() {
  }

}
