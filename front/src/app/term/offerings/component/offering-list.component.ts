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
    {name: 'code', label: 'Code'},
    {name: 'canonicalCode', label: 'Canonical Code'},
    {name: 'action', label: ''}
  ];
}
