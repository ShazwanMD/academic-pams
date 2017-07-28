import {Injectable} from '@angular/core';
import {Actions, Effect} from '@ngrx/effects';
import {EnrollmentActions} from './enrollment.action';
import {TermService} from '../../../../services/term.service';
import {Store} from '@ngrx/store';
import {SectionActions} from '../sections/section.action';
import {Section} from '../../../shared/model/term/section.interface';
import {TermModuleState} from '../index';
import {from} from 'rxjs/observable/from';

@Injectable()
export class EnrollmentEffects {

  private SECTION: string[] = 'termModuleState.section'.split('.');

  constructor(private actions$: Actions,
              private enrollmentActions: EnrollmentActions,
              private sectionActions: SectionActions,
              private termService: TermService,
              private store$: Store<TermModuleState>) {
  }

  @Effect() findEnrollmentById$ = this.actions$
    .ofType(EnrollmentActions.FIND_ENROLLMENT_BY_ID)
    .map((action) => action.payload)
    .switchMap((id) => this.termService.findEnrollmentById(id))
    .map((enrollment) => this.enrollmentActions.findEnrollmentByIdSuccess(enrollment))
    .mergeMap((action) => from([action,
      this.enrollmentActions.findGradebooksByEnrollment(action.payload)]));

  //update enrollment by section
  @Effect() updateEnrollment$ = this.actions$
    .ofType(EnrollmentActions.UPDATE_ENROLLMENT)
    .map((action) => action.payload)
    .switchMap((payload) => this.termService.updateEnrollment(payload.section, payload.enrollment))
    .map((message) => this.enrollmentActions.updateEnrollmentSuccess(message))
    .withLatestFrom(this.store$.select(...this.SECTION))
    .map((state) => state[1])
    //.mergeMap(action => from([action, this.appointmentActions.findAppointments()]));
    .map((section: Section) => this.sectionActions.findSectionByCanonicalCode(section.canonicalCode));

  //find gradebooksbyenrollment
  @Effect() findGradebooksByEnrollment$ = this.actions$
    .ofType(EnrollmentActions.FIND_GRADEBOOKS_BY_ENROLLMENT)
    .map((action) => action.payload)
    .switchMap((enrollment) => this.termService.findGradebooksByEnrollment(enrollment))
    .map((enrollments) => this.enrollmentActions.findGradebooksByEnrollmentSuccess(enrollments));

}
