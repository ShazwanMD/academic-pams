import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output} from '@angular/core';
import {Enrollment} from '../../../../shared/model/term/enrollment.interface';

@Component({
  selector: 'pams-enrollment-action',
  templateUrl: './enrollment-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EnrollmentActionComponent {

  @Input() enrollment: Enrollment;
  @Output() view = new EventEmitter<Enrollment>();
}
