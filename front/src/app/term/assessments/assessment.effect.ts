import { TermModuleState } from './../index';
import { OfferingActions } from './../offerings/offering.action';
import { Offering } from './../offerings/offering.interface';
import { Store } from '@ngrx/store';
import { AssessmentActions } from './assessment.action';
import { Injectable } from '@angular/core';
import { Effect, Actions } from '@ngrx/effects';
import { TermService } from "../../../services/term.service";


@Injectable()
export class AssessmentEffects {
    private OFFERING: string[] = "termModuleState.offering".split(".");

    constructor(
        private actions$: Actions,
        private assessmentActions: AssessmentActions,
        private offeringActions: OfferingActions,
        private store$: Store<TermModuleState>,
        private termService: TermService) {
    }


    @Effect() addAssessment$ =
    this.actions$
        .ofType(AssessmentActions.ADD_ASSESSMENT)
        .map(action => action.payload)
        .switchMap(payload => this.termService.addAssessment(payload.offering, payload.assessment))
        .map(message => this.assessmentActions.addAssessmentSuccess(message))
        .withLatestFrom(this.store$.select(...this.OFFERING))
        .map(state => state[1])
        .map((offering: Offering) => this.offeringActions.findOfferingByCanonicalCode(offering.canonicalCode));



}
