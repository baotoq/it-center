import { Injectable } from '@angular/core';
import { SnotifyService, SnotifyToastConfig } from 'ng-snotify';

@Injectable()
export class CoreService {

  snotifyToastConfig = {
    toast: {
      showProgressBar: false,
      closeOnClick: false,
    },
  };

  constructor(private snotifyService: SnotifyService) {
    this.snotifyService.setDefaults(this.snotifyToastConfig);
  }

  notifySuccess(message?: string, title = 'Success', config?: SnotifyToastConfig) {
    this.snotifyService.clear();
    this.snotifyService.success(message, title, config);
  }

  notifyError(message?: string, title = 'Error', config?: SnotifyToastConfig) {
    this.snotifyService.clear();
    this.snotifyService.error(message, title, config);
  }
}
