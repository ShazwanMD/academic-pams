import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Appointment} from "../appointment.interface";

@Component({
  selector: 'pams-appointment',
  templateUrl: './appointment.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AppointmentComponent {

  @Input() appointment: Appointment;
  @Output() view = new EventEmitter<Appointment>();
  // @Output() addComment = new EventEmitter<ProgramComment>();
  // @Output() addAttachment = new EventEmitter<ProgramAttachment>();
   
}
