import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Program} from "../program.interface";

@Component({
  selector: 'pams-program-list',
  templateUrl: './program-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramListComponent {

  @Input() programs: Program[];
  @Output() view = new EventEmitter<Program>();

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'titleMs', label: 'TitleMs'},
    {name: 'action', label: ''}
  ];
}
