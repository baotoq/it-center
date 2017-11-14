import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  template: `
    <div class="jumbotron jumbotron-fluid bg-primary text-white">
      <div class="d-flex justify-content-center">
        <h1 class="display-4">{{title}}</h1>
      </div>
    </div>
  `,
})
export class HeaderComponent implements OnInit {
  @Input() title: string;

  constructor() {
  }

  ngOnInit() {
  }

}
