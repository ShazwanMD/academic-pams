import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Course} from "./course.interface";
import {CourseActions} from "./course.action";
import {PlannerModuleState} from "../index";

@Component({
  selector: 'pams-course-center',
  templateUrl: './course-center.page.html',
})

export class CourseCenterPage implements OnInit {

  private COURSES = "plannerModuleState.courses".split(".");
  private courses$: Observable<Course[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CourseActions,
              private store: Store<PlannerModuleState>) {

    this.courses$ = this.store.select(...this.COURSES);
  }

  filter(): void {
  }

  goBack(route: string): void {
    this.router.navigate(['/courses']);
  }

  viewCourse(course: Course) {
    console.log("course: " + course.id);
    this.router.navigate(['/courses-detail', course.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findCourses());
  }
}

