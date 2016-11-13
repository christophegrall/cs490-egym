import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ExerciseService } from './exercise.service';
import { LoginService } from './login.service';
import { AlertModule, ButtonsModule } from 'ng2-bootstrap/ng2-bootstrap';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    AlertModule,
    ButtonsModule,
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [
    ExerciseService,
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
