import {Program} from '../../../../shared/model/planner/program.interface';
import {ChangeDetectionStrategy, Component, Input} from '@angular/core';

@Component({
  selector: 'pams-program-status',
  templateUrl: 'program-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class ProgramStatusComponent {
  @Input() program: Program;
}
