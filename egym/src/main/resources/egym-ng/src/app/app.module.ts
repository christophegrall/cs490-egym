import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ExerciseService } from './exercise.service';
import { AlertModule, ButtonsModule } from 'ng2-bootstrap/ng2-bootstrap';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    AlertModule,
    ButtonsModule,
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [ExerciseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
