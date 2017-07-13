import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';


@Injectable()
export class CurriculumActions {

    static FIND_CURRICULUMS = '[Curriculum] Find Curriculums';
    findCurriculums(): Action {
        return {
            type: CurriculumActions.FIND_CURRICULUMS
        };
    }

    static FIND_CURRICULUMS_SUCCESS = '[Curriculum] Find Curriculums Success';
    findCurriculumsSuccess( curriculums ): Action {
        console.log( "findCurriculumsSuccess" );
        console.log( "curriculums: " + curriculums.length );
        return {
            type: CurriculumActions.FIND_CURRICULUMS_SUCCESS,
            payload: curriculums
        };
    }

    static FIND_CURRICULUM_BY_CODE = '[Curriculum] Find Curriculum By Code';
    findCurriculumByCode( curriculum  ): Action {
        return {
            type: CurriculumActions.FIND_CURRICULUM_BY_CODE,
            payload: curriculum 
        };
    }

    static FIND_CURRICULUM_BY_CODE_SUCCESS = '[Curriculum] Find Curriculum By Code Success';
    findCurriculumByCodeSuccess( curriculum ): Action {
        return {
            type: CurriculumActions.FIND_CURRICULUM_BY_CODE_SUCCESS,
            payload: curriculum
        };
    }

    static FIND_SUBJECTS_BY_CURRICULUM = '[Subject] Find Subject';
    findSubjectsByCurriculum( curriculum ): Action {
        return {
            type: CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM,
            payload: curriculum
        };
    }

     static FIND_SUBJECTS_BY_CURRICULUM_SUCCESS = '[Subject] Find Subject';
    findSubjectsByCurriculumSuccess( curriculum ): Action {
        return {
            type: CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM_SUCCESS,
            payload: curriculum
        };
    }

    static SAVE_CURRICULUM = '[Curriculum] Save Curriculum';
    saveCurriculum( curriculum ): Action {
        return {
            type: CurriculumActions.SAVE_CURRICULUM,
            payload: curriculum
        };
    }

    static SAVE_CURRICULUM_SUCCESS = '[Curriculum] Save Curriculum Success';
    saveCurriculumSuccess( curriculum ): Action {
        return {
            type: CurriculumActions.SAVE_CURRICULUM_SUCCESS,
            payload: curriculum
        };
    }

    static UPDATE_CURRICULUM = '[Curriculum] Update Curriculum';
    updateCurriculum( curriculum ): Action {
        return {
            type: CurriculumActions.UPDATE_CURRICULUM,
            payload: curriculum
        };
    }

    static UPDATE_CURRICULUM_SUCCESS = '[Curriculum] Update Curriculum Success';
    updateCurriculumSuccess( message ): Action {
        return {
            type: CurriculumActions.UPDATE_CURRICULUM_SUCCESS,
            payload: message
        };
    }

    static REMOVE_CURRICULUM = '[Curriculum] Remove Curriculum';
    removeCurriculum( curriculum ): Action {
        return {
            type: CurriculumActions.REMOVE_CURRICULUM,
            payload: curriculum
        };
    }

    static REMOVE_CURRICULUM_SUCCESS = '[Curriculum] Remove Curriculum Success';
    removeCurriculumSuccess( curriculum ): Action {
        return {
            type: CurriculumActions.REMOVE_CURRICULUM_SUCCESS,
            payload: curriculum
        };
    }



  static ACTIVATE_CURRICULUM = '[Curriculum] Activate Curriculum';

  activateCurriculum(curriculum): Action {
    return {
      type: CurriculumActions.ACTIVATE_CURRICULUM,
      payload: curriculum
    };
  }

  static ACTIVATE_CURRICULUM_SUCCESS = '[Curriculum] Activate AcademicSession Success';

  activateCurriculumSuccess(curriculum): Action {
    return {
      type: CurriculumActions.ACTIVATE_CURRICULUM_SUCCESS,
      payload: curriculum
    };
  }

  static DEACTIVATE_CURRICULUM = '[Curriculum] Deactivate Curriculum';

  deactivateCurriculum(curriculum): Action {
    return {
      type: CurriculumActions.DEACTIVATE_CURRICULUM,
      payload: curriculum
    };
  }

  static DEACTIVATE_CURRICULUM_SUCCESS = '[Curriculum] Activate Curriculum Success';

  deactivateCurriculumSuccess(curriculum): Action {
    return {
      type: CurriculumActions.DEACTIVATE_CURRICULUM_SUCCESS,
      payload: curriculum
    };
  }

}
