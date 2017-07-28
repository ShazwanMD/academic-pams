import { ChangeDetectionStrategy, Component, Input } from '@angular/core';
import { Faculty } from '../../../../shared/model/planner/faculty.interface';

@Component({
  selector: 'pams-faculty-status',
  templateUrl: 'faculty-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})

export class FacultyStatusComponent {
    @Input() faculty: Faculty;
}
