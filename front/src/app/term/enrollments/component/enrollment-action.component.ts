import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Enrollment} from "../enrollment.interface";

@Component({
  selector: 'pams-enrollment-action',
  templateUrl: './enrollment-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EnrollmentActionComponent {

  @Input() enrollment: Enrollment;
  @Output() view = new EventEmitter<Enrollment>();
}
