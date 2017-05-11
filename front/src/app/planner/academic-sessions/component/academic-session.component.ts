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
  
  // @Output() addGuardian = new EventEmitter<Guardian>();
  // @Output() addGuarantor = new EventEmitter<Guarantor>();
  // @Output() addContact = new EventEmitter<Contact>();
  // @Output() addAddress = new EventEmitter<Address>();
}
