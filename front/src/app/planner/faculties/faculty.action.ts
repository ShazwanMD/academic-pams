import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class FacultyActions {

  static LOAD_FACULTIES = '[Faculty] Load Faculties';
  loadFaculties(): Action {
    return {
      type: FacultyActions.LOAD_FACULTIES
    };
  }

  static LOAD_FACULTIES_SUCCESS = '[Faculty] Load Faculties Success';
  loadFacultiesSuccess(faculties): Action {
    return {
      type: FacultyActions.LOAD_FACULTIES_SUCCESS,
      payload: faculties
    };
  }

  static GET_FACULTY = '[Faculty] Get Faculty';
  getFaculty(code): Action {
    return {
      type: FacultyActions.GET_FACULTY,
      payload: code
    };
  }

  static GET_FACULTY_SUCCESS = '[Faculty] Get Faculty Success';
  getFacultIESuccess(faculty): Action {
    return {
      type: FacultyActions.GET_FACULTY_SUCCESS,
      payload: faculty
    };
  }

  static RESET_BLANK_FACULTY = '[Faculty] Reset Blank Faculty';
  resetBlankFaculty(): Action {
    return {
      type: FacultyActions.RESET_BLANK_FACULTY
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
  saveFacultIESuccess(faculty): Action {
    return {
      type: FacultyActions.SAVE_FACULTY_SUCCESS,
      payload: faculty
    };
  }

  static CREATE_FACULTY = '[Faculty] Create Faculty';
  addFaculty(faculty): Action {
    return {
      type: FacultyActions.CREATE_FACULTY,
      payload: faculty
    };
  }

  static CREATE_FACULTY_SUCCESS = '[Faculty] Create Faculty Success';
  addFacultIESuccess(faculty): Action {
    return {
      type: FacultyActions.CREATE_FACULTY_SUCCESS,
      payload: faculty
    };
  }

  static DELETE_FACULTY = '[Faculty] Delete Faculty';
  deleteFaculty(faculty): Action {
    return {
      type: FacultyActions.DELETE_FACULTY,
      payload: faculty
    };
  }

  static DELETE_FACULTY_SUCCESS = '[Faculty] Delete Faculty Success';
  deleteFacultIESuccess(faculty): Action {
    return {
      type: FacultyActions.DELETE_FACULTY_SUCCESS,
      payload: faculty
    };
  }
}
