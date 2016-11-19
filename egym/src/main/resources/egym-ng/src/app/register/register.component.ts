import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { ModalDirective } from 'ng2-bootstrap/ng2-bootstrap';
import { RegisterService } from './register.service';
import { User, UserResponse } from './user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  @ViewChild('regStatModal') public regStatModal: ModalDirective;

  public user: User;
  public status: string = "";
  public success: boolean = false;

  constructor(
    private router: Router,
    private registerService: RegisterService
  ) { }

  onSubmit(
    email: string,
    username: string,
    password: string,
    password2: string,
    firstname: string,
    lastname: string
  ): void {
    if (password !== password2) {
      this.status = "Passwords don't match!";
      this.regStatModal.show();
      return;
    }
    this.user = new User(
      username,
      password,
      firstname,
      lastname,
      email
    );
    this.registerService.createUser(this.user).subscribe(
      data => {
        switch (data.statusCode) {
          case 200:
            this.status = "You have successfully registered!";
            this.success = true;
            break;
          default:
            this.status = data.body;
            console.warn(`Status: ${data}`);
        }
        this.regStatModal.show();
      },
      error => {
        if (error instanceof UserResponse) {
          this.status = error.body;
        } else {
          this.status = "Unknown error";
        }
        this.regStatModal.show();
        console.error(error);
      }
    );
  }

  public hideStatModal(): void {
    if(this.success) {
      this.regStatModal.hide();
      this.router.navigate(['login']);
    } else {
      this.regStatModal.hide();
    }
  }

  ngOnInit() {
  }

}
