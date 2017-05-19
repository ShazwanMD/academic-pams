import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AssessmentActions{

  static FIND_ASSESSMENT_BY_ID = '[Assessment] Find Assessment By Id';

  findAssessmentById(assessment): Action {
    return {
      type: AssessmentActions.FIND_ASSESSMENT_BY_ID,
      payload: assessment
    };
  }

  static FIND_ASSESSMENT_BY_ID_SUCCESS = '[Assessment] Find Assessment By Id Success';

  findAssessmentByIdSuccess(assessment): Action {
    return {
      type: AssessmentActions.FIND_ASSESSMENT_BY_ID_SUCCESS,
      payload: assessment
    };
  }

}
