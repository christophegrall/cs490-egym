import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { CommonModule } from '@angular/common';

import { LocalStorageService, LOCAL_STORAGE_SERVICE_CONFIG } from 'angular-2-local-storage';
import { AlertModule, ButtonsModule } from 'ng2-bootstrap/ng2-bootstrap';
import { LoginService } from './login.service';
import { LoginComponent } from './login.component';
import { LoginRoutingModule } from './login-routing.module';

let localStorageServiceConfig = {
    prefix: 'egym',
    storageType: 'localStorage'
};

@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    AlertModule,
    ButtonsModule,
    FormsModule,
    HttpModule,
    CommonModule,
    LoginRoutingModule
  ],
  providers: [
    LoginService,
    LocalStorageService,
    {
      provide: LOCAL_STORAGE_SERVICE_CONFIG, useValue: localStorageServiceConfig
    }
  ]
})
export class LoginModule { }
