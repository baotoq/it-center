import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MomentModule } from 'angular2-moment';
import { NgPipesModule } from 'ngx-pipes';
import { SharedModule } from '../shared/shared.module';

import { ClassRoutingModule } from './class-routing.module';
import { ClassComponent } from './class/class.component';
import { ClassService } from './class.service';
import { ClassListComponent } from './class-list/class-list.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MomentModule,
    NgPipesModule,
    SharedModule,
    ClassRoutingModule,
  ],
  declarations: [ClassComponent, ClassListComponent],
  providers: [ClassService],
})
export class ClassModule {
}
