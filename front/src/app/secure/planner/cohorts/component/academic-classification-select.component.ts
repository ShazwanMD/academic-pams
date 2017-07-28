import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {AcademicClassification} from '../../../../shared/model/planner/academic-classification.enum';

@Component({
  selector: 'pams-academic-classification',
  templateUrl: './academic-classification-select.component.html',
})
export class AcademicClassificationSelectComponent implements OnInit {

  private academicClassifications: AcademicClassification[] = <AcademicClassification[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in AcademicClassification) {
      if (typeof AcademicClassification[n] === 'string')
        this.academicClassifications.push(AcademicClassification[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: AcademicClassification) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
