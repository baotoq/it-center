import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-widget',
  templateUrl: './widget.component.html',
  styleUrls: ['./widget.component.scss'],
})
export class WidgetComponent implements OnInit {
  @Input() numberOfStudents = 0;
  @Input() numberOfClasses = 0;
  @Input() numberOfSubjects = 0;
  @Input() numberOfRooms = 0;

  constructor() {
  }

  ngOnInit() {
  }

}
