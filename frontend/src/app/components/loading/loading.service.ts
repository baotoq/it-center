import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Injectable()
export class LoadingService {
  spinner = new BehaviorSubject<boolean>(false);
  progressBar = new BehaviorSubject<boolean>(false);

  constructor() {
  }

  spinnerStart = () => this.spinner.next(true);
  spinnerStop = () => this.spinner.next(false);

  progressBarStart = () => this.progressBar.next(true);
  progressBarStop = () => this.progressBar.next(false);
}
