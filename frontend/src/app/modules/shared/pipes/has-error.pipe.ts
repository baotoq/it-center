import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'hasError',
})
export class HasErrorPipe implements PipeTransform {

  transform(value: any, args: string): boolean {
    if (value == null) {
      return false;
    }
    const keys = Object.keys(value);
    if (keys && keys.length > 0) {
      return keys[0] === args;
    }
    return false;
  }
}
