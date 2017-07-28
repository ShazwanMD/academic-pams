import {TermModuleState} from '../index';
import {OfferingActions} from '../offerings/offering.action';
import {Offering} from '../../../shared/model/term/offering.interface';
import {Store} from '@ngrx/store';
import {AssessmentActions} from './assessment.action';
import {Injectable} from '@angular/core';
import {Actions, Effect} from '@ngrx/effects';
import {TermService} from '../../../../services/term.service';

@Injectable()
export class AssessmentEffects {
  private OFFERING: string[] = 'termModuleState.offering'.split('.');

  constructor(private actions$: Actions,
              private assessmentActions: AssessmentActions,
              private offeringActions: OfferingActions,
              private store$: Store<TermModuleState>,
              private termService: TermService) {
  }

  @Effect() findAssessmentById$ = this.actions$
    .ofType(AssessmentActions.FIND_ASSESSMENT_BY_ID)
    .map((action) => action.payload)
    .switchMap((id) => this.termService.findAssessmentById(id))
    .map((assessment) => this.assessmentActions.findAssessmentByIdSuccess(assessment));

  @Effect() addAssessment$ = this.actions$
    .ofType(AssessmentActions.ADD_ASSESSMENT)
    .map((action) => action.payload)
    .switchMap((payload) => this.termService.addAssessment(payload.offering, payload.assessment))
    .map((message) => this.assessmentActions.addAssessmentSuccess(message))
    .withLatestFrom(this.store$.select(...this.OFFERING))
    .map((state) => state[1])
    .map((offering: Offering) => this.offeringActions.findOfferingByCanonicalCode(offering.canonicalCode));

  @Effect() updateAssessment$ = this.actions$
    .ofType(AssessmentActions.UPDATE_ASSESSMENT)
    .map((action) => action.payload)
    .switchMap((payload) => this.termService.updateAssessment(payload.offering, payload.assessment))
    .map((message) => this.assessmentActions.updateAssessmentSuccess(message))
    .withLatestFrom(this.store$.select(...this.OFFERING))
    .map((state) => state[1])
    .map((offering: Offering) => this.offeringActions.findOfferingByCanonicalCode(offering.canonicalCode));

  @Effect() deleteAssessment$ = this.actions$
    .ofType(AssessmentActions.REMOVE_ASSESSMENT)
    .map((action) => action.payload)
    .switchMap((payload) => this.termService.deleteAssessment(payload.offering, payload.assessment))
    .map((message) => this.assessmentActions.deleteAssessmentSuccess(message))
    .withLatestFrom(this.store$.select(...this.OFFERING))
    .map((state) => state[1])
    .map((offering: Offering) => this.offeringActions.findOfferingByCanonicalCode(offering.canonicalCode));
}

