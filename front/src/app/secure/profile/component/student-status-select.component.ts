import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import { StudentStatus } from '../../../shared/model/profile/student-status.enum';

@Component({
  selector: 'pams-student-status-select',
  templateUrl: './student-status-select.component.html',
})
export class StudentStatusSelectComponent implements OnInit {

  private studentStatusess: StudentStatus[] = <StudentStatus[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in StudentStatus) {
      if (typeof StudentStatus[n] === 'string')
        this.studentStatusess.push(StudentStatus[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: StudentStatus) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

