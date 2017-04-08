import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Student} from "../../identity/student.interface";

@Component({
  selector: 'pams-profile-status',
  templateUrl: 'profile-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class ProfileStatusComponent {
  @Input() profile: Student;
}
