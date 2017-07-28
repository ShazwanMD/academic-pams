import {CourseClassification} from '../../../../shared/model/planner/course-classification.enum';

import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'pams-course-classification-select',
  templateUrl: './course-classification-select.component.html',
})
export class CourseClassificationSelectComponent implements OnInit {

  private courseClassifications: CourseClassification[] = <CourseClassification[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in CourseClassification) {
      if (typeof CourseClassification[n] === 'string')
        this.courseClassifications.push(CourseClassification[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: CourseClassification) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

