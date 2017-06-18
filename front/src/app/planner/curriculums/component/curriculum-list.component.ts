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
    {name: 'core', label: 'Core Credit'},
    {name: 'curriculum', label: 'Curriculum Credit'},
    {name: 'elective', label: 'Elective Credit'},
    // {name: 'generalCredit', label: 'General Credit'},
    // {name: 'languageCredit', label: 'Language Credit'},
    // {name: 'otherCredit', label: 'Other Credit'},
    // {name: 'requiredCredit', label: 'Required Credit'},
    // {name: 'totalCredit', label: 'Total Credit'},
    // {name: 'ordinal', label: 'Ordinal'},
    // {name: 'program.code', label: 'Program'},
    // {name: 'program.titleMs', label: 'Title'},
    // {name: 'program.level.code', label: 'Level'},
    {name: 'action', label: ''},
  ];

  @Input() curriculums: Curriculum[];
  @Output() view = new EventEmitter<Curriculum>();

}
