import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AssessmentActions{

      static FIND_ASSESSMENTS = '[Assessment] Find Assessments';
  findAssessments(): Action {
    return {
      type: AssessmentActions.FIND_ASSESSMENTS
    };
  }

  static FIND_ASSESSMENTS_SUCCESS = '[Assessment] Find Assessments Success';
  findAssessmentsSuccess(assessments): Action {
    return {
      type: AssessmentActions.FIND_ASSESSMENTS_SUCCESS,
      payload: assessments
    };
  }

}