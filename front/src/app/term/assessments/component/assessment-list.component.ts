import { commonModuleReducers } from './../../../common/index';
import { Assessment } from './../assessment.interface';
import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy } from '@angular/core';

@Component({
    selector: 'pams-assessment-list',
    templateUrl: './assessment-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})

export class AssessmentListComponent {
    @Input() assessments: Assessment[];
      @Output() view = new EventEmitter<Assessment>();

  private columns: any[] = [
    { name: 'code', label: 'Code' },
    { name: 'action', label: '' }
  ];


    // private columns: any[] = [
    //     { name: 'code', label: 'Code' },
    //     { name: 'canonicalCode', label: 'Canonical Code' },
    //     { name: 'Description', label: 'Description' },
    //     { name: 'assessment.session.code', label: 'Academic Session' },
    //     { name: 'assessment.offering.code', label: 'Offering' },
    //     { name: 'assessment.assessmentType', label: 'AssessmentType' },
    //     { name: 'action', label: '' }



    // ];
}