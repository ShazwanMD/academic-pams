import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';

@Injectable()
export class GradebookActions {

    static FIND_GRADEBOOK_BY_ID = '[Gradebook] Find Gradebook By Id';

    findGradebookById( gradebook ): Action {
        return {
            type: GradebookActions.FIND_GRADEBOOK_BY_ID,
            payload: gradebook
        };
    }

    static FIND_GRADEBOOK_BY_ID_SUCCESS = '[Gradebook] Find Gradebook By Id Success';

    findGradebookByIdSuccess( gradebook ): Action {
        return {
            type: GradebookActions.FIND_GRADEBOOK_BY_ID_SUCCESS,
            payload: gradebook
        };
    }

    static FIND_GRADEBOOKS_BY_SECTION = '[Gradebook] Find Gradebooks By Section';

    findGradebooksBySection( section ): Action {
        console.log( "findGradebooksBySection" );
        return {
            type: GradebookActions.FIND_GRADEBOOKS_BY_SECTION,
            payload: section
        };
    }

    static FIND_GRADEBOOKS_BY_SECTION_SUCCESS = '[Gradebook] Find Gradebooks By Section Success';

    findGradebooksBySectionSuccess( gradebooks ): Action {
        console.log( "findEnrollmentsBySectionSuccess" );
        return {
            type: GradebookActions.FIND_GRADEBOOKS_BY_SECTION_SUCCESS,
            payload: gradebooks
        };
    }

   /* static SAVE_ENROLLMENT = '[Enrollment] Save Enrollment';

    saveEnrollment( enrollment ): Action {
        return {
            type: EnrollmentActions.SAVE_ENROLLMENT,
            payload: enrollment
        };
    }

    static SAVE_ENROLLMENT_SUCCESS = '[Enrollment] Save Enrollment Success';

    saveEnrollmentSuccess( enrollment ): Action {
        return {
            type: EnrollmentActions.SAVE_ENROLLMENT_SUCCESS,
            payload: enrollment
        };
    }

    static REMOVE_ENROLLMENT = '[Enrollment] Remove Enrollment';

    removeEnrollment( enrollment ): Action {
        return {
            type: EnrollmentActions.REMOVE_ENROLLMENT,
            payload: enrollment
        };
    }

    static REMOVE_ENROLLMENT_SUCCESS = '[Enrollment] Remove Enrollment Success';

    removeEnrollmentSuccess( enrollment ): Action {
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
      payload: {section:section, enrollment: enrollment}
    };
  }

  static UPDATE_ENROLLMENT_SUCCESS = '[Enrollment] Update Enrollment Success';

  updateEnrollmentSuccess(message): Action {
    console.log("updateEnrollmentSuccess");
    return {
      type: EnrollmentActions.UPDATE_ENROLLMENT_SUCCESS,
      payload: message
    };
  } */
}
