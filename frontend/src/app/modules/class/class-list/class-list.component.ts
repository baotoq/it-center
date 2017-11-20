import { Component, OnInit } from '@angular/core';
import { ClassService } from '../class.service';
import { Class, State } from '../../../models/class';
import { LoadingService } from '../../../components/loading/loading.service';
import { FilterByPipe } from 'ngx-pipes/esm';
import { User } from '../../../models/user';
import { AuthService } from '../../auth/auth.service';
import { Registration } from '../../../models/registration';
import { CoreService } from '../../core/core.service';
import { Role } from '../../../models/role';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-class-list',
  templateUrl: './class-list.component.html',
  styleUrls: ['./class-list.component.scss'],
})
export class ClassListComponent implements OnInit {
  classes: Class[];
  filteredData: Class[];
  pagedData: Class[];
  pageSize = 10;
  page = 1;
  searchString: string;
  userRegistration: Registration[];
  loading = false;
  state = State;
  role = Role;
  filter = new FormControl(0);

  constructor(private loadingService: LoadingService,
              private coreService: CoreService,
              private authService: AuthService,
              private classService: ClassService,
              private filterByPipe: FilterByPipe) {
  }

  ngOnInit() {
    this.filter = new FormControl(0);
    this.filter.valueChanges.subscribe(() => {
      this.paginate();
    });
    this.loadingService.spinnerStart();
    this.classService.getAll()
      .subscribe(resp => {
        this.classes = resp;
        this.paginate();
        this.classes.forEach(c => {
          if (new Date(c.startedAt) <= new Date()) c.state = State.ENDED;
          if (c.numberOfStudents >= c.room.capacity) c.state = State.FULL;
        });
        if (this.authenticated) {
          this.classService.getUserRegistration(this.currentUser.id)
            .finally(() => this.loadingService.spinnerStop())
            .subscribe(resp2 => {
              this.userRegistration = resp2;
              this.userRegistration.forEach(r => {
                this.classes.forEach(c => {
                  if (c.id === r.attendedClass.id) {
                    if (r.invoice.confirmed) c.state = State.CONFIRMED;
                    else c.state = State.REGISTERED;
                  }
                });
              });
            });
        } else {
          this.loadingService.spinnerStop();
        }
      });
  }

  onPageChange($event) {
    this.paginate();
  }

  onSearchOut($event) {
    this.searchString = $event;
    this.paginate();
  }

  paginate() {
    const startIndex = (this.page - 1) * this.pageSize;
    if (!this.filter.value) this.filteredData = this.classes;
    else {
      if (this.filter.value === 1) this.filteredData = this.classes.filter(i => i.state !== State.ENDED && i.state !== State.FULL && i.state !== State.CONFIRMED && i.state !== State.REGISTERED);
      if (this.filter.value === 2) this.filteredData = this.classes.filter(i => i.state === State.CONFIRMED || i.state === State.REGISTERED);
    }
    this.filteredData = this.filterByPipe.transform(this.filteredData, ['name', 'subject.name'], this.searchString);
    this.pagedData = this.filteredData.slice(startIndex, startIndex + this.pageSize);
  }

  get selectedClasses() {
    return this.filterByPipe.transform(this.classes, ['selected'], true);
  }

  onConfirm() {
    this.loading = true;
    if (this.selectedClasses.length) {
      this.classService.createInvoice(this.selectedClasses)
        .finally(() => this.loading = false)
        .subscribe(() => {
          this.coreService.notifySuccess();
          this.ngOnInit();
        });
    }
  }

  register(selectedClass: Class) {
    selectedClass.selected = true;
  }

  cancel(selectedClass: Class) {
    selectedClass.selected = false;
  }

  get currentUser(): User {
    return this.authService.currentUser();
  }

  get authenticated() {
    return this.authService.isAuthenticated();
  }
}
