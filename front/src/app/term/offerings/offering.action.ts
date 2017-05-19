import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class OfferingActions {

  static FIND_OFFERINGS = '[Offering] Find Offerings';

  findOfferings(): Action {
    return {
      type: OfferingActions.FIND_OFFERINGS
    };
  }

  static FIND_OFFERINGS_SUCCESS = '[Offering] Find Offerings Success';

  findOfferingsSuccess(offerings): Action {
    return {
      type: OfferingActions.FIND_OFFERINGS_SUCCESS,
      payload: offerings
    };
  }

  static FIND_OFFERING_BY_CANONICAL_CODE = '[Offering] Find Offering By Canonical Code';

  findOfferingByCanonicalCode(canonicalCode): Action {
    return {
      type: OfferingActions.FIND_OFFERING_BY_CANONICAL_CODE,
      payload: canonicalCode
    };
  }

  static FIND_OFFERING_BY_CANONICAL_CODE_SUCCESS = '[Offering] Find Offering By Canonical Code Success';

  findOfferingByCanonicalCodeSuccess(offering): Action {
    return {
      type: OfferingActions.FIND_OFFERING_BY_CANONICAL_CODE_SUCCESS,
      payload: offering
    };
  }

  //find section by offering

  static FIND_SECTIONS_BY_OFFERING = '[Offering] Find Sections By Offering';

  findSectionsByOffering(offering): Action {
    return {
      type: OfferingActions.FIND_SECTIONS_BY_OFFERING,
      payload: offering
    };
  }

  static FIND_SECTIONS_BY_OFFERING_SUCCESS = '[Offering] Find Sections By Offering Success';

  findSectionsByOfferingSuccess(sections): Action {
    return {
      type: OfferingActions.FIND_SECTIONS_BY_OFFERING_SUCCESS,
      payload: sections
    };
  }


  static FIND_ENROLLMENTS_BY_OFFERING = '[Offering] Find Enrollments By Offering';

  findEnrollmentsByOffering(offering): Action {
    return {
      type: OfferingActions.FIND_ENROLLMENTS_BY_OFFERING,
      payload: offering
    };
  }

  static FIND_ENROLLMENTS_BY_OFFERING_SUCCESS = '[Offering] Find Enrollments By Offering Success';

  findEnrollmentsByOfferingSuccess(enrollments): Action {
    return {
      type: OfferingActions.FIND_ENROLLMENTS_BY_OFFERING_SUCCESS,
      payload: enrollments
    };
  }

  static FIND_APPOINTMENTS_BY_OFFERING = '[Offering] Find Appointments By Offering';

  findAppointmentsByOffering(offering): Action {
    return {
      type: OfferingActions.FIND_APPOINTMENTS_BY_OFFERING,
      payload: offering
    };
  }

  static FIND_APPOINTMENTS_BY_OFFERING_SUCCESS = '[Offering] Find Appointments By Offering Success';

  findAppointmentsByOfferingSuccess(appointments): Action {
    return {
      type: OfferingActions.FIND_APPOINTMENTS_BY_OFFERING_SUCCESS,
      payload: appointments
    };
  }

  static FIND_ASSESSMENTS_BY_OFFERING = '[Offering] Find Assessments By Offering';

  findAssessmentsByOffering(offering): Action {
    return {
      type: OfferingActions.FIND_ASSESSMENTS_BY_OFFERING,
      payload: offering
    };
  }

  static FIND_ASSESSMENTS_BY_OFFERING_SUCCESS = '[Offering] Find Assessments By Offering Success';

  findAssessmentsByOfferingSuccess(assessments): Action {
    return {
      type: OfferingActions.FIND_ASSESSMENTS_BY_OFFERING_SUCCESS,
      payload: assessments
    };
  }

  static SAVE_OFFERING = '[Offering] Save Offering';

  saveOffering(offering): Action {
    return {
      type: OfferingActions.SAVE_OFFERING,
      payload: offering
    };
  }

  static SAVE_OFFERING_SUCCESS = '[Offering] Save Offering Success';

  saveOfferingSuccess(offering): Action {
    return {
      type: OfferingActions.SAVE_OFFERING_SUCCESS,
      payload: offering
    };
  }

  static UPDATE_OFFERING = '[Offering] Update Offering';

  updateOffering(offering): Action {
    return {
      type: OfferingActions.UPDATE_OFFERING,
      payload: offering
    };
  }

  static UPDATE_OFFERING_SUCCESS = '[Offering] Update Offering Success';

  updateOfferingSuccess(offering): Action {
    return {
      type: OfferingActions.UPDATE_OFFERING_SUCCESS,
      payload: offering
    };
  }

  static REMOVE_OFFERING = '[Offering] Remove Offering';

  removeOffering(offering): Action {
    return {
      type: OfferingActions.REMOVE_OFFERING,
      payload: offering
    };
  }

  static REMOVE_OFFERING_SUCCESS = '[Offering] Remove Offering Success';

  removeOfferingSuccess(offering): Action {
    return {
      type: OfferingActions.REMOVE_OFFERING_SUCCESS,
      payload: offering
    };
  }
}
