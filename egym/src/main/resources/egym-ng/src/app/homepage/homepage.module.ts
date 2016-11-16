import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { LocalStorageService, LOCAL_STORAGE_SERVICE_CONFIG } from 'angular-2-local-storage';
import { AlertModule, ButtonsModule } from 'ng2-bootstrap/ng2-bootstrap';
import { ExerciseService } from './exercise.service';
import { HomepageComponent } from './homepage.component';
import { HomepageRoutingModule } from './homepage-routing.module';

let localStorageServiceConfig = {
    prefix: 'egym',
    storageType: 'localStorage'
};

@NgModule({
  declarations: [
    HomepageComponent
  ],
  imports: [
    AlertModule,
    ButtonsModule,
    FormsModule,
    HttpModule,
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
