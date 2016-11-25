import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { ModalDirective } from 'ng2-bootstrap/ng2-bootstrap';
import { RegisterService } from './register.service';
import { User, UserModel, UserResponse } from './user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  @ViewChild('regStatModal') public regStatModal: ModalDirective;
  public user: User;
  public userModel: UserModel;
  public status: string = "";
  public success: boolean = false;

  constructor(
    private router: Router,
    private registerService: RegisterService
  ) { }

  onSubmit(model: UserModel, isValid: boolean): void {
    if(!isValid) {
      this.status = "Form invalid. Please correct to continue.";
      this.regStatModal.show();
      return;
    }
    this.user = {
      username: model.username,
      password: model.password,
      firstname: model.firstname,
      lastname: model.lastname,
      email: model.email
    }
    this.registerService.createUser(this.user).subscribe(
      data => {
        switch (data.statusCode) {
          case 200:
            this.status = "You have successfully registered!";
            this.success = true;
            break;
          default:
            this.status = `${data.body}!`;
            console.warn(data);
        }
        this.regStatModal.show();
      },
      error => {
        if (error instanceof UserResponse) {
          this.status = `${error.body}!`;
        } else {
          this.status = 'Unknown error';
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
    this.userModel = {
      username: '',
      password: '',
      password2: '',
      firstname: '',
      lastname: '',
      email: ''
    }
  }

}
