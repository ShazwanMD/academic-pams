import { Course } from './../course.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';

@Component({
  selector: 'pams-course-status',
  templateUrl: 'course-status.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class CourseStatusComponent {
  @Input() course: Course;
}



