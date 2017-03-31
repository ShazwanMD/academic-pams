import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class ProgramActions {

  static LOAD_PROGRAMS = '[Program] Load Programs';
  loadPrograms(): Action {
    return {
      type: ProgramActions.LOAD_PROGRAMS
    };
  }

  static LOAD_PROGRAMS_SUCCESS = '[Program] Load Programs Success';
  loadProgramsSuccess(programs): Action {
    return {
      type: ProgramActions.LOAD_PROGRAMS_SUCCESS,
      payload: programs
    };
  }

  static GET_PROGRAM = '[Program] Get Program';
  getProgram(code): Action {
    return {
      type: ProgramActions.GET_PROGRAM,
      payload: code
    };
  }

  static GET_PROGRAM_SUCCESS = '[Program] Get Program Success';
  getProgramSuccess(program): Action {
    return {
      type: ProgramActions.GET_PROGRAM_SUCCESS,
      payload: program
    };
  }

  static RESET_BLANK_PROGRAM = '[Program] Reset Blank Program';
  resetBlankProgram(): Action {
    return {
      type: ProgramActions.RESET_BLANK_PROGRAM
    };
  }

  static SAVE_PROGRAM = '[Program] Save Program';
  saveProgram(program): Action {
    return {
      type: ProgramActions.SAVE_PROGRAM,
      payload: program
    };
  }

  static SAVE_PROGRAM_SUCCESS = '[Program] Save Program Success';
  saveProgramSuccess(program): Action {
    return {
      type: ProgramActions.SAVE_PROGRAM_SUCCESS,
      payload: program
    };
  }

  static CREATE_PROGRAM = '[Program] Create Program';
  addProgram(program): Action {
    return {
      type: ProgramActions.CREATE_PROGRAM,
      payload: program
    };
  }

  static CREATE_PROGRAM_SUCCESS = '[Program] Create Program Success';
  addProgramSuccess(program): Action {
    return {
      type: ProgramActions.CREATE_PROGRAM_SUCCESS,
      payload: program
    };
  }

  static DELETE_PROGRAM = '[Program] Delete Program';
  deleteProgram(program): Action {
    return {
      type: ProgramActions.DELETE_PROGRAM,
      payload: program
    };
  }

  static DELETE_PROGRAM_SUCCESS = '[Program] Delete Program Success';
  deleteProgramSuccess(program): Action {
    return {
      type: ProgramActions.DELETE_PROGRAM_SUCCESS,
      payload: program
    };
  }
}
