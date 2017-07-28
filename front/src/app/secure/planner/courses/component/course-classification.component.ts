import { Course } from '../../../../shared/model/planner/course.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';

@Component({
  selector: 'pams-course-classification',
  templateUrl: 'course-classification.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class CourseClassificationComponent {
  @Input() course: Course;
}
