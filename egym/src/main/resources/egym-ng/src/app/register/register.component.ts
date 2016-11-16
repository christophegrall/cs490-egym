import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public user: Object;

  constructor(private router: Router) { }

  onSubmit(
    email: string,
    username: string,
    password: string,
    password2: string,
    firstname: string,
    lastname: string
  ): void {
    if(password !== password2) {
      console.warn("Passwords don't match!");
    } else {
      this.user = {
        Email: email,
        Username: username,
        Password: password,
        Firstname: firstname,
        Lastname: lastname
      }
      console.log(this.user);
      this.router.navigate(['login']);
    }
  }

  ngOnInit() {
  }

}
