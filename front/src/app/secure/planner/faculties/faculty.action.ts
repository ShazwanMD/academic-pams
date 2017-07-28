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

  static FIND_FACULTIES_SUCCESS = '[Faculty] Find Faculties Success';

  findFacultiesSuccess(faculties): Action {
    return {
      type: FacultyActions.FIND_FACULTIES_SUCCESS,
      payload: faculties
    };
  }

  static FIND_FACULTY_BY_CODE = '[Faculty] Find Faculty By Code';

  findFacultyByCode(code): Action {
    return {
      type: FacultyActions.FIND_FACULTY_BY_CODE,
      payload: code
    };
  }

  static FIND_FACULTY_BY_CODE_SUCCESS = '[Faculty] Find Faculty By Code Success';

  findFacultyByCodeSuccess(faculty): Action {
    return {
      type: FacultyActions.FIND_FACULTY_BY_CODE_SUCCESS,
      payload: faculty
    };
  }

  static FIND_PROGRAM_BY_FACULTY = '[Faculty] Find Program By Faculty';

  findProgramsByFaculty(faculty): Action {
    return {
      type: FacultyActions.FIND_PROGRAM_BY_FACULTY,
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


  static UPDATE_FACULTY = '[Faculty] Update Faculty';

  updateFaculty(faculty): Action {
    return {
      type: FacultyActions.UPDATE_FACULTY,
      payload: faculty
    };
  }

  static UPDATE_FACULTY_SUCCESS = '[Faculty] Update Faculty Success';

  updateFacultySuccess(faculty): Action {
    return {
      type: FacultyActions.UPDATE_FACULTY_SUCCESS,
      payload: faculty
    };
  }

  static ACTIVATE_FACULTY = '[Faculty] Activate Faculty';

  activateFaculty(faculty): Action {
    return {
      type: FacultyActions.ACTIVATE_FACULTY,
      payload: faculty
    };
  }

  static ACTIVATE_FACULTY_SUCCESS = '[Faculty] Activate Faculty Success';

  activateFacultySuccess(faculty): Action {
    return {
      type: FacultyActions.ACTIVATE_FACULTY_SUCCESS,
      payload: faculty
    };
  }

  static DEACTIVATE_FACULTY = '[faculty] Deactivate faculty';

  deactivateFaculty(faculty): Action {
    return {
      type: FacultyActions.DEACTIVATE_FACULTY,
      payload: faculty
    };
  }

  static DEACTIVATE_FACULTY_SUCCESS = '[faculty] Activate Faculty Success';

  deactivateFacultySuccess(faculty): Action {
    return {
      type: FacultyActions.DEACTIVATE_FACULTY_SUCCESS,
      payload: faculty
    };
  }
}
