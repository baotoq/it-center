import { Component, OnInit } from '@angular/core';
import { ClassService } from '../class.service';
import { Class } from '../../../models/class';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoadingService } from '../../../components/loading/loading.service';
import { DatePipe } from '@angular/common';
import { Room } from '../../../models/room';

@Component({
  selector: 'app-class',
  templateUrl: './class.component.html',
  styleUrls: ['./class.component.scss'],
})
export class ClassComponent implements OnInit {
  class: Class;
  classForm: FormGroup;
  edit = false;
  rooms: Room[];

  constructor(private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private loadingService: LoadingService,
              private classService: ClassService,
              private datePipe: DatePipe) {
  }

  ngOnInit() {
    this.loadingService.spinnerStart();
    this.classService.get(this.route.snapshot.params['classId'])
      .finally(() => this.loadingService.spinnerStop())
      .subscribe(resp => {
        this.class = resp;
        this.createForm();
      });
  }

  private createForm() {
    this.classForm = this.formBuilder.group({
      name: [this.class.name, [Validators.required]],
      subject: [this.class.subject.name, Validators.required],
      room: [this.class.room.id, Validators.required],
      startedAt: [this.datePipe.transform(this.class.startedAt, 'MM/dd/yyyy'), Validators.required],
      endedAt: [this.datePipe.transform(this.class.endedAt, 'MM/dd/yyyy'), Validators.required],
      capacity: [this.class.capacity, Validators.required],
      numberOfStudents: [this.class.numberOfStudents, Validators.required],
      lecturer: [this.class.lecturer, Validators.required],
    });
  }

  onEdit() {
    this.edit = true;
  }
}
