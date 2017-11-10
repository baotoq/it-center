import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from './modules/material/material.module';
import { FontAwesomeSpinnerComponent } from './components/font-awesome-spinner/font-awesome-spinner.component';
import { HasErrorPipe } from './pipes/has-error.pipe';
import { FilterByPipe, OrderByPipe } from 'ngx-pipes/esm';
import { ClickStopPropagationDirective } from './directives/click-stop-propagation/click-stop-propagation.directive';
import { MaterialSpinnerComponent } from './components/material-spinner/material-spinner.component';
import { RequestService } from './services/request.sevice';

const COMPONENTS = [
  FontAwesomeSpinnerComponent,
  MaterialSpinnerComponent,
];

const PIPES = [
  HasErrorPipe,
];

const DIRECTIVES = [
  ClickStopPropagationDirective,
];

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
  ],
  declarations: [COMPONENTS, PIPES, DIRECTIVES],
  exports: [COMPONENTS, PIPES, DIRECTIVES, MaterialModule],
  providers: [
    PIPES,
    OrderByPipe,
    FilterByPipe,
    RequestService,
  ],
})
export class SharedModule {
}
