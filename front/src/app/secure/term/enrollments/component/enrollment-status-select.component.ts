import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {EnrollmentStatus} from '../../../../shared/model/term/enrollment-status.enum';

@Component({
  selector: 'pams-enrollment-status-select',
  templateUrl: './enrollment-status-select.component.html',
})
export class EnrollmentStatusSelectComponent implements OnInit {

  private enrollmentStatuss: EnrollmentStatus[] = <EnrollmentStatus[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in EnrollmentStatus) {
      if (typeof EnrollmentStatus[n] === 'string')
        this.enrollmentStatuss.push(EnrollmentStatus[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: EnrollmentStatus) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

