import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Offering} from "../../offerings/offering.interface";

@Component({
  selector: 'pams-student-offering-list',
  templateUrl: './student-offering-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentOfferingListComponent {

  @Input() offerings: Offering[];
  @Output() view = new EventEmitter<Offering>();

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'course.code', label: 'Code'},
    {name: 'course.titleEn', label: 'TitleEn'},
    {name: 'program.code', label: 'Program'},
    {name: 'capacity.number', label: 'Capacity'},
    {name: 'course.credit', label: 'Credit'},
    {name: 'action', label: ''}
  ];
}
