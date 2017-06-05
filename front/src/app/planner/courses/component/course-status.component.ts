import { Course } from './../course.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {CourseStatus} from "../course-status.enum";

@Component({
  selector: 'pams-course-status',
  templateUrl: 'course-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class CourseStatusComponent {
  @Input() course: Course;
  @Input() courseStatus: CourseStatus;
}



