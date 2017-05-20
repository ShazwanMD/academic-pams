import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import { Section } from '../../sections/section.interface';
import {Appointment} from "../../appointments/appointment.interface";
import {Offering} from "../offering.interface";

@Component({
  selector: 'pams-offering-appointment-list',
  templateUrl: './offering-appointment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingAppointmentListComponent {

  @Input() offering: Offering;
  @Input() appointments: Appointment[];
  @Output() view = new EventEmitter<Section>();

      private columns: any[] = [
    { name: 'id', label: 'Id' },
    { name: 'action', label: '' }
  ];


}

