import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import { Section } from '../../sections/section.interface';

@Component({
  selector: 'pams-offering-section-list',
  templateUrl: './offering-section-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingSectionListComponent {

  @Input() sections: Section[];
  @Output() view = new EventEmitter<Section>();

      private columns: any[] = [
    { name: 'id', label: 'Id' },
    { name: 'code', label: 'Code' },
    { name: 'capacity', label: 'Capacity' },
    { name: 'appointmentCount', label: 'Appointment' },
    { name: 'enrollmentCount', label: 'Enrollment' },
    { name: 'action', label: '' }
  ];


}

