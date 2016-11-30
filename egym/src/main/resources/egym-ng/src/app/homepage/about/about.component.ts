import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from 'angular-2-local-storage';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  constructor(
    private localStorageService: LocalStorageService
  ) { }

  logout(): void {
    if(this.localStorageService.get('token')) {
      this.localStorageService.remove('token');
    }
  }

  ngOnInit() {
  }

}
