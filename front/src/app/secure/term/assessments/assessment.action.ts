import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AssessmentActions {

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


  static ADD_ASSESSMENT = '[Assessment] Add Assessment';

  addAssessment(offering, assessment): Action {
    return {
      type: AssessmentActions.ADD_ASSESSMENT,
      payload: {offering: offering, assessment: assessment}
    };
  }

  static ADD_ASSESSMENT_SUCCESS = '[Assessment] Add Assessment Success';

  addAssessmentSuccess(message): Action {
    return {
      type: AssessmentActions.ADD_ASSESSMENT_SUCCESS,
      payload: message
    };
  }

  static UPDATE_ASSESSMENT = '[Assessment] Update Assessment';

  updateAssessment(offering, assessment): Action {
    return {
      type: AssessmentActions.UPDATE_ASSESSMENT,
      payload: {offering: offering, assessment: assessment}
    };
  }

  static UPDATE_ASSESSMENT_SUCCESS = '[Assessment] Update Assessment Success';

  updateAssessmentSuccess(message): Action {
    return {
      type: AssessmentActions.UPDATE_ASSESSMENT_SUCCESS,
      payload: message
    };
  }

  static REMOVE_ASSESSMENT = '[Assessment] Remove Assessment';

  deleteAssessment(offering, assessment): Action {
    return {
      type: AssessmentActions.REMOVE_ASSESSMENT,
      payload: {offering: offering, assessment: assessment}
    };
  }

  static REMOVE_ASSESSMENT_SUCCESS = '[Assessment] Remove Assessment Success';

  deleteAssessmentSuccess(message): Action {
    return {
      type: AssessmentActions.REMOVE_ASSESSMENT_SUCCESS,
      payload: message
    };
  }

}
