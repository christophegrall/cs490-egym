import { Component, OnInit } from '@angular/core';
import { ExerciseService } from './exercise.service';
// import { Observable } from 'rxjs/Rx';
// import { Exercise } from './exercise';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public active: boolean = true;
  // title: string = 'Welcome to eGym!';
  // subtitle: string = 'A Fitness Tracking App';
  // exercises: Exercise[];

  constructor(private exerciseService: ExerciseService) {}

  onActive(status: boolean) {
    this.active = status;
  }

  ngOnInit() {
    // this.exerciseService.getAll().subscribe(
    //   data => {
    //     this.exercises = data;
    //     console.log(`Exercises: ${this.exercises}`);
    //   },
    //   err => {
    //     console.error(`Error: ${err}`);
    //   }
    // );
    // this.exerciseService.remove(1).subscribe(d=>console.log(d),e=>console.error(e));
  }
}
