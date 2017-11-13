import { Component, OnInit } from '@angular/core';
import { ClassService } from '../class.service';
import { Class } from '../../../models/class';
import { LoadingService } from '../../../components/loading/loading.service';
import { FilterByPipe } from 'ngx-pipes/esm';

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

  constructor(private loadingService: LoadingService,
              private classService: ClassService,
              private filterByPipe: FilterByPipe) {
  }

  ngOnInit() {
    this.loadingService.spinnerStart();
    this.classService.getAll()
      .finally(() => this.loadingService.spinnerStop())
      .subscribe(resp => {
        this.classes = resp;
        this.paginate();
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
}
