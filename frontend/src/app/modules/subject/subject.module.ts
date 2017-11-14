import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SubjectRoutingModule } from './subject-routing.module';
import { SubjectService } from './subject.service';

@NgModule({
  imports: [
    CommonModule,
    SubjectRoutingModule,
  ],
  declarations: [],
  providers: [SubjectService],
})
export class SubjectModule {
}
