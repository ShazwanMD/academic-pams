import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy } from '@angular/core';
import { Assessment } from "../assessment.interface";

@Component({
  selector: 'pams-assessment',
  templateUrl: './assessment.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AssessmentComponent {

  @Input() assessment: Assessment;
  @Output() view = new EventEmitter<Assessment>();
}
