import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Program} from "../program.interface";

@Component({
  selector: 'pams-program',
  templateUrl: './program.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramComponent {

  @Input() program: Program;
}
