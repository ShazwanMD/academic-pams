import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Section} from "../section.interface";

@Component({
  selector: 'pams-section-list',
  templateUrl: './section-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SectionListComponent {

  @Input() sections: Section[];
  @Output() view = new EventEmitter<Section>();

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'code', label: 'Code'},
    {name: 'capacity', label: 'Capacity'},
    {name: 'canonicalCode', label: 'canonicalCode'},
    {name: 'action', label: ''}
  ];
}
