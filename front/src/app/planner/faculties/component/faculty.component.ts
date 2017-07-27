import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Faculty} from '../../../shared/model/planner/faculty.interface';

@Component({
  selector: 'pams-faculty',
  templateUrl: 'faculty.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class FacultyComponent {

  @Input() faculty: Faculty;
}
