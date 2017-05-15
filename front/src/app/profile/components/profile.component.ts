import { Guardian } from './../guardian.interface';
import { Guarantor } from './../guarantor.interface';
import { Address } from './../address.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Student} from "../../identity/student.interface";
import {MdTabsModule} from '@angular/material';

@Component({
  selector: 'pams-profile',
  templateUrl: 'profile.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ProfileComponent {

  @Input() profile: Student;
<<<<<<< HEAD
  @Input() addressess: Address[];
  @Input() guarantors: Guarantor[];
  @Input() guardians: Guardian[];
=======
  
>>>>>>> c1e4978e2e5bfafbca7e5803c263f6b4e042215a
  // @Output() addGuardian = new EventEmitter<Guardian>();
  // @Output() addGuarantor = new EventEmitter<Guarantor>();
  // @Output() addContact = new EventEmitter<Contact>();
  // @Output() addAddress = new EventEmitter<Address>();
}