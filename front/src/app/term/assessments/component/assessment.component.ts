import { Assessment } from './../assessment.interface';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy } from '@angular/core';



@Component({
  selector: 'pams-assessment',
  templateUrl: './assessment.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AssessmentComponent {

  @Input() assessment: Assessment;
  @Output() view = new EventEmitter<Assessment>();

}
