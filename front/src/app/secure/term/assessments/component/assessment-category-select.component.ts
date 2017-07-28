import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {AssessmentCategory} from '../../../../shared/model/term/assessment-category.enum';

@Component({
  selector: 'pams-assessment-category-select',
  templateUrl: './assessment-category-select.component.html',
  styleUrls: ['./assessment-category-select.component.scss'],

})
export class AssessmentCategorySelectComponent implements OnInit {

  private assessmentCategorys: AssessmentCategory[] = <AssessmentCategory[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in AssessmentCategory) {
      if (typeof AssessmentCategory[n] === 'string')
        this.assessmentCategorys.push(AssessmentCategory[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: AssessmentCategory) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

