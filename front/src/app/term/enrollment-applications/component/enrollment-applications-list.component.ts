import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {EnrollmentApplication} from "../enrollment-application.interface";

@Component({
  selector: 'pams-enrollment-applications-list',
  templateUrl: './enrollment-applications-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EnrollmentApplicationsListComponent {

  @Input() enrollmentApplications: EnrollmentApplication[];
  @Output() view = new EventEmitter<EnrollmentApplication>();

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'action', label: ''}
  ];
}
