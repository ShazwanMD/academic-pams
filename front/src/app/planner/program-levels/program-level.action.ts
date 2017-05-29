import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';


@Injectable()
export class ProgramLevelActions {

  static FIND_PROGRAM_LEVELS = '[ProgramLevel] Find ProgramLevels';

  findProgramLevels(): Action {
    return {
      type: ProgramLevelActions.FIND_PROGRAM_LEVELS,
    };
  }

  static FIND_PROGRAM_LEVELS_SUCCESS = '[ProgramLevel] Find ProgramLevels Success';

  findProgramLevelsSuccess(programLevels): Action {
    console.log("findProgramLevelsSuccess");
    console.log("programLevels: " + programLevels.length);
    return {
      type: ProgramLevelActions.FIND_PROGRAM_LEVELS_SUCCESS,
      payload: programLevels
    };
  }

  static FIND_PROGRAM_LEVEL_BY_CODE = '[ProgramLevel] Find ProgramLevel By Code';

  findProgramLevelByCode(code): Action {
    return {
      type: ProgramLevelActions.FIND_PROGRAM_LEVEL_BY_CODE,
      payload: code
    };
  }

  static FIND_PROGRAM_LEVEL_BY_CODE_SUCCESS = '[ProgramLevel] Find ProgramLevel By Code Success';

  findProgramLevelByCodeSuccess(code): Action {
    console.log("findProgramLevelByCode");
    console.log("programLevel" + code)
    return {
      type: ProgramLevelActions.FIND_PROGRAM_LEVEL_BY_CODE_SUCCESS,
      payload: code
    };
  }

  static SAVE_PROGRAM_LEVEL = '[ProgramLevel] Save ProgramLevel';

  saveProgramLevel(programLevel): Action {
    console.log("saveProgramLevel");
    console.log("programLevel: " + programLevel);
    return {
      type: ProgramLevelActions.SAVE_PROGRAM_LEVEL,
      payload: programLevel
    };
  }

  static SAVE_PROGRAM_LEVEL_SUCCESS = '[ProgramLevel] Save ProgramLevel Success';

  saveProgramLevelSuccess(programLevel): Action {
    console.log("saveProgramLevelSucces");
    console.log("programLevel: " + programLevel);
    return {
      type: ProgramLevelActions.SAVE_PROGRAM_LEVEL_SUCCESS,
      payload: programLevel
    };
  }

  static UPDATE_PROGRAM_LEVEL = '[ProgramLevel] Update ProgramLevel';

  updateProgramLevel(programLevel): Action {
    console.log("updateProgramLevel");
    console.log("programLevel: " + programLevel);
    return {
      type: ProgramLevelActions.UPDATE_PROGRAM_LEVEL,
      payload: programLevel
    };
  }

  static UPDATE_PROGRAM_LEVEL_SUCCESS = '[ProgramLevel] Update ProgramLevel';

  updateAcademisLevelSuccess(programLevel): Action {
    console.log("updateProgramLevelLevel");
    console.log("programLevel: " + programLevel);
    return {
      type: ProgramLevelActions.UPDATE_PROGRAM_LEVEL_SUCCESS,
      payload: programLevel
    };
  }

  static REMOVE_PROGRAM_LEVEL = '[ProgramLevel] Remove ProgramLevel';

  removeProgramLevel(programLevel): Action {
    console.log("removeProgramLevel");
    console.log("programLevel: " + programLevel);
    return {
      type: ProgramLevelActions.REMOVE_PROGRAM_LEVEL,
      payload: programLevel
    };
  }

  static REMOVE_PROGRAM_LEVEL_SUCCESS = '[ProgramLevel] Remove ProgramLevel Success';

  removeProgramLevelSuccess(programLevel): Action {
    console.log("removeProgramLevelSuccess");
    console.log("programLevel: " + programLevel);
    return {
      type: ProgramLevelActions.REMOVE_PROGRAM_LEVEL_SUCCESS,
      payload: programLevel
    };
  }

  static ACTIVATE_PROGRAM_LEVEL = '[ProgramLevel] Activate ProgramLevel';

  activateProgramLevel(programLevel): Action {
    console.log("activateProgramLevel");
    console.log("programLevel: " + programLevel);
    return {
      type: ProgramLevelActions.ACTIVATE_PROGRAM_LEVEL,
      payload: programLevel
    };
  }


  static ACTIVATE_PROGRAM_LEVEL_SUCCESS = '[ProgramLevel] Activate ProgramLevel Success';

  activateProgramLevelSuccess(programLevel): Action {
    console.log("activateProgramLevelSuccess");
    console.log("programLevel: " + programLevel);
    return {
      type: ProgramLevelActions.ACTIVATE_PROGRAM_LEVEL_SUCCESS,
      payload: programLevel
    };
  }

  static DEACTIVATE_PROGRAM_LEVEL = '[ProgramLevel] Deactivate ProgramLevel';

  deactivateProgramLevel(programLevel): Action {
    console.log("deactivateProgramLevel");
    console.log("programLevel: " + programLevel);
    return {
      type: ProgramLevelActions.DEACTIVATE_PROGRAM_LEVEL,
      payload: programLevel
    };
  }

  static DEACTIVATE_PROGRAM_LEVEL_SUCCESS = '[ProgramLevel] Activate ProgramLevel Success';

  deactivateProgramLevelSuccess(programLevel): Action {
    console.log("deactivateProgramLevelSuccess");
    console.log("programLevel: " + programLevel);
    return {
      type: ProgramLevelActions.DEACTIVATE_PROGRAM_LEVEL_SUCCESS,
      payload: programLevel
    };
  }


}
