import { Component, OnInit } from '@angular/core';
import { ClassService } from '../class.service';
import { Class, State } from '../../../models/class';
import { LoadingService } from '../../../components/loading/loading.service';
import { FilterByPipe } from 'ngx-pipes/esm';
import { User } from '../../../models/user';
import { AuthService } from '../../auth/auth.service';
import { Registration } from '../../../models/registration';

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

  constructor(private loadingService: LoadingService,
              private authService: AuthService,
              private classService: ClassService,
              private filterByPipe: FilterByPipe) {
  }

  ngOnInit() {
    this.loadingService.spinnerStart();
    this.classService.getAll()
      .subscribe(resp => {
        this.classes = resp;
        this.paginate();
        this.classService.getUserRegistration(this.currentUser.id)
          .finally(() => this.loadingService.spinnerStop())
          .subscribe(resp2 => {
            this.userRegistration = resp2;
            this.userRegistration.forEach(r => {
              this.classes.forEach(c => {
                if (c.id === r.attendedClass.id) {
                  c.state = State.REGISTERED;
                }
              });
            });
          });
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
    this.filteredData = this.filterByPipe.transform(this.classes, ['name', 'subject.name'], this.searchString);
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
}
