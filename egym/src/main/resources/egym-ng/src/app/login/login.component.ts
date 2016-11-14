import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

import { LoginService } from '../login.service';
import { AuthResponse } from '../auth-response';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public response: AuthResponse;
  @Output() onActive = new EventEmitter<boolean>();

  constructor(private login: LoginService) { }

  onSubmit(username: string, password: string): void {
    this.login.requestAuth(username, password).subscribe(
      data => {
        this.response = data;
        this.onActive.emit(false);
      },
      err => {
        console.error(err);
        this.response = new AuthResponse("Failed!");
      }
    );
  }

  ngOnInit() {
  }

}
