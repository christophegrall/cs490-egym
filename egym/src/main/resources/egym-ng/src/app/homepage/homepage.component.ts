import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { LocalStorageService } from 'angular-2-local-storage';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(
    private router: Router,
    private localStorageService: LocalStorageService
  ) { }

  ngOnInit() {
    if(!this.localStorageService.get('token')) {
      this.router.navigate(['login']);
    } else {
      console.log(this.localStorageService.get('token'));
    }
  }

}
