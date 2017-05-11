import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Enrollment} from "../enrollment.interface";

@Component({
  selector: 'pams-enrollment-list',
  templateUrl: './enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EnrollmentListComponent {

  @Input() enrollments: Enrollment[];
  @Output() view = new EventEmitter<Enrollment>();

  private columns: any[] = [
    {name: 'student.name', label: 'Student Name'},
    {name: 'section.code', label: 'Section'},
    {name: 'section.offering.course.title', label: 'Course Title'},
    {name: 'section.offering.program.code', label: 'Program'},
    {name: 'admission.cohort.code', label: 'Cohort'},
    {name: 'admission.cgpa', label: 'CGPA'},
    {name: 'action', label: ''}
  ];
}
