import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Offering} from "../offering.interface";

@Component({
  selector: 'pams-offering',
  templateUrl: './offering.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingComponent {

  @Input() offering: Offering;
  @Output() view = new EventEmitter<Offering>();
}
