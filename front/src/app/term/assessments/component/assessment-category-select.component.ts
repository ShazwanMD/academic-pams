import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {AssessmentCategory} from "../assessment-category.enum";


@Component({
  selector: 'pams-assessment-category-select',
  templateUrl: './assessment-category-select.component.html',
})
export class AssessmentCategorySelectComponent implements OnInit {

  private assessmentCategorys: AssessmentCategory[] = <AssessmentCategory[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (var n in AssessmentCategory) {
      if(typeof AssessmentCategory[n] === 'string')
        this.assessmentCategorys.push(AssessmentCategory[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: AssessmentCategory) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

