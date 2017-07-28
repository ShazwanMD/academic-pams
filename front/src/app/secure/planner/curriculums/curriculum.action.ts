import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class CurriculumActions {

  static FIND_CURRICULUMS = '[Curriculum] Find Curriculums';

  findCurriculums(): Action {
    return {
      type: CurriculumActions.FIND_CURRICULUMS,
    };
  }

  static FIND_CURRICULUMS_SUCCESS = '[Curriculum] Find Curriculums Success';

  findCurriculumsSuccess(curriculums): Action {
    console.log('findCurriculumsSuccess');
    console.log('curriculums: ' + curriculums.length);
    return {
      type: CurriculumActions.FIND_CURRICULUMS_SUCCESS,
      payload: curriculums,
    };
  }

  static FIND_CURRICULUM_BY_CODE = '[Curriculum] Find Curriculum By Code';

  findCurriculumByCode(code): Action {
    return {
      type: CurriculumActions.FIND_CURRICULUM_BY_CODE,
      payload: code,
    };
  }

  static FIND_CURRICULUM_BY_CODE_SUCCESS = '[Curriculum] Find Curriculum By Code Success';

  findCurriculumByCodeSuccess(curriculum): Action {
    return {
      type: CurriculumActions.FIND_CURRICULUM_BY_CODE_SUCCESS,
      payload: curriculum,
    };
  }

  static FIND_SUBJECTS_BY_CURRICULUM = '[Curriculum] Find Subject By Curriculum';

  findSubjectsByCurriculum(curriculum): Action {
    return {
      type: CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM,
      payload: curriculum,
    };
  }

  static FIND_SUBJECTS_BY_CURRICULUM_SUCCESS = '[Curriculum] Find Subject By Curriculum Success';

  findSubjectsByCurriculumSuccess(subjects): Action {
    return {
      type: CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM_SUCCESS,
      payload: subjects,
    };
  }

  static SAVE_CURRICULUM = '[Curriculum] Save Curriculum';

  saveCurriculum(curriculum): Action {
    return {
      type: CurriculumActions.SAVE_CURRICULUM,
      payload: curriculum,
    };
  }

  static SAVE_CURRICULUM_SUCCESS = '[Curriculum] Save Curriculum Success';

  saveCurriculumSuccess(message): Action {
    return {
      type: CurriculumActions.SAVE_CURRICULUM_SUCCESS,
      payload: message,
    };
  }

  static UPDATE_CURRICULUM = '[Curriculum] Update Curriculum';

  updateCurriculum(curriculum): Action {
    return {
      type: CurriculumActions.UPDATE_CURRICULUM,
      payload: curriculum,
    };
  }

  static UPDATE_CURRICULUM_SUCCESS = '[Curriculum] Update Curriculum Success';

  updateCurriculumSuccess(message): Action {
    return {
      type: CurriculumActions.UPDATE_CURRICULUM_SUCCESS,
      payload: message,
    };
  }

  static REMOVE_CURRICULUM = '[Curriculum] Remove Curriculum';

  removeCurriculum(curriculum): Action {
    return {
      type: CurriculumActions.REMOVE_CURRICULUM,
      payload: curriculum,
    };
  }

  static REMOVE_CURRICULUM_SUCCESS = '[Curriculum] Remove Curriculum Success';

  removeCurriculumSuccess(curriculum): Action {
    return {
      type: CurriculumActions.REMOVE_CURRICULUM_SUCCESS,
      payload: curriculum,
    };
  }

  static ACTIVATE_CURRICULUM = '[Curriculum] Activate Curriculum';

  activateCurriculum(curriculum): Action {
    return {
      type: CurriculumActions.ACTIVATE_CURRICULUM,
      payload: curriculum,
    };
  }

  static ACTIVATE_CURRICULUM_SUCCESS = '[Curriculum] Activate AcademicSession Success';

  activateCurriculumSuccess(curriculum): Action {
    return {
      type: CurriculumActions.ACTIVATE_CURRICULUM_SUCCESS,
      payload: curriculum,
    };
  }

  static DEACTIVATE_CURRICULUM = '[Curriculum] Deactivate Curriculum';

  deactivateCurriculum(curriculum): Action {
    return {
      type: CurriculumActions.DEACTIVATE_CURRICULUM,
      payload: curriculum,
    };
  }

  static DEACTIVATE_CURRICULUM_SUCCESS = '[Curriculum] Activate Curriculum Success';

  deactivateCurriculumSuccess(curriculum): Action {
    return {
      type: CurriculumActions.DEACTIVATE_CURRICULUM_SUCCESS,
      payload: curriculum,
    };
  }

  static ADD_SINGLE_SUBJECT = '[Subject] Add Single Subject';

  addSingleSubject(curriculum, subject): Action {
    return {
      type: CurriculumActions.ADD_SINGLE_SUBJECT,
      payload: {curriculum: curriculum, subject: subject}
    };
  }

  static ADD_SINGLE_SUBJECT_SUCCESS = '[Subject] Add Single Subject Success';

  addSingleSubjectSuccess(message): Action {
    return {
      type: CurriculumActions.ADD_SINGLE_SUBJECT_SUCCESS,
      payload: message
    };
  }

  static ADD_BUNDLE_SUBJECT = '[Subject] Add Bundle Subject Success';

  addBundleSubject(curriculum, subject): Action {
    return {
      type: CurriculumActions.ADD_BUNDLE_SUBJECT,
      payload: {curriculum: curriculum, subject: subject}
    };
  }

  static ADD_BUNDLE_SUBJECT_SUCCESS = '[Subject] Add Bundle Subject Success';

  addBundleSubjecttSuccess(message): Action {
    return {
      type: CurriculumActions.ADD_BUNDLE_SUBJECT_SUCCESS,
      payload: message
    };
  }

}
