import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HomepageComponent } from './homepage.component';

@NgModule({
  imports: [
    RouterModule.forChild([
        {
            path: 'home',
            component: HomepageComponent
        }
    ])
  ],
  exports: [
    RouterModule
  ]
})

export class HomepageRoutingModule { }
