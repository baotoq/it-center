import { Pipe, PipeTransform } from '@angular/core';
import { periodOrderToString } from '../util';

@Pipe({
  name: 'periodOrder',
})
export class PeriodOrderPipe implements PipeTransform {

  transform(value: string, args?: any): string {
    return periodOrderToString(value);
  }
}
