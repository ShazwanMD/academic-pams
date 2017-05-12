import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {EnrollmentApplicationTask} from "../enrollment-application-task.interface";

@Component({
  selector: 'pams-enrollment-application-task-status',
  templateUrl: './enrollment-application-task-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class EnrollmentApplicationTaskStatusComponent {
  @Input() enrollmentApplicationTask: EnrollmentApplicationTask;
}
