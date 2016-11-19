import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Response } from '@angular/http';

import { LocalStorageService } from 'angular-2-local-storage';
import { LoginService } from './login.service';
import { AuthResponse, Auth } from './auth';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public auth: Auth;

  constructor(
    private login: LoginService, 
    private router: Router,
    private localStorageService: LocalStorageService
  ) { }

  onSubmit(username: string, password: string): void {
    //TODO: Check username & password for invalid characters, length, etc.
    this.auth = new Auth(username, password);
    this.login.requestAuth(this.auth).subscribe(
      data => {
        switch (data.statusCode) {
          case 200:
            this.localStorageService.set('token', data.token);
            this.router.navigate(['home']);
            break;
          default:
            console.warn(`Status: ${data}`);
        }
      },
      error => {
        //Possible error codes:
        //422 (incorrect username/password)
        //423 (account is disabled/locked)
        if (error instanceof AuthResponse) {
          //TODO: Show user the problem
        }
        console.error(error);
      }
    );
  }

  ngOnInit() {
  }

}
