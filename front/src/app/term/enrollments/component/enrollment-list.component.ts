import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Enrollment} from "../enrollment.interface";

@Component({
  selector: 'pams-enrollment-list',
  templateUrl: './enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EnrollmentListComponent {

  @Input() enrollments: Enrollment[];
  @Output() view = new EventEmitter<Enrollment>();

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'student.name', label: 'Id'},
    {name: 'student.identityNo', label: 'Id'},
    {name: 'student.email', label: 'Id'},
    {name: 'action', label: ''}
  ];
}
