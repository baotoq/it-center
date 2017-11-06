import { Component, OnInit } from '@angular/core';
import { LoadingService } from '../loading.service';

@Component({
  selector: 'app-progress-bar',
  template: `
    <mat-progress-bar *ngIf="progressBar" class="fixed-top" mode="indeterminate"></mat-progress-bar>
  `,
  styles: [`
    mat-progress-bar {
      z-index: 99999;
    }
  `],
})
export class ProgressBarComponent implements OnInit {
  progressBar = false;

  constructor(private loadingService: LoadingService) {
  }

  ngOnInit() {
    this.loadingService.progressBar.subscribe(val => this.progressBar = val);
  }
}
