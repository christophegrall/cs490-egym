import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { CommonModule } from '@angular/common';

import { LocalStorageService, LOCAL_STORAGE_SERVICE_CONFIG } from 'angular-2-local-storage';
import { AlertModule, ButtonsModule } from 'ng2-bootstrap/ng2-bootstrap';
import { ExerciseService } from './exercise.service';
import { HomepageComponent } from './homepage.component';
import { HomepageRoutingModule } from './homepage-routing.module';
import { AboutComponent } from './about/about.component';
import { ExerciseListComponent } from './exercise-list/exercise-list.component';
import { ExerciseDetailComponent } from './exercise-detail/exercise-detail.component';

let localStorageServiceConfig = {
    prefix: 'egym',
    storageType: 'localStorage'
};

@NgModule({
  declarations: [
    HomepageComponent,
    AboutComponent,
    ExerciseListComponent,
    ExerciseDetailComponent
  ],
  imports: [
    AlertModule,
    ButtonsModule,
    FormsModule,
    HttpModule,
    CommonModule,
    HomepageRoutingModule
  ],
  providers: [
    ExerciseService,
    LocalStorageService,
    {
      provide: LOCAL_STORAGE_SERVICE_CONFIG, useValue: localStorageServiceConfig
    }
  ]
})
export class HomepageModule { }
