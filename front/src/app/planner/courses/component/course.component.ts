import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {MdTabsModule} from '@angular/material';
import {Course} from "../course.interface";
import {CourseStatus} from "../course-status.enum";

@Component({
  selector: 'pams-course',
  templateUrl: 'course.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CourseComponent {

  @Input() course: Course;
  @Input() courseStatus: CourseStatus;
  
}
