import { Component, OnInit } from '@angular/core';
import { ClassService } from '../class.service';
import { Class } from '../../../models/class';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoadingService } from '../../../components/loading/loading.service';
import { DatePipe } from '@angular/common';
import { Room } from '../../../models/room';
import { RoomService } from '../../room/room.service';

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
              private roomService: RoomService,
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
    this.roomService.getAll().subscribe(resp => this.rooms = resp);
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
      periodOrder: [this.class.period.periodOrder, Validators.required],
      sequenceType: [this.class.period.sequenceType, Validators.required],
    });
    this.classForm.disable();
  }

  onEdit() {
    this.edit = true;
    this.classForm.enable();
  }

  onSave() {
    let c = new Class({
      name: this.classForm.controls['name'].value,
      startedAt: this.classForm.controls['startedAt'].value,
      endedAt: this.classForm.controls['endedAt'].value,
      capacity: this.classForm.controls['capacity'].value,
      lecturer: this.classForm.controls['lecturer'].value,
      room: {id: this.classForm.controls['room'].value},
      period: {
        periodOrder: this.classForm.controls['periodOrder'].value,
        sequenceType: this.classForm.controls['sequenceType'].value,
      },
    });
    this.classService.update(this.class.id, c).subscribe();
  }
}
