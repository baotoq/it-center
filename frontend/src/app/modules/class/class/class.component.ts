import { Component, OnInit } from '@angular/core';
import { ClassService } from '../class.service';
import { Class } from '../../../models/class';

@Component({
  selector: 'app-class',
  templateUrl: './class.component.html',
  styleUrls: ['./class.component.scss'],
})
export class ClassComponent implements OnInit {
  class: Class;

  constructor(private classService: ClassService) {
  }

  ngOnInit() {
    this.classService.get(1).subscribe(resp => {
      this.class = resp;
      console.log(resp);
    });
  }

}
