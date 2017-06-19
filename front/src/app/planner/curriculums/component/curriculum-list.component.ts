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
    {name: 'coreCredit.number', label: 'Core Credit'},
    {name:'totalCredit.number', label:'Total Credit'},
    //{name:'maxPeriod.number', label:'Max Period'},
    // {name: 'curriculumCredit.number', label: 'Curriculum Credit'},
    //{name: 'electiveCredit.number', label: 'Elective Credit'},
    //{name: 'generalCredit', label: 'General Credit'},
    // {name: 'languageCredit', label: 'Language Credit'},
    // {name: 'otherCredit', label: 'Other Credit'},
    // {name: 'requiredCredit', label: 'Required Credit'},
 
    // {name: 'ordinal', label: 'Ordinal'},
    //{name: 'program.code', label: 'Program'},
    {name: 'action', label: ''},
  ];

  @Input() curriculums: Curriculum[];
  @Output() view = new EventEmitter<Curriculum>();

}
