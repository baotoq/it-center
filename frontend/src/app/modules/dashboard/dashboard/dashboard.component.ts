import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { LoadingService } from '../../../components/loading/loading.service';
import { OrderByPipe } from 'ngx-pipes/esm';
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
              private loadingService: LoadingService,
              private orderByPipe: OrderByPipe) {
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
    let data = this.orderByPipe.transform(popularSubjects, ['-numberOfRegistrations']);
    data = data.map(subject => [subject.name, subject.numberOfRegistrations]);

    return [
      ['Title', 'Number of registrations'],
      ...data.slice(0, 12)
    ];
  }
}
