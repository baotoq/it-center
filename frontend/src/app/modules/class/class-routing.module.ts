import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClassComponent } from './class/class.component';
import { ClassListComponent } from './class-list/class-list.component';

const routes: Routes = [
  {
    path: '',
    component: ClassListComponent,
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
