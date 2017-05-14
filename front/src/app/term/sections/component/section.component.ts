import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Section} from "../section.interface";

@Component({
  selector: 'pams-section',
  templateUrl: './section.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SectionComponent {

  @Input() section: Section;
  @Output() view = new EventEmitter<Section>();
}
