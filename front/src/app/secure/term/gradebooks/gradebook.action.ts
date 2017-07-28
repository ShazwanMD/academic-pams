import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class GradebookActions {

  static FIND_GRADEBOOK_BY_ID = '[Gradebook] Find Gradebook By Id';

  findGradebookById(gradebook): Action {
    return {
      type: GradebookActions.FIND_GRADEBOOK_BY_ID,
      payload: gradebook
    };
  }

  static FIND_GRADEBOOK_BY_ID_SUCCESS = '[Gradebook] Find Gradebook By Id Success';

  findGradebookByIdSuccess(gradebook): Action {
    return {
      type: GradebookActions.FIND_GRADEBOOK_BY_ID_SUCCESS,
      payload: gradebook
    };
  }
}
