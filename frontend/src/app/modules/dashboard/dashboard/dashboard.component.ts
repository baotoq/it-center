import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent implements OnInit {
  numberOfStudents;
  numberOfClasses;
  numberOfSubjects;
  numberOfRooms;

  constructor(private dashboardService: DashboardService) {
  }

  ngOnInit() {
    this.numberOfStudents = this.dashboardService.countStudents();
    this.numberOfClasses = this.dashboardService.countClasses();
    this.numberOfSubjects = this.dashboardService.countSubjects();
    this.numberOfRooms = this.dashboardService.countRooms();
  }

}
