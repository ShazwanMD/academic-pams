import {ChangeDetectionStrategy, Component, Input} from '@angular/core';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {AcademicSessionStatus} from '../../../../shared/model/planner/academic-session-status.enum';

@Component({
  selector: 'pams-academic-session-status',
  templateUrl: 'academic-session-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class AcademicSessionStatusComponent {
  @Input() academicSession: AcademicSession;
  @Input() academicSessionStatus: AcademicSessionStatus;
}
