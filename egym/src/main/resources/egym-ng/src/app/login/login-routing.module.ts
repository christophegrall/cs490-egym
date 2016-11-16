import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { LoginComponent } from './login.component';

@NgModule({
  imports: [
    RouterModule.forChild([
        {
            path: '',
            redirectTo: '/login',
            pathMatch: 'full'
        },
        {
            path: 'login',
            component: LoginComponent
        }
    ])
  ],
  exports: [
    RouterModule
  ]
})

export class LoginRoutingModule { }
