import { Component, OnInit } from '@angular/core';
import { ClassService } from '../class.service';
import { Class } from '../../../models/class';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoadingService } from '../../../components/loading/loading.service';
import { DatePipe } from '@angular/common';
import { Room } from '../../../models/room';
import { RoomService } from '../../room/room.service';
import { CoreService } from '../../core/core.service';
import { Subject } from '../../../models/subject';
import { SubjectService } from '../../subject/subject.service';

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
  subjects: Subject[];

  private periodOrders = [
    {key: 'FIRST', value: '6:50 - 9:15'},
    {key: 'SECOND', value: '9:25 - 11:50'},
    {key: 'THIRD', value: '12:30 - 14:55'},
    {key: 'FOURTH', value: '15:05 - 17:30'},
    {key: 'FIFTH', value: '17:45 - 21:00'},
  ];

  private sequenceTypes = [
    {key: 'EVEN_DAYS', value: '2 - 4 - 6'},
    {key: 'ODD_DAYS', value: '3 - 5 - 7'},
  ];

  constructor(private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private loadingService: LoadingService,
              private coreService: CoreService,
              private subjectService: SubjectService,
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
    this.subjectService.getAll().subscribe(resp => this.subjects = resp);
  }

  private createForm() {
    this.classForm = this.formBuilder.group({
      name: [this.class.name, [Validators.required]],
      subject: [this.class.subject.id, Validators.required],
      room: [this.class.room.id, Validators.required],
      price: [this.class.price, Validators.required],
      startedAt: [this.formatDate2(this.class.startedAt), [Validators.required, Validators.pattern(/\d{4}-\d{2}-\d{2}/)]],
      endedAt: [this.formatDate2(this.class.endedAt), [Validators.required, Validators.pattern(/\d{4}-\d{2}-\d{2}/)]],
      capacity: [this.class.room.capacity, Validators.required],
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
      startedAt: this.formatDate(this.classForm.controls['startedAt'].value),
      endedAt: this.formatDate(this.classForm.controls['endedAt'].value),
      price: this.classForm.controls['price'].value,
      lecturer: this.classForm.controls['lecturer'].value,
      room: {id: this.classForm.controls['room'].value},
      subject: {id: this.classForm.controls['subject'].value},
      period: {
        periodOrder: this.classForm.controls['periodOrder'].value,
        sequenceType: this.classForm.controls['sequenceType'].value,
      },
    });
    this.loadingService.spinnerStart();
    this.classService.update(this.class.id, c)
      .finally(() => this.loadingService.spinnerStop())
      .subscribe(() => {
        this.coreService.notifySuccess();
        this.classForm.disable();
        this.edit = false;
      }, () => this.coreService.notifyError());
  }

  formatDate(model) {
    return this.datePipe.transform(model, 'yyyy-MM-dd\'T\'HH:mm:ss');
  }

  formatDate2(model) {
    return this.datePipe.transform(model, 'yyyy-MM-dd');
  }
}
