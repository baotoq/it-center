import { Component, OnInit } from '@angular/core';
import { LoadingService } from '../loading.service';

@Component({
  selector: 'app-spinner',
  template: `
    <app-material-spinner *ngIf="spinner"></app-material-spinner>
  `,
})
export class SpinnerComponent implements OnInit {
  spinner = false;

  constructor(private loadingService: LoadingService) {
  }

  ngOnInit() {
    this.loadingService.spinner.subscribe(val => this.spinner = val);
  }
}
