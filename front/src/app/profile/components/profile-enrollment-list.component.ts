import { Enrollment } from './../../term/enrollments/enrollment.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';

@Component({
  selector: 'pams-profile-enrollment-list',
  templateUrl: 'profile-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProfileEnrollmentListComponent {

  @Input() enrollments: Enrollment[];
  @Output() view = new EventEmitter<Enrollment>();

  private columns: any[] = [
    {name: 'admission.cohort.code', label: 'COHORT'},
    {name: 'section.offering.course.faculty.name', label: 'FACULTY'},
    {name: 'section.offering.program.code', label: 'PROGRAM'},
    {name: 'section.offering.course.code', label: 'COURSE'},
    
    {name: 'action', label: ''}
  ];
}
