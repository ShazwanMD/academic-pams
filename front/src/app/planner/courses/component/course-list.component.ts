import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Course} from "../course.interface";

@Component({
  selector: 'pams-course-list',
  templateUrl: './course-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CourseListComponent {

  @Input() courses: Course[];
  @Output() view = new EventEmitter<Course>();

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'titleMs', label: 'Title'},
    {name: 'credit', label: 'Credit'},
    {name: 'action', label: ''}
  ];
}
