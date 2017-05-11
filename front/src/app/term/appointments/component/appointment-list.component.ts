import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Appointment} from "../appointment.interface";

@Component({
  selector: 'pams-appointment-list',
  templateUrl: './appointment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AppointmentListComponent {

  @Input() appointments: Appointment[];
  @Output() view = new EventEmitter<Appointment>();

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'staff.name', label: 'Staf Name'},
    {name: 'section.code', label: 'Section'},
    {name: 'session.code', label: 'Academic Session'},
    {name: 'session.description', label: 'Offering'},
    {name: 'course.title', label: 'Course Name'},
    {name: 'action', label: ''}
  ];
}
