import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class EnrollmentActions {

  static FIND_ENROLLMENTS = '[Enrollment] Find Enrollments';

  findEnrollments(): Action {
    return {
      type: EnrollmentActions.FIND_ENROLLMENTS
    };
  }

  static FIND_ENROLLMENTS_SUCCESS = '[Enrollment] Find Enrollments Success';

  findEnrollmentsSuccess(enrollments): Action {
    return {
      type: EnrollmentActions.FIND_ENROLLMENTS_SUCCESS,
      payload: enrollments
    };
  }

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
}
