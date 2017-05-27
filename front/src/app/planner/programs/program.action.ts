import {Program} from './program.interface';
import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class ProgramActions {

  static FIND_PROGRAMS = '[Program] Find Programs';

  findPrograms(): Action {
    return {
      type: ProgramActions.FIND_PROGRAMS
    };
  }

  static FIND_PROGRAMS_SUCCESS = '[Program] Find Programs Success';

  findProgramsSuccess(programs): Action {
    console.log("findProgramsSuccess");
    console.log("programs: " + programs.length);
    return {
      type: ProgramActions.FIND_PROGRAMS_SUCCESS,
      payload: programs
    };
  }

  static FIND_PROGRAM_BY_CODE = '[Program] Find Program By Code';

  findProgramByCode(code): Action {
    return {
      type: ProgramActions.FIND_PROGRAM_BY_CODE,
      payload: code
    };
  }

  static FIND_PROGRAM_BY_CODE_SUCCESS = '[Program] Find Program By Code Success';

  findProgramByCodeSuccess(program): Action {
    return {
      type: ProgramActions.FIND_PROGRAM_BY_CODE_SUCCESS,
      payload: program
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

  static UPDATE_PROGRAM = '[Program] Update Program';

  updateProgram(program): Action {
    return {
      type: ProgramActions.UPDATE_PROGRAM,
      payload: program
    };
  }

  static UPDATE_PROGRAM_SUCCESS = '[Program] Update Program Success';

  updateProgramSuccess(program): Action {
    return {
      type: ProgramActions.UPDATE_PROGRAM_SUCCESS,
      payload: program
    };
  }

  static CREATE_PROGRAM = '[Program] Create Program';

  createProgram(program): Action {
    return {
      type: ProgramActions.CREATE_PROGRAM,
      payload: program
    };
  }

  static CREATE_PROGRAM_SUCCESS = '[Program] Create Program Success';

  createProgramSuccess(program): Action {
    return {
      type: ProgramActions.CREATE_PROGRAM_SUCCESS,
      payload: program
    };
  }

  static REMOVE_PROGRAM = '[Program] Remove Program';

  removeProgram(program): Action {
    return {
      type: ProgramActions.REMOVE_PROGRAM,
      payload: program
    };
  }

  static REMOVE_PROGRAM_SUCCESS = '[Program] Remove Program Success';

  removeProgramSuccess(program): Action {
    return {
      type: ProgramActions.REMOVE_PROGRAM_SUCCESS,
      payload: program
    };
  }


  static ACTIVATE_PROGRAM = '[Program] Activate Program';

  activateProgram(program): Action {
    return {
      type: ProgramActions.ACTIVATE_PROGRAM,
      payload: program
    };
  }

  static ACTIVATE_PROGRAM_SUCCESS = '[Program] Activate AcademicSession Success';

  activateProgramSuccess(program): Action {
    return {
      type: ProgramActions.ACTIVATE_PROGRAM_SUCCESS,
      payload: program
    };
  }

  static DEACTIVATE_PROGRAM = '[Program] Deactivate Program';

  deactivateProgram(program): Action {
    return {
      type: ProgramActions.DEACTIVATE_PROGRAM,
      payload: program
    };
  }

  static DEACTIVATE_PROGRAM_SUCCESS = '[Program] Activate Program Success';

  deactivateProgramSuccess(program): Action {
    return {
      type: ProgramActions.DEACTIVATE_PROGRAM_SUCCESS,
      payload: program
    };
  }
}
