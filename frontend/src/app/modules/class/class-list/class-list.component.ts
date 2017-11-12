import { Component, OnInit } from '@angular/core';
import { ClassService } from '../class.service';
import { Class } from '../../../models/class';

@Component({
  selector: 'app-class-list',
  templateUrl: './class-list.component.html',
  styleUrls: ['./class-list.component.scss'],
})
export class ClassListComponent implements OnInit {
  classes: Class[];

  constructor(private classService: ClassService) {
  }

  ngOnInit() {
    this.classService.getAll().subscribe(resp => {
      this.classes = resp;
    });
  }
}
