import {Course} from '../../../../shared/model/planner/course.interface';
import {ChangeDetectionStrategy, Component, Input} from '@angular/core';

@Component({
  selector: 'pams-course-classification',
  templateUrl: 'course-classification.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class CourseClassificationComponent {
  @Input() course: Course;
}
