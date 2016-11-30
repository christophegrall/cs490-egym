import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HomepageComponent } from './homepage.component';
import { AboutComponent } from './about/about.component';
import { ExerciseDetailComponent } from './exercise-detail/exercise-detail.component';
import { ExerciseListComponent } from './exercise-list/exercise-list.component';

@NgModule({
  imports: [
    RouterModule.forChild([
        {
            path: 'home',
            component: HomepageComponent,
            children: [
              {
                path: "",
                outlet: 'list',
                component: ExerciseListComponent
              },
              {
                path: ':id',
                outlet: 'detail',
                component: ExerciseDetailComponent
              }
            ]
        },
        {
          path: 'about',
          component: AboutComponent
        }
    ])
  ],
  exports: [
    RouterModule
  ]
})

export class HomepageRoutingModule { }
