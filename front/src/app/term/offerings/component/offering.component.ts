import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Offering} from "../offering.interface";
import { Section } from '../../sections/section.interface';

@Component({
  selector: 'pams-offering',
  templateUrl: './offering.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingComponent {

  @Input() offering: Offering;

      private columns: any[] = [
    { name: 'id', label: 'Id' },
    { name: 'code', label: 'Code' },
    { name: 'capacity', label: 'Capacity' },
    { name: 'appointmentCount', label: 'Appointment' },
    { name: 'enrollmentCount', label: 'Enrollment' },
    { name: 'action', label: '' }
  ];


}

