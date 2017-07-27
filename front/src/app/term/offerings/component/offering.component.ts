import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Offering} from '../../../shared/model/term/offering.interface';

@Component({
  selector: 'pams-offering',
  templateUrl: './offering.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingComponent {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'code', label: 'Code'},
    {name: 'capacity', label: 'Capacity'},
    {name: 'appointmentCount', label: 'Appointment'},
    {name: 'enrollmentCount', label: 'Enrollment'},
    {name: 'action', label: ''},
  ];

  @Input() offering: Offering;
}

