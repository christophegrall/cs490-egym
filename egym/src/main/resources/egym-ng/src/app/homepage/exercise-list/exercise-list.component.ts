import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ExerciseService } from '../exercise.service';
import { Exercise } from '../exercise';
import { LocalStorageService } from 'angular-2-local-storage';
import { Difficulty } from '../difficulty.enum';
import { Type } from '../type.enum';

@Component({
  selector: 'app-exercise-list',
  templateUrl: './exercise-list.component.html',
  styleUrls: ['./exercise-list.component.css']
})
export class ExerciseListComponent implements OnInit {
  public exercises: Exercise[];
  public user_exercises: Exercise[];
  public disabled:boolean = false;
  public status:{isopen:boolean} = {isopen: false};

  constructor(
    private router: Router,
    private localStorageService: LocalStorageService,
    private exerciseService: ExerciseService
  ) { }

  gotoDetail(ex: Exercise): void {
    console.log(ex);
  }

  sortType(selectedType: number): void {
    let newExercises: Exercise[] = new Array;
    let type: Type = null;
    if(selectedType === 0) {
      this.user_exercises = this.exercises;
      return;
    } else if(selectedType === 1) {
      type = Type.CARDIO;
    } else if(selectedType === 2) {
      type = Type.CORE;
    } else if(selectedType === 3) {
      type = Type.WEIGHTLIFTING;
    }
    for(let i of this.exercises) {
      if(i.type === type) {
        newExercises.push(i);
      }
    }
    this.user_exercises = newExercises;
  }

  sortDiff(selectedDifficulty: number): void {
    let newExercises: Exercise[] = new Array;
    let diff: Difficulty = null;
    if(selectedDifficulty === 0) {
      this.user_exercises = this.exercises;
      return;
    } else if(selectedDifficulty === 1) {
      diff = Difficulty.BEGINNER;
    } else if(selectedDifficulty === 2) {
      diff = Difficulty.INTERMEDIATE;
    } else if(selectedDifficulty === 3) {
      diff = Difficulty.ADVANCED;
    } else if(selectedDifficulty === 4) {
      diff = Difficulty.EXPERT;
    }
    for(let i of this.exercises) {
      if(i.difficulty === diff) {
        newExercises.push(i);
      }
    }
    this.user_exercises = newExercises;
  }

  ngOnInit() {
    if (this.localStorageService.get('token')) {
      this.exerciseService.getAll(<string>this.localStorageService.get('token')).subscribe(
        data => {
          this.exercises = data;
          this.user_exercises = this.exercises;
        }
      );
    }
  }

}
