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

  static FIND_FACULTY = '[Faculty] Find Faculty';
  getFaculty(code): Action {
    return {
      type: FacultyActions.FIND_FACULTY,
      payload: code
    };
  }

  static FIND_FACULTY_SUCCESS = '[Faculty] Find Faculty Success';
  getFacultIESuccess(faculty): Action {
    return {
      type: FacultyActions.FIND_FACULTY_SUCCESS,
      payload: faculty
    };
  }

  static RESET_FACULTY = '[Faculty] Reset Faculty';
  resetBlankFaculty(): Action {
    return {
      type: FacultyActions.RESET_FACULTY
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

  static CREATE_FACULTY = '[Faculty] Create Faculty';
  createFaculty(faculty): Action {
    return {
      type: FacultyActions.CREATE_FACULTY,
      payload: faculty
    };
  }

  static CREATE_FACULTY_SUCCESS = '[Faculty] Create Faculty Success';
  createFacultySuccess(faculty): Action {
    return {
      type: FacultyActions.CREATE_FACULTY_SUCCESS,
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
