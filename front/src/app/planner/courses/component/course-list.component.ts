import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Course} from "../course.interface";
import { PlannerModuleState } from './../../index';
import { Observable } from 'rxjs';
import { CourseActions } from './../course.action';
import { Store } from '@ngrx/store';

@Component({
  selector: 'pams-course-list',
  templateUrl: './course-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CourseListComponent {

   private COURSE:string[] = "plannerModuleState.bankCodes".split(".");
   private courses$: Observable<Course>;
    @Input() courses: Course[];
    @Output() view = new EventEmitter<Course>();

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'titleEn', label: 'Title(En)'},
    {name: 'titleMs', label: 'Title(Ms)'},
    {name: 'credit', label: 'Credit'},
    {name: 'action', label: ''}
  ];

   constructor(private store: Store<PlannerModuleState>,
              private actions: CourseActions) {
    this.courses$ = this.store.select(...this.COURSE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findCourses());

  }

  filter(): void {
  }
}
