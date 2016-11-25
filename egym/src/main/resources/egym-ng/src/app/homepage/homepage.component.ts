import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { tokenNotExpired } from 'angular2-jwt';
import { LocalStorageService } from 'angular-2-local-storage';
import { ExerciseService } from './exercise.service';
import { Exercise } from './exercise';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  public exercises: Exercise[];

  constructor(
    private router: Router,
    private localStorageService: LocalStorageService,
    private exerciseService: ExerciseService
  ) { }

  ngOnInit() {
    if(!tokenNotExpired('egym.token')) {
      this.router.navigate(['login']);
    } else {
      this.exerciseService.getAll(<string> this.localStorageService.get('token')).subscribe(
        data => {
          this.exercises = data;
          console.log(data);
        }
      )
    }
  }

}
