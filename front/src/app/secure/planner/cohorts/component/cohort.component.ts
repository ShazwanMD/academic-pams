import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Cohort} from '../../../../shared/model/planner/cohort.interface';

@Component({
  selector: 'pams-cohort',
  templateUrl: './cohort.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CohortComponent {

  @Input() cohort: Cohort;
}
