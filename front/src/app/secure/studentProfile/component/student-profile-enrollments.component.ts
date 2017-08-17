import {ChangeDetectionStrategy, Component, Input} from '@angular/core';
import {Enrollment} from '../../../shared/model/term/enrollment.interface';

@Component({
  selector: 'pams-student-profile-enrollments',
  templateUrl: 'student-profile-enrollments.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentProfileEnrollmentsComponent {

  private columns: any[] = [
    {name: 'admission.academicSession.code', label: 'Semester'},
    {name: 'section.offering.code', label: 'Course Code'},
    {name: 'section.offering.course.credit', label: 'Credit'},
    {name: 'gradeCode.code', label: 'Grade'},
  ];

  @Input() enrollments: Enrollment[];
}
