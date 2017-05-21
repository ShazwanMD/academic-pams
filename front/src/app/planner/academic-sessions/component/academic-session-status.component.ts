import { AcademicSessionStatus } from '../academic-session-status.enum';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {AcademicSession} from "../academic-session.interface";

@Component({
  selector: 'pams-academic-session-status',
  templateUrl: 'academic-session-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class AcademicSessionStatusComponent {
  @Input() academicSession: AcademicSession;
  @Input() academicSessionStatus: AcademicSessionStatus;
}
