import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy } from '@angular/core';
import { Enrollment } from "../../term/enrollments/enrollment.interface";

@Component({
  selector: 'pams-profile-enrollment-list',
  templateUrl: 'profile-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProfileEnrollmentListComponent {

  @Input() enrollments: Enrollment[];


  private columns: any[] = [
    { name: 'section.offering.code', label: 'Course Code' },
    { name: 'section.offering.course.credit', label: 'Credit' },
    { name: 'gradeCode.code', label: 'Grade' }
    ];
}
