import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {EnrollmentApplication} from '../../../shared/model/term/enrollment-application.interface';

@Component({
  selector: 'pams-enrollment-applications-list',
  templateUrl: './enrollment-applications-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EnrollmentApplicationsListComponent {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'action', label: ''},
  ];

  @Input() enrollmentApplications: EnrollmentApplication[];
  @Output() view = new EventEmitter<EnrollmentApplication>();

}
