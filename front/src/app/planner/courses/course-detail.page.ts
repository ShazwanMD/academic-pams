import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Course} from '../../shared/model/planner/course.interface';
import {CourseActions} from './course.action';
import {PlannerModuleState} from '../index';

@Component({
  selector: 'pams-course-detail',
  templateUrl: './course-detail.page.html',
})

export class CourseDetailPage implements OnInit {

  private COURSE: string[] = 'plannerModuleState.course'.split('.');
  private course$: Observable<Course>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CourseActions,
              private store: Store<PlannerModuleState>) {
    this.course$ = this.store.select(...this.COURSE);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findCourseByCode(code));
    });
  }

 // goBack(route: string): void {
   // this.router.navigate(['/courses']);
  }

