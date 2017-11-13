import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MomentModule } from 'angular2-moment';
import { NgPipesModule } from 'ngx-pipes';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SharedModule } from '../shared/shared.module';

import { ClassRoutingModule } from './class-routing.module';
import { ClassComponent } from './class/class.component';
import { ClassService } from './class.service';
import { ClassListComponent } from './class-list/class-list.component';
import { ClassSearchInputComponent } from './class-list/class-search-input/class-search-input.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MomentModule,
    NgPipesModule,
    NgbModule,
    SharedModule,
    ClassRoutingModule,
  ],
  declarations: [ClassComponent, ClassListComponent, ClassSearchInputComponent],
  providers: [ClassService],
})
export class ClassModule {
}
