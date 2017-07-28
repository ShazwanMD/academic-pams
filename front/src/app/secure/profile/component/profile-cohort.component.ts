import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Cohort} from '../../../shared/model/planner/cohort.interface';
import {Student} from '../../../shared/model/identity/student.interface';

@Component({
  selector: 'pams-profile-cohort',
  templateUrl: 'profile-cohort.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProfileCohortComponent {

  @Input() cohort: Cohort;
}
