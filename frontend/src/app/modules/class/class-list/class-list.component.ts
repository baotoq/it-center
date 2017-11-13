import { Component, OnInit } from '@angular/core';
import { ClassService } from '../class.service';
import { Class } from '../../../models/class';
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
            this.userRegistration.forEach(item => {
              this.classes.forEach(item2 => {
                if (item2.id == item.attendedClass.id)
                  item2.registered = true;
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

  onConfirm() {
    const selectedClasses = this.filterByPipe.transform(this.classes, ['selected'], true);
    this.classService.createInvoice(selectedClasses)
      .subscribe(() => {
        this.ngOnInit();
      });
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
