import {ChangeDetectionStrategy, Component, Input} from '@angular/core';
import {Student} from '../../../shared/model/identity/student.interface';

@Component({
  selector: 'pams-profile-status',
  templateUrl: 'profile-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class ProfileStatusComponent {
  @Input() profile: Student;
  
}
