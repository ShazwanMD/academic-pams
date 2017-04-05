import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Cohort} from "../cohort.interface";

@Component({
  selector: 'pams-cohort-list',
  templateUrl: './cohort-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CohortListComponent {

  @Input() cohorts: Cohort[];
  @Output() view = new EventEmitter<Cohort>();

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];
}
