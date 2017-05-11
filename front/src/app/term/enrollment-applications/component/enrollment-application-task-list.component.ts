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
    {name: 'description', label: 'Description'},
    {name: 'flowState', label: 'Status'},
    {name: 'action', label: ''}
  ];
}
