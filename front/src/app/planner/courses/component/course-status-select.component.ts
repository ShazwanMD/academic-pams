
import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import { CourseStatus } from '../../../shared/model/planner/course-status.enum';

@Component({
  selector: 'pams-course-status-select',
  templateUrl: './course-status-select.component.html',
})
export class CourseStatusSelectComponent implements OnInit {

  private courseStatuss: CourseStatus[] = <CourseStatus[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in CourseStatus) {
      if (typeof CourseStatus[n] === 'string')
        this.courseStatuss.push(CourseStatus[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: CourseStatus) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
