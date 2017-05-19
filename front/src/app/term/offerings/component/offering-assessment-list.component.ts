import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import { Assessment } from '../../assessments/assessment.interface';

@Component({
  selector: 'pams-offering-assessment-list',
  templateUrl: './offering-assessment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingAssessmentListComponent {

  @Input() assessments: Assessment[];
  @Output() view = new EventEmitter<Assessment>();

      private columns: any[] = [
    { name: 'id', label: 'Id' },
    { name: 'code', label: 'Code' },
    { name: 'action', label: '' }
  ];


}

