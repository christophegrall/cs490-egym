import { Component, OnInit, ViewChild, Renderer } from '@angular/core';
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
  @ViewChild('passwordInput') passwordInput;
  public togglePasswordType: boolean = true;
  public usernameLength: boolean = false;

  constructor(
    private login: LoginService, 
    private router: Router,
    private localStorageService: LocalStorageService,
    private renderer: Renderer
  ) { }

  onSubmit(username: string, password: string): void {
    if(username.length < 4 || username.length > 12) {
      this.usernameLength = true;
      return;
    }
    this.auth = {
      username: username,
      password: password
    }
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
    this.auth = {
      username: '',
      password: ''
    }
  }

  /**
   * Allows user to toggle showing/hiding password
   */
  toggleType(): void {
    if(this.togglePasswordType) {
      this.renderer.setElementAttribute(this.passwordInput.nativeElement, 'type', 'text');
      this.togglePasswordType = false;
    } else {
      this.renderer.setElementAttribute(this.passwordInput.nativeElement, 'type', 'password');
      this.togglePasswordType = true;
    }
  }

}
