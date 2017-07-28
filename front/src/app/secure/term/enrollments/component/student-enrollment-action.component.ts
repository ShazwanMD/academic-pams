import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Enrollment} from '../../../../shared/model/term/enrollment.interface';

@Component({
  selector: 'pams-student-enrollment-action',
  templateUrl: './student-enrollment-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentEnrollmentActionComponent {

  @Input() enrollment: Enrollment;
  @Output() view = new EventEmitter<Enrollment>();
}
