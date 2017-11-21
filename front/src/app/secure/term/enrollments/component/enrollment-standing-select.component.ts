import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {EnrollmentStanding} from '../../../../shared/model/term/enrollment-standing.enum';

@Component({
  selector: 'pams-enrollment-standing-select',
  templateUrl: './enrollment-standing-select.component.html',
})
export class EnrollmentStandingSelectComponent implements OnInit {

  private enrollmentStandings: EnrollmentStanding[] = <EnrollmentStanding[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in EnrollmentStanding) {
      if (typeof EnrollmentStanding[n] === 'string')
        this.enrollmentStandings.push(EnrollmentStanding[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: EnrollmentStanding) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

