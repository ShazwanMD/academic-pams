import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {MdTabsModule} from '@angular/material';
import {AcademicSession} from "../academic-session.interface";

@Component({
  selector: 'pams-session',
  templateUrl: 'session.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SessionComponent {

  @Input() academicSessions: AcademicSession;
  
  // @Output() addGuardian = new EventEmitter<Guardian>();
  // @Output() addGuarantor = new EventEmitter<Guarantor>();
  // @Output() addContact = new EventEmitter<Contact>();
  // @Output() addAddress = new EventEmitter<Address>();
}
