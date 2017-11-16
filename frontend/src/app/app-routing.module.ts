import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './guards/auth.guard';
import { AdminGuard } from './guards/admin.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'class',
    pathMatch: 'full',
  },
  {
    path: 'auth',
    loadChildren: 'app/modules/auth/auth.module#AuthModule',
  },
  {
    path: 'class',
    loadChildren: 'app/modules/class/class.module#ClassModule',
  },
  {
    path: 'dashboard',
    loadChildren: 'app/modules/dashboard/dashboard.module#DashboardModule',
    canActivate: [AuthGuard, AdminGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
