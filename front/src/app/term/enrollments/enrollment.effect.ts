import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {EnrollmentActions} from "./enrollment.action";
import {TermService} from "../../../services/term.service";


@Injectable()
export class EnrollmentEffects {
  constructor(private actions$: Actions,
              private enrollmentActions: EnrollmentActions,
              private termService: TermService,) {
  }

  @Effect() findEnrollments$ = this.actions$
    .ofType(EnrollmentActions.FIND_ENROLLMENTS)
    .switchMap(() => this.termService.findEnrollments())
    .map(enrollments => this.enrollmentActions.findEnrollmentsSuccess(enrollments));

 
}
