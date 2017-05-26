import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Offering} from "../offering.interface";

@Component({
  selector: 'pams-offering-list',
  templateUrl: './offering-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingListComponent {

  @Input() offerings: Offering[];
  @Output() view = new EventEmitter<Offering>();

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'code', label: 'Code'},
    {name: 'course.titleEn', label: 'TitleEn'},
    {name: 'program.code', label: 'Program'},
    {name: 'course.credit', label: 'Credit'},
    {name: 'action', label: ''}
  ];
}
