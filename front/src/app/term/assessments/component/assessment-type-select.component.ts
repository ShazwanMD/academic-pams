import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {AssessmentType} from '../assessment-type.enum';

@Component({
  selector: 'pams-assessment-type-select',
  templateUrl: './assessment-type-select.component.html',
  styleUrls: ['./assessment-type-select.component.scss'],
})
export class AssessmentTypeSelectComponent implements OnInit {

  private assessmentTypes: AssessmentType[] = <AssessmentType[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in AssessmentType) {
      if (typeof AssessmentType[n] === 'string')
        this.assessmentTypes.push(AssessmentType[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: AssessmentType) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
