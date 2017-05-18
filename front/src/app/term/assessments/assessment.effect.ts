import { AssessmentActions } from './assessment.action';
import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {TermService} from "../../../services/term.service";

@Injectable()
export class AssessmentEffects{
    constructor(
        private actions$: Actions,
        private assessmentActions: AssessmentActions,
        private termService: TermService,){

    }

      @Effect() findAssessments$ = this.actions$
      .ofType(AssessmentActions.FIND_ASSESSMENTS)
      .switchMap(() => this.termService.findAssessments())
      .map(assessments => this.assessmentActions.findAssessmentsSuccess(assessments));
}