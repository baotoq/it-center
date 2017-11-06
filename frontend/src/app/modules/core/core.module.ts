import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared/shared.module';
import { NavbarComponent } from './navbar/navbar.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { CoreService } from './core.service';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    SharedModule,
  ],
  declarations: [
    NavbarComponent,
    SidenavComponent,
  ],
  exports: [
    NavbarComponent,
    SidenavComponent,
  ],
  providers: [
    CoreService,
  ],
})
export class CoreModule {
}
