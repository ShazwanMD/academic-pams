import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output} from '@angular/core';
import {ProgramLevel} from '../../../../shared/model/planner/program-level.interface';

@Component({
  selector: 'pams-program-level-list',
  templateUrl: './program-level-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ProgramLevelListComponent {

  private columns: any [] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''},

  ];

  @Input() programLevels: ProgramLevel[];
  @Output() view = new EventEmitter<ProgramLevel>();
}
