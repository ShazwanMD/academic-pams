import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Enrollment} from "./enrollment.interface";
import {EnrollmentActions} from "./enrollment.action";
import {TermModuleState} from "../index";

@Component({
  selector: 'pams-enrollment-detail',
  templateUrl: './enrollment-detail.page.html',
})

export class EnrollmentDetailPage implements OnInit {

  private ENROLLMENT = "termModuleState.enrollment".split(".");
  private enrollment$: Observable<Enrollment>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentActions,
              private store: Store<TermModuleState>) {

    this.enrollment$ = this.store.select(...this.ENROLLMENT);
  }

  ngOnInit(): void {
      this.route.params.subscribe((params: {id: string}) => {
          let id: string = params.id;
          this.store.dispatch(this.actions.findEnrollmentById(id));

// this.route.params.subscribe((params: {id: string}) => {
 //     let id: string = params.id;
    //  this.store.dispatch(this.actions.findEnrollmentByCanonicalCode(canonicalCode));

      });
  }


  goBack(route: string): void {
    this.router.navigate(['/enrollments']);
  }
}

