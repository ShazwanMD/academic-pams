import {ChangeDetectionStrategy, Component, Input} from '@angular/core';
import {Cohort} from '../../../shared/model/planner/cohort.interface';

@Component({
  selector: 'pams-profile-cohort',
  templateUrl: 'profile-cohort.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProfileCohortComponent {

  @Input() cohort: Cohort;
}
