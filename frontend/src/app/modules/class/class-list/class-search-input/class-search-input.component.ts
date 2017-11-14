import { Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-class-search-input',
  templateUrl: './class-search-input.component.html',
  styleUrls: ['./class-search-input.component.scss'],
})
export class ClassSearchInputComponent implements OnInit {
  search = false;
  searchControl = new FormControl();
  @ViewChild('searchInput') searchInput: ElementRef;

  @Input() loading = false;
  @Input() disabled = false;
  @Output() searchOut = new EventEmitter<any>();
  @Output() confirm = new EventEmitter<any>();

  constructor() {
  }

  ngOnInit() {
    this.searchControl.setValue('');
  }

  onSearchFocus() {
    this.search = true;
    this.searchInput.nativeElement.focus();
  }

  onSearchOut() {
    this.search = false;
    this.searchOut.emit(this.searchControl.value);
  }
}
