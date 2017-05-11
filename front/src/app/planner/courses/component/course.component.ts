import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {MdTabsModule} from '@angular/material';
import {Course} from "../course.interface";

@Component({
  selector: 'pams-course',
  templateUrl: 'course.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CourseComponent {

  @Input() course: Course;
}
