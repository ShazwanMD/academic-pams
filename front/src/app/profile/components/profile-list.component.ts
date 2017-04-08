import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Student} from "../../identity/student.interface";

@Component({
  selector: 'pams-profile-list',
  templateUrl: 'profile-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProfileListComponent {

  @Input() profiles: Student[];
  @Output() view = new EventEmitter<Student>();

  private columns: any[] = [
    {name: 'identityNo', label: 'matricNo'},
    {name: 'name', label: 'Name'},
    {name: 'email', label: 'Email'},
    {name: 'action', label: ''}
  ];
}
