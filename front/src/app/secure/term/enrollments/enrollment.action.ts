import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class EnrollmentActions {

  static FIND_ENROLLMENT_BY_ID = '[Enrollment] Find Enrollment By Id';

  findEnrollmentById(enrollment): Action {
    return {
      type: EnrollmentActions.FIND_ENROLLMENT_BY_ID,
      payload: enrollment
    };
  }

  static FIND_ENROLLMENT_BY_ID_SUCCESS = '[Enrollment] Find Enrollment By Id Success';

  findEnrollmentByIdSuccess(enrollment): Action {
    return {
      type: EnrollmentActions.FIND_ENROLLMENT_BY_ID_SUCCESS,
      payload: enrollment
    };
  }

  //find gradebooks by enrollment
  static FIND_GRADEBOOKS_BY_ENROLLMENT = '[Enrollment] Find Gradebooks By Enrollment';

  findGradebooksByEnrollment(enrollment): Action {
    return {
      type: EnrollmentActions.FIND_GRADEBOOKS_BY_ENROLLMENT,
      payload: enrollment
    };
  }

  static FIND_GRADEBOOKS_BY_ENROLLMENT_SUCCESS = '[Enrollment] Find Gradebooks By Enrollment Success';

  findGradebooksByEnrollmentSuccess(gradebooks): Action {
    return {
      type: EnrollmentActions.FIND_GRADEBOOKS_BY_ENROLLMENT_SUCCESS,
      payload: gradebooks
    };
  }

  //endfind gradebooks by enrollment

  static SAVE_ENROLLMENT = '[Enrollment] Save Enrollment';

  saveEnrollment(enrollment): Action {
    return {
      type: EnrollmentActions.SAVE_ENROLLMENT,
      payload: enrollment
    };
  }


  static SAVE_ENROLLMENT_SUCCESS = '[Enrollment] Save Enrollment Success';

  saveEnrollmentSuccess(enrollment): Action {
    return {
      type: EnrollmentActions.SAVE_ENROLLMENT_SUCCESS,
      payload: enrollment
    };
  }

  static REMOVE_ENROLLMENT = '[Enrollment] Remove Enrollment';

  removeEnrollment(enrollment): Action {
    return {
      type: EnrollmentActions.REMOVE_ENROLLMENT,
      payload: enrollment
    };
  }

  static REMOVE_ENROLLMENT_SUCCESS = '[Enrollment] Remove Enrollment Success';

  removeEnrollmentSuccess(enrollment): Action {
    return {
      type: EnrollmentActions.REMOVE_ENROLLMENT_SUCCESS,
      payload: enrollment
    };
  }

  //update enrollment
  //update section for capacity and ordinal
  static UPDATE_ENROLLMENT = '[Enrollment] Update Enrollment';

  updateEnrollment(section, enrollment): Action {
    console.log("updateEnrollment");
    return {
      type: EnrollmentActions.UPDATE_ENROLLMENT,
      payload: {section: section, enrollment: enrollment}
    };
  }

  static UPDATE_ENROLLMENT_SUCCESS = '[Enrollment] Update Enrollment Success';

  updateEnrollmentSuccess(message): Action {
    console.log("updateEnrollmentSuccess");
    return {
      type: EnrollmentActions.UPDATE_ENROLLMENT_SUCCESS,
      payload: message
    };
  }
}
