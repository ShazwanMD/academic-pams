import { Program } from '../../../shared/model/planner/program.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';

@Component({
  selector: 'pams-program-status',
  templateUrl: 'program-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class ProgramStatusComponent {
  @Input() program: Program;
}
