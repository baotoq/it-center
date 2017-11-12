import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sequenceType',
})
export class SequenceTypePipe implements PipeTransform {

  transform(value: string, args?: any): string {
    switch (value) {
      case 'EVEN_DAYS':
        return '2-4-6';
      case 'ODD_DAYS':
        return '3-5-7';
      default:
        return 'INVALID SEQUENCE TYPE';
    }
  }
}
