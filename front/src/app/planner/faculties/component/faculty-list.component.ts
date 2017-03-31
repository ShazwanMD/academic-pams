import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Faculty} from "../faculty.interface";

@Component({
  selector: 'pams-faculty-list',
  templateUrl: './faculty-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class FacultyListComponent {

  @Input() faculties: Faculty[];
  @Output() view = new EventEmitter<Faculty>();

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'name', label: 'Name'},
    {name: 'action', label: ''}
  ];
}
