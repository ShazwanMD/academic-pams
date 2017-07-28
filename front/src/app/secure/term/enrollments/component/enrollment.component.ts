import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Enrollment} from '../../../../shared/model/term/enrollment.interface';

@Component({
  selector: 'pams-enrollment',
  templateUrl: './enrollment.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EnrollmentComponent {

  @Input() enrollment: Enrollment;
  @Output() view = new EventEmitter<Enrollment>();
}
