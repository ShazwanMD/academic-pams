import {Component, Input, ChangeDetectionStrategy} from '@angular/core';
import {Curriculum} from '../../../shared/model/planner/curriculum.interface';

@Component({
  selector: 'pams-curriculum',
  templateUrl: './curriculum.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class CurriculumComponent {

  @Input() curriculum: Curriculum;


}
