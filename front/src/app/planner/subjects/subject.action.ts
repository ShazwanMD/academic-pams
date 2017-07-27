import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';
import {Subject} from '../curriculums/subject.interface';

@Injectable()
export class SubjectActions {

  static FIND_SUBJECTS = '[Subject] Find Subjects';

  findSubjects(): Action {
    return {
      type: SubjectActions.FIND_SUBJECTS
    };
  }

  static FIND_SUBJECTS_SUCCESS = '[Subject] Find Subjects Success';

  findSubjectsSuccess(subjects): Action {
    console.log("findSubjectsSuccess");
    console.log("Subjects: " + subjects.length);
    return {
      type: SubjectActions.FIND_SUBJECTS_SUCCESS,
      payload: subjects
    };
  }

  static FIND_SUBJECT_BY_ID = '[Subject] Find Subject by Id';

  findSubjectById(id): Action {
    return {
      type: SubjectActions.FIND_SUBJECT_BY_ID,
      payload: id
    };
  }

  static FIND_SUBJECT_BY_ID_SUCCESS = '[Subject] Find Subject By Id Success';

  findSubjectByIdSuccess(subject): Action {
    return {
      type: SubjectActions.FIND_SUBJECT_BY_ID_SUCCESS,
      payload: subject
    };
  }

  static ADD_SUBJECT = '[Subject] Add Subject';

  addSubject(curriculum, subject): Action {
    return {
      type: SubjectActions.ADD_SUBJECT,
      payload: {curriculum: curriculum, subject: subject}
    };
  }

  static ADD_SUBJECT_SUCCESS = '[Subject] Add Subject Success';

  addSubjectSuccess(message): Action {
    return {
      type: SubjectActions.ADD_SUBJECT_SUCCESS,
      payload: message
    };
  }


  static UPDATE_SUBJECT = '[Subject] Update Subject';

  updateSubject(subject): Action {
    return {
      type: SubjectActions.UPDATE_SUBJECT,
      payload: subject
    };
  }

  static UPDATE_SUBJECT_SUCCESS = '[Subject] Update Subject Success';

  updateSubjectSuccess(subject): Action {
    return {
      type: SubjectActions.UPDATE_SUBJECT_SUCCESS,
      payload: subject
    };
  }

  //  static FIND_SUBJECTS_BY_CURRICULUM = '[Subject] Find Subject';
  // findSubjectsByCurriculum( curriculum ): Action {
  //     return {
  //         type: SubjectActions.FIND_SUBJECTS_BY_CURRICULUM,
  //         payload: curriculum
  //     };
  // }

  //  static FIND_SUBJECTS_BY_CURRICULUM_SUCCESS = '[Subject] Find Subject';
  // findSubjectsByCurriculumSuccess( curriculum ): Action {
  //     return {
  //         type: SubjectActions.FIND_SUBJECTS_BY_CURRICULUM,
  //         payload: curriculum
  //     };
  // }

  static ACTIVATE_SUBJECT = '[Subject] Activate Subject';

  activateSubject(subject): Action {
    return {
      type: SubjectActions.ACTIVATE_SUBJECT,
      payload: subject
    };
  }

  static ACTIVATE_SUBJECT_SUCCESS = '[Subject] Activate Subject Success';

  activateSubjectSuccess(subject): Action {
    return {
      type: SubjectActions.ACTIVATE_SUBJECT_SUCCESS,
      payload: subject
    };
  }

  //deactivate Subject 19/6/17
  static DEACTIVATE_SUBJECT = '[Subject] Deactivate Subject';

  deactivateSubject(subject): Action {
    return {
      type: SubjectActions.DEACTIVATE_SUBJECT,
      payload: subject
    };
  }

  static DEACTIVATE_SUBJECT_SUCCESS = '[Subject] Activate Subject Success';

  deactivateSubjectSuccess(subject): Action {
    return {
      type: SubjectActions.DEACTIVATE_SUBJECT_SUCCESS,
      payload: subject
    };
  }
}
