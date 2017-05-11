import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class FacultyActions {

  static FIND_FACULTIES = '[Faculty] Find Faculties';

  findFaculties(): Action {
    return {
      type: FacultyActions.FIND_FACULTIES
    };
  }

  static FIND_FACULTY_BY_CODE = '[Faculty] Find Faculty By Code';

  findFacultyByCode(code): Action {
    return {
      type: FacultyActions.FIND_FACULTY_BY_CODE,
      payload: code
    };
  }

  static FIND_FACULTIES_SUCCESS = '[Faculty] Find Faculties Success';

  findFacultiesSuccess(faculties): Action {
    return {
      type: FacultyActions.FIND_FACULTIES_SUCCESS,
      payload: faculties
    };
  }

  static FIND_FACULTY_BY_CODE_SUCCESS = '[Faculty] Find Faculty By Code Success';

  findFacultyByCodeSuccess(faculty): Action {
    return {
      type: FacultyActions.FIND_FACULTY_BY_CODE_SUCCESS,
      payload: faculty
    };
  }

  static SAVE_FACULTY = '[Faculty] Save Faculty';

  saveFaculty(faculty): Action {
    return {
      type: FacultyActions.SAVE_FACULTY,
      payload: faculty
    };
  }

  static SAVE_FACULTY_SUCCESS = '[Faculty] Save Faculty Success';

  saveFacultySuccess(faculty): Action {
    return {
      type: FacultyActions.SAVE_FACULTY_SUCCESS,
      payload: faculty
    };
  }

  static REMOVE_FACULTY = '[Faculty] Remove Faculty';

  removeFaculty(faculty): Action {
    return {
      type: FacultyActions.REMOVE_FACULTY,
      payload: faculty
    };
  }

  static REMOVE_FACULTY_SUCCESS = '[Faculty] Remove Faculty Success';

  removeFacultySuccess(faculty): Action {
    return {
      type: FacultyActions.REMOVE_FACULTY_SUCCESS,
      payload: faculty
    };
  }
}
