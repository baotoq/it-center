import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <app-progress-bar></app-progress-bar>
    <app-navbar></app-navbar>
    <div class="app position-relative">
      <app-spinner></app-spinner>
      <router-outlet></router-outlet>
      <div style="height: 100px"></div>
    </div>
    <ng-snotify></ng-snotify>
  `,
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  constructor() {
  }

  ngOnInit() {
  }
}
