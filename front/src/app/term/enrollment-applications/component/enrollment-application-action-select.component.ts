import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {EnrollmentApplicationAction} from "../enrollment-application-action.enum";


@Component({
  selector: 'pams-enrollment-application-action-select',
  templateUrl: './enrollment-application-action-select.component.html',
  styleUrls: ['./enrollment-application-action-select.scss'],
})
export class EnrollmentApplicationActionSelectComponent implements OnInit {

  private enrollmentApplicationActions: EnrollmentApplicationAction[] = <EnrollmentApplicationAction[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (var n in EnrollmentApplicationAction) {
      if (typeof EnrollmentApplicationAction[n] === 'string')
        this.enrollmentApplicationActions.push(EnrollmentApplicationAction[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: EnrollmentApplicationAction) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

