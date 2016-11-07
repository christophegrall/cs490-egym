import { Component, OnInit } from '@angular/core';
import { ExerciseService } from './exercise.service';
import { Observable } from 'rxjs/Rx';
import { Exercise } from './exercise';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Welcome to eGym!';
  subtitle = 'A Fitness Tracking App';
  exercises: Exercise[];

  constructor(private es: ExerciseService) {}

  ngOnInit() {
    this.testGet();
  }

  testGet(): void {
    this.es.getExercises().subscribe(
      data => {
        this.exercises = data;
      },
      err => {
        console.log(err);
      }
    );
  }
}
