import { Component, OnInit } from '@angular/core';
import { Class } from '../../../models/class';
import { Registration } from '../../../models/registration';
import { ClassService } from '../class.service';
import { ActivatedRoute } from '@angular/router';
import { LoadingService } from '../../../components/loading/loading.service';
import { AuthService } from '../../auth/auth.service';
import { Role } from '../../../models/role';
import { CoreService } from '../../core/core.service';

@Component({
  selector: 'app-class-detail',
  templateUrl: './class-detail.component.html',
  styleUrls: ['./class-detail.component.scss'],
})
export class ClassDetailComponent implements OnInit {
  class: Class;
  registrations: Registration[];
  role = Role;
  edit = false;
  pattern = '^(10|[0-9]$)';

  constructor(private route: ActivatedRoute,
              private authService: AuthService,
              private loadingService: LoadingService,
              private classService: ClassService,
              private coreService: CoreService) {
  }

  ngOnInit() {
    this.loadingService.spinnerStart();
    this.classService.get(this.route.snapshot.params['classId'])
      .finally(() => this.loadingService.spinnerStop())
      .subscribe(resp => {
        this.class = resp;
        this.classService.getClassRegistration(this.class.id)
          .finally(() => this.loadingService.spinnerStop())
          .subscribe(resp2 => {
            this.registrations = resp2;
          });
      });
  }

  onSave() {
    this.loadingService.spinnerStart();
    this.classService.updatePoint(this.registrations)
      .subscribe(() => {
        this.coreService.notifySuccess();
        this.ngOnInit();
      });
    this.edit = false;
  }

  onCancel() {
    this.edit = false;
    this.ngOnInit();
  }

  isValid() {
    const pattern = new RegExp(this.pattern);
    let result = true;
    this.registrations.forEach(item => {
      if (!pattern.test(item.absent.toString())) result = false;
      if (!pattern.test(item.late.toString())) result = false;
      if (!pattern.test(item.grade.toString())) result = false;
    });
    return result;
  }

  get authenticated() {
    return this.authService.isAuthenticated();
  }

  get currentUser() {
    return this.authService.currentUser();
  }
}
