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

  @Effect() findEnrollmentById$ = this.actions$
    .ofType(EnrollmentActions.FIND_ENROLLMENT_BY_ID)
    .map(action => action.payload)
    .switchMap(id => this.termService.findEnrollmentById(id))
    .map(enrollment => this.enrollmentActions.findEnrollmentByIdSuccess(enrollment));


}
