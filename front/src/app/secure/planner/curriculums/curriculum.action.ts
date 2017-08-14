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

  static FIND_SUBJECTS_BY_CURRICULUM_AND_SUBJECT_TYPE_CORE= '[Curriculum] Find Subject By Curriculum and Subject Core Type';

  findSubjectsByCurriculumAndSubjectCoreType(curriculum): Action {
    return {
      type: CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM_AND_SUBJECT_TYPE_CORE,
      payload: curriculum,
    };
  }

  static FIND_SUBJECTS_BY_CURRICULUM_AND_SUBJECT_TYPE_CORE_SUCCESS = '[Curriculum] Find Subject By Curriculum and Subject Core Type Success';

  findSubjectsByCurriculumAndSubjectCoreTypeSuccess(subjects): Action {
    return {
      type: CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM_AND_SUBJECT_TYPE_CORE_SUCCESS,
      payload: subjects,
    };
  }

    static FIND_SUBJECTS_BY_CURRICULUM_AND_SUBJECT_TYPE_ELECTIVE= '[Curriculum] Find Subject By Curriculum and Subject Elective Type';

  findSubjectsByCurriculumAndSubjectElectiveType(curriculum): Action {
    return {
      type: CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM_AND_SUBJECT_TYPE_ELECTIVE,
      payload: curriculum,
    };
  }

  static FIND_SUBJECTS_BY_CURRICULUM_AND_SUBJECT_TYPE_ELECTIVE_SUCCESS = '[Curriculum] Find Subject By Curriculum and Subject Elective Type Success';
  
  findSubjectsByCurriculumAndSubjectElectiveTypeSuccess(subjects): Action {
    console.log("findSubjectsByCurriculumAndSubjectElectiveTypeSuccess");
    return {
      type: CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM_AND_SUBJECT_TYPE_ELECTIVE_SUCCESS,
      payload: subjects,
    };
  }


   static FIND_BUNDLE_SUBJECT_PART_BY_ID = '[Curriculum] Find Bundle Subject Part By Id';

  findBundleSubjectPartById(id): Action {
    return {
      type: CurriculumActions.FIND_BUNDLE_SUBJECT_PART_BY_ID,
      payload: id
    };
  }

  static FIND_BUNDLE_SUBJECT_PART_BY_ID_SUCCESS = '[Curriculum] Find Bundle Subject Part By Id';

 findBundleSubjectPartByIdSuccess(message): Action {
    return {
      type: CurriculumActions.FIND_BUNDLE_SUBJECT_PART_BY_ID_SUCCESS,
      payload: message
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


  static REMOVE_SUBJECT = '[Curriculum] Remove Curriculum';

    deleteSubject( curriculum, subject ): Action {
        console.log( "deleteSubject" );
        return {
            type: CurriculumActions.REMOVE_SUBJECT ,
            payload: { curriculum: curriculum, subject: subject}
        };
    }

    static REMOVE_SUBJECT_SUCCESS = '[Curriculum] Remove Curriculum Success';

    deleteSubjectSuccess( message ): Action {
        console.log( "deleteSubjectSuccess" );
        return {
            type: CurriculumActions.REMOVE_SUBJECT_SUCCESS,
            payload: message
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

  static ADD_BUNDLE_SUBJECT = '[Subject] Add Bundle Subject';

  addBundleSubject(curriculum, subject): Action {
    return {
      type: CurriculumActions.ADD_BUNDLE_SUBJECT,
      payload: {curriculum: curriculum, subject: subject}
    };
  }

  static ADD_BUNDLE_SUBJECT_SUCCESS = '[Subject] Add Bundle Subject Success';

  addBundleSubjectSuccess(message): Action {
    return {
      type: CurriculumActions.ADD_BUNDLE_SUBJECT_SUCCESS,
      payload: message
    };
  }


 static FIND_BUNDLE_SUBJECTS_BY_CURRICULUM= '[Subject] Find Bundle Subject';

  findBundleSubjectsByCurriculum(curriculum, subject): Action {
    return {
      type: CurriculumActions.FIND_BUNDLE_SUBJECTS_BY_CURRICULUM,
      payload: {curriculum: curriculum, subject: subject}
    };
  }

  static FIND_BUNDLE_SUBJECTS_BY_CURRICULUM_SUCCESS = '[Subject] Find Bundle Subject Success';

  findBundleSubjectsByCurriculumsSuccess(subjects): Action {
    return {
      type: CurriculumActions.FIND_BUNDLE_SUBJECTS_BY_CURRICULUM_SUCCESS,
      payload: subjects
    };
  }

   static ADD_SUBJECT_PART = '[Subject] Add Bundle Subject Parts';

  addSubjectPart(bundleSubject, subject): Action {
    return {
      type: CurriculumActions.ADD_SUBJECT_PART,
      payload: {bundleSubject: bundleSubject, subject: subject}
    };
  }

  static ADD_SUBJECT_PART_SUCCESS = '[Subject] Add Bundle Subject Parts Success';

  addSubjectPartSuccess(message): Action {
    return {
      type: CurriculumActions.ADD_SUBJECT_PART_SUCCESS,
      payload: message
    };
  }
  
  static FIND_BUNDLE_SUBJECTS_PART= '[Subject] Find Bundle Subject Part';

  findBundleSubjectPart(bundleSubject): Action {
      console.log("findBundleSubjectPart :"+bundleSubject);
    return {
      type: CurriculumActions.FIND_BUNDLE_SUBJECTS_PART,
      payload: {bundleSubject: bundleSubject}
    };
  }

  static FIND_BUNDLE_SUBJECTS_PART_SUCCESS = '[Subject] Find Bundle Subject Part Success';

  findBundleSubjectPartSuccess(message): Action {
      console.log("findBundleSubjectPartSuccess");
    return {
      type: CurriculumActions.FIND_BUNDLE_SUBJECTS_PART_SUCCESS,
      payload: message
    };
  }

}
