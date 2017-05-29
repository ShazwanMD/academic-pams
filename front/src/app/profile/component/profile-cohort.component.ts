import {Enrollment} from './../../term/enrollments/enrollment.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Cohort} from "../../planner/cohorts/cohort.interface";
import {Student} from "../../identity/student.interface";

@Component({
  selector: 'pams-profile-cohort',
  templateUrl: 'profile-cohort.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProfileCohortComponent {

  @Input() cohort: Cohort;
}
