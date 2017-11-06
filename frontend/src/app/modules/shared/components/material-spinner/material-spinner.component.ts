import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-material-spinner',
  template: `
    <div class="overlay">
      <div class="d-flex justify-content-center align-items-center h-100">
        <mat-spinner [diameter]="diameter" [strokeWidth]="strokeWidth"></mat-spinner>
      </div>
    </div>
  `,
  styleUrls: ['./material-spinner.component.scss'],
})
export class MaterialSpinnerComponent implements OnInit {
  @Input() diameter = 50;
  @Input() strokeWidth = 4;
  width: string;

  constructor() {
  }

  ngOnInit() {
  }
}
