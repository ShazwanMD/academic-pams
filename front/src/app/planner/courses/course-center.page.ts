import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Course} from "./course.interface";
import {CourseActions} from "./course.action";
import {PlannerState} from "../index";

@Component({
  selector: 'pams-course-center',
  templateUrl: './course-center.page.html',
})

export class CourseCenterPage implements OnInit {

  private _commonService: CommonService;
  private _router: Router;
  private _route: ActivatedRoute;
  private _actions: CourseActions;
  private store: Store<PlannerState>;
  private courses$: Observable<Course[]>;

  constructor(router: Router,
              route: ActivatedRoute,
              actions: CourseActions,
              store: Store<PlannerState>,
              commonService: CommonService) {

    this._router = router;
    this._route = route;
    this._commonService = commonService;
    this._actions = actions;
    this.store = store;
    this.courses$ = this.store.select('courses');
  }

  goBack(route: string): void {
    this._router.navigate(['/courses']);
  }

  viewCourse(course: Course) {
    console.log("course: " + course.id);
    this._router.navigate(['/courses-detail', course.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this._actions.findCourses());
  }
}

