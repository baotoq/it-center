import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { LoadingService } from '../../../components/loading/loading.service';

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
  loading = false;

  chartData = {
    chartType: 'ColumnChart',
    dataTable: [],
    options: {
      isStacked: true,
      hAxis: {title: 'Registrations'},
      height: '500',
      chartArea: {
        width: '90%',
      },
      animation: {
        startup: true,
        easing: 'inAndOut',
        duration: 1000,
      },
      legend: {position: 'top', maxLines: 3},
    },
  };

  constructor(private dashboardService: DashboardService,
              private loadingService: LoadingService) {
  }

  ngOnInit() {
    this.loadingService.spinnerStart();
    this.numberOfStudents = this.dashboardService.countStudents();
    this.numberOfClasses = this.dashboardService.countClasses();
    this.numberOfSubjects = this.dashboardService.countSubjects();
    this.numberOfRooms = this.dashboardService.countRooms();

    this.loading = true;
    this.dashboardService.getChartData()
      .finally(() => this.loadingService.spinnerStop())
      .subscribe(resp => {
        this.chartData.dataTable = this.prepareDataTable(resp);
        this.loading = false;
      });
  }

  private prepareDataTable(popularSubjects) {
    const data = popularSubjects
      .map(subject => [subject.name, subject.numberOfRegistrations])
      .sort((r1: [string, number], r2: [string, number]) => r2[1] - r1[1]);

    return [
      ['Title', 'Number of registrations'],
      ...data.slice(0, 12)
    ];
  }
}
