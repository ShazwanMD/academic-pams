import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Curriculum} from '../curriculum.interface';

@Component({
  selector: 'pams-curriculum-list',
  templateUrl: './curriculum-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CurriculumListComponent {

  // todo: credithours, etc etc
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'action', label: ''},
  ];

  @Input() curriculums: Curriculum[];
  @Output() view = new EventEmitter<Curriculum>();

}
