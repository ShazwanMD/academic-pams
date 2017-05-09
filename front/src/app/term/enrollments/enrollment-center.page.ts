import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Enrollment} from "./enrollment.interface";
import {EnrollmentActions} from "./enrollment.action";
import {TermModuleState} from "../index";

@Component({
  selector: 'pams-enrollment-center',
  templateUrl: './enrollment-center.page.html',
})
export class EnrollmentCenterPage implements OnInit {

  private ENROLLMENTS = "termModuleState.enrollments".split(".");
  private enrollments$: Observable<Enrollment[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentActions,
              private store: Store<TermModuleState>) {
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);
  }

  goBack(route: string): void {
    this.router.navigate(['/enrollments']);
  }

  viewEnrollment(enrollment: Enrollment) {
    console.log("enrollment: " + enrollment.id);
    this.router.navigate(['/enrollments-detail', enrollment.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findEnrollments());
  }
}

