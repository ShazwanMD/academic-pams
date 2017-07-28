import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output} from '@angular/core';
import {Section} from '../../../../shared/model/term/section.interface';

@Component({
  selector: 'pams-section-list',
  templateUrl: './section-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SectionListComponent {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'code', label: 'Code'},
    {name: 'capacity', label: 'Capacity'},
    {name: 'canonicalCode', label: 'canonicalCode'},
    {name: 'action', label: ''},
  ];

  @Input() sections: Section[];
  @Output() view = new EventEmitter<Section>();

}
