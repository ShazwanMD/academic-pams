import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Enrollment} from "../../term/enrollments/enrollment.interface";

@Component({
  selector: 'pams-profile-enrollment-list',
  templateUrl: 'profile-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProfileEnrollmentListComponent {

  @Input() enrollments: Enrollment[];
}
