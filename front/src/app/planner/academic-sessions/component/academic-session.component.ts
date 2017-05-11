import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {MdTabsModule} from '@angular/material';
import {AcademicSession} from "../academic-session.interface";

@Component({
  selector: 'pams-academic-session',
  templateUrl: 'academic-session.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AcademicSessionComponent {

  @Input() academicSession: AcademicSession;
}
