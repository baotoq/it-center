import { Component, HostListener, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <app-progress-bar></app-progress-bar>
    <app-navbar (sidenavToggle)="sidenav.toggle()" class="fixed-top"></app-navbar>
    <mat-sidenav-container fullscreen>
      <mat-sidenav #sidenav [mode]="smallScreen ? 'over' : 'side'" [opened]="!smallScreen">
        <app-sidenav (selectChange)="sidenavSelectChange()"></app-sidenav>
      </mat-sidenav>
      <app-spinner></app-spinner>
      <router-outlet></router-outlet>
      <div [style.height.px]="60"></div>
    </mat-sidenav-container>
    <ng-snotify></ng-snotify>
  `,
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  smallScreen = false;

  @ViewChild('sidenav') sidenav;

  @HostListener('window:resize')
  onResize() {
    this.smallScreen = window.innerWidth < 960;
  }

  constructor() {
    this.onResize();
  }

  ngOnInit() {
  }

  sidenavSelectChange() {
    if (this.smallScreen) {
      this.sidenav.close();
    }
  }
}
