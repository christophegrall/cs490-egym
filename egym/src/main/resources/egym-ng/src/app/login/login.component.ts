import { Component, OnInit, ViewChild, Renderer } from '@angular/core';
import { Router } from '@angular/router';

import { tokenNotExpired } from 'angular2-jwt';
import { ModalDirective } from 'ng2-bootstrap/ng2-bootstrap';
import { LocalStorageService } from 'angular-2-local-storage';
import { LoginService } from './login.service';
import { AuthResponse, Auth } from './auth';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @ViewChild('loginModal') public loginModal: ModalDirective;
  @ViewChild('passwordInput') public passwordInput;
  public auth: Auth;
  public togglePasswordType: boolean = true;
  public usernameLength: boolean = false;
  public status: string = "";

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
    this.usernameLength = false;
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
            this.status = `${data.body}!`;
            this.loginModal.show();
            console.warn(data);
        }
      },
      error => {
        //Possible error codes:
        //422 (incorrect username/password)
        //423 (account is disabled/locked)
        if (error instanceof AuthResponse) {
          this.status = `${error.body}!`;
        } else {
          this.status = 'Unknown error';
        }
        this.loginModal.show();
        console.error(error);
      }
    );
  }

  ngOnInit() {
    if(tokenNotExpired('egym.token')) {
      this.router.navigate(['home']);
      return;
    }
    this.auth = {
      username: '',
      password: ''
    }
  }

  public hideLoginModal(): void {
    this.loginModal.hide();
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
