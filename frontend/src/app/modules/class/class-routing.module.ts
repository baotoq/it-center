import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClassComponent } from './class/class.component';
import { ClassListComponent } from './class-list/class-list.component';
import { ClassDetailComponent } from './class-detail/class-detail.component';

const routes: Routes = [
  {
    path: '',
    component: ClassListComponent,
  },
  {
    path: 'detail/:classId',
    component: ClassDetailComponent,
  },
  {
    path: ':classId',
    component: ClassComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ClassRoutingModule {
}
