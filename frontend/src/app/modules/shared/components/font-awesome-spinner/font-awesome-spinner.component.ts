import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-fa-spinner',
  template: `
    <i class="fa fa-spinner fa-pulse fa-{{size}}x fa-fw"></i>
  `,
})
export class FontAwesomeSpinnerComponent implements OnInit {
  @Input() size = 1;

  constructor() {
  }

  ngOnInit() {
  }

}
