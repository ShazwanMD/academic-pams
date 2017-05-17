import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {EnrollmentApplicationTask} from "../enrollment-application-task.interface";

@Component({
  selector: 'pams-enrollment-application-task-list',
  templateUrl: './enrollment-application-task-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EnrollmentApplicationTaskListComponent {

  @Input() enrollmentApplicationTasks: EnrollmentApplicationTask[];
  @Output() view = new EventEmitter<EnrollmentApplicationTask>();

  private columns: any[] = [
    {name: 'referenceNo', label: 'ReferenceNo'},
    {name: 'sourceNo', label: 'sourceNo'},
    {name: 'description', label: 'Description'},
    {name: 'metaState', label: 'State'},
    {name: 'application.cancelComment', label: 'cancelComment'},
    {name: 'action', label: ''}
  ];
}
