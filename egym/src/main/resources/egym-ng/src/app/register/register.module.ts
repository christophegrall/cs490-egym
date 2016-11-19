import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AlertModule, ButtonsModule, ModalModule } from 'ng2-bootstrap/ng2-bootstrap';
import { RegisterService } from './register.service';
import { RegisterComponent } from './register.component';
import { RegisterRoutingModule } from './register-routing.module';

@NgModule({
  declarations: [
    RegisterComponent
  ],
  imports: [
    AlertModule,
    ButtonsModule,
    FormsModule,
    HttpModule,
    ModalModule,
    RegisterRoutingModule
  ],
  providers: [
    RegisterService
  ]
})
export class RegisterModule { }
