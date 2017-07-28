import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy } from '@angular/core';
import { Enrollment } from '../../../shared/model/term/enrollment.interface';

@Component({
  selector: 'pams-profile-enrollment-list',
  templateUrl: 'profile-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProfileEnrollmentListComponent {

  private columns: any[] = [
    { name: 'admission.academicSession.code', label: 'Semester' },
    { name: 'section.offering.code', label: 'Course Code' },
    { name: 'section.offering.course.credit', label: 'Credit' },
    { name: 'gradeCode.code', label: 'Grade' },
    ];

  @Input() enrollments: Enrollment[];
}
