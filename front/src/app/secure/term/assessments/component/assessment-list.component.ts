import {Assessment} from '../../../../shared/model/term/assessment.interface';
import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'pams-assessment-list',
  templateUrl: './assessment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class AssessmentListComponent {

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'canonicalCode', label: 'Canonical Code'},
    {name: 'description', label: 'Description'},
    {name: 'assessmentType', label: 'Type'},
    {name: 'assessmentCategory', label: 'Category'},
    {name: 'offering.course.code', label: 'Course'},
    {name: 'offering.course.title', label: 'Type'},
    {name: 'action', label: ''}
  ];

  @Input() assessments: Assessment[];
  @Output() view = new EventEmitter<Assessment>();
}
