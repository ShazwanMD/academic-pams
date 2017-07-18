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

}
