import { Component, OnInit } from '@angular/core';

import { LoginService } from '../login.service';
import { AuthResponse } from '../auth-response';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public response: AuthResponse;

  constructor(private login: LoginService) { }

  onSubmit(username: string, password: string): void {
    this.login.requestAuth(username, password).subscribe(
      data => {
        this.response = data;
      },
      err => {
        console.error(err);
      }
    );
  }

  ngOnInit() {
  }

}
