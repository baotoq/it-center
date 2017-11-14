import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { MaterialModule } from './modules/material/material.module';
import { FontAwesomeSpinnerComponent } from './components/font-awesome-spinner/font-awesome-spinner.component';
import { HasErrorPipe } from './pipes/has-error.pipe';
import { FilterByPipe, OrderByPipe } from 'ngx-pipes/esm';
import { ClickStopPropagationDirective } from './directives/click-stop-propagation/click-stop-propagation.directive';
import { MaterialSpinnerComponent } from './components/material-spinner/material-spinner.component';
import { RequestService } from './services/request.sevice';
import { PeriodOrderPipe } from './pipes/period-order.pipe';
import { SequenceTypePipe } from './pipes/sequence-type.pipe';
import { HeaderComponent } from './components/header/header.component';

const COMPONENTS = [
  FontAwesomeSpinnerComponent,
  MaterialSpinnerComponent,
  HeaderComponent,
];

const PIPES = [
  HasErrorPipe,
  PeriodOrderPipe,
  SequenceTypePipe,
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
    DatePipe,
    RequestService,
  ],
})
export class SharedModule {
}
