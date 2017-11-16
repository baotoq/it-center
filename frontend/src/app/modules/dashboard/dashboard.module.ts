import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MomentModule } from 'angular2-moment';
import { NgPipesModule } from 'ngx-pipes';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SharedModule } from '../shared/shared.module';
import { DashboardService } from './dashboard.service';
import { WidgetComponent } from './dashboard/widget/widget.component';
import { Ng2GoogleChartsModule } from 'ng2-google-charts';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MomentModule,
    NgPipesModule,
    NgbModule,
    Ng2GoogleChartsModule,
    SharedModule,
    DashboardRoutingModule,
  ],
  declarations: [DashboardComponent, WidgetComponent],
  providers: [DashboardService],
})
export class DashboardModule {
}
