import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {ProgramLevel} from "../program-level.interface";

@Component({
  selector: 'pams-program-level-list',
  templateUrl: './program-level-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ProgramLevelListComponent {

  @Input() programLevels: ProgramLevel[];
  @Output() view = new EventEmitter<ProgramLevel>();

  private columns: any [] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''},

  ];
}
