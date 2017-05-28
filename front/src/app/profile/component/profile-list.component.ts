import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Student} from "../../identity/student.interface";

@Component({
  selector: 'pams-profile-list',
  templateUrl: 'profile-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProfileListComponent {

  @Input() students: Student[];
  @Output() view = new EventEmitter<Student>();

  private columns: any[] = [
    {name: 'identityNo', label: 'MATRIC NO'},
    {name: 'name', label: 'NAME'},
    {name: 'email', label: 'EMAIL'},
    {name: 'action', label: ''}
  ];
}
