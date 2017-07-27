import {Injectable} from '@angular/core';
import {select} from '@ngrx/core';
import {Curriculum} from '../curriculums/curriculum.interface';
import {CurriculumActions} from '../curriculums/curriculum.action';
import {Effect, Actions} from '@ngrx/effects';
import {SubjectActions} from './subject.action';
import {PlannerService} from '../../../services/planner.service';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../index';
import {Subject} from '../curriculums/subject.interface';
@Injectable()
export class SubjectEffects {

  private CURRICULUM: string[] = 'plannerModuleState.curriculum'.split('.');
  private SUBJECT: string[] = 'plannerModuleState.subject'.split('.');

  constructor(private actions$: Actions,
              private subjectActions: SubjectActions,
              private currriculumActions: CurriculumActions,
              private plannerService: PlannerService,
              private store$: Store<PlannerModuleState>) {
  }

  @Effect() findSubjects$ = this.actions$
    .ofType(SubjectActions.FIND_SUBJECTS)
    .switchMap(() => this.plannerService.findSubjects())
    .map((subjects) => this.subjectActions.findSubjectsSuccess(subjects));

  // @Effect() findSubjectById$ = this.actions$
  //   .ofType(SubjectActions.FIND_SUBJECT_BY_ID)
  //   .map(action => action.payload)
  //   .switchMap(id => this.plannerService.findSubjectById(id))
  //   .map(subjects => this.SubjectActions.findSubjectByIdSuccess(subjects));

//  @Effect() addSubject$  = this.actions$
//     .ofType(SubjectActions.ADD_SUBJECT)
//     .map(action => action.payload)
//     .switchMap(payload => this.plannerService.addSubject(payload.curriculum,payload.subject));
//     .map(message => this.subjectActions.addSubjectSuccess(message))
//     .withLatestFrom(this.store$.select(...this.CURRICULUM))
//     .map(state => state[1]);
//     .map((curriculum: Curriculum) => this.currriculumActions.findCurriculumByCode(curriculum.code));

  @Effect() addSingleSubject$ =
    this.actions$
      .ofType(SubjectActions.ADD_SINGLE_SUBJECT)
      .map((action) => action.payload)
      .switchMap((payload) => this.plannerService.addSingleSubject(payload.curriculum, payload.subject))
      .map((message) => this.subjectActions.addSingleSubjectSuccess(message))
      .withLatestFrom(this.store$.select(...this.CURRICULUM))
      .map((state) => state[1])
      .map((curriculum: Curriculum) => this.currriculumActions.findCurriculumByCode(curriculum.code));

  @Effect() addBundleSubject$ =
    this.actions$
      .ofType(SubjectActions.ADD_BUNDLE_SUBJECT)
      .map((action) => action.payload)
      .switchMap((payload) => this.plannerService.addSubject(payload.curriculum, payload.subject));
  // .map(message => this.subjectActions.addBundleSubjectSuccess(message))
  // .withLatestFrom(this.store$.select(...this.CURRICULUM))
  // .map(state => state[1]);
  //.map((curriculum: Curriculum) => this.currriculumActions.findCurriculumByCode(curriculum.code));

  @Effect() addSubjectPart$ =
    this.actions$
      .ofType(SubjectActions.ADD_SUBJECT_PART)
      .map((action) => action.payload)
      .switchMap((payload) => this.plannerService.addSubjectPart(payload.curriculum, payload.subject));
  // .map(message => this.subjectActions.addBundleSubjectSuccess(message))
  // .withLatestFrom(this.store$.select(...this.CURRICULUM))
  // .map(state => state[1]);
  //.map((curriculum: Curriculum) => this.currriculumActions.findCurriculumByCode(curriculum.code));

  // @Effect() updateSubject$ = this.actions$
  //   .ofType(SubjectActions.UPDATE_SUBJECT)
  //   .map(action => action.payload)
  //   .switchMap(payload => this.plannerService.updateSubject(payload.curriculum,payload.subject))
  //   .map(message => this.subjectActions.updateSubjectSuccess(message))
  //   .withLatestFrom(this.store$.select(...this.CURRICULUM))
  //   .map(state => state[1])
  //   .map((curriculum: Curriculum) => this.curriculumActions.findCurriculumByCode(curriculum.code));

//   @Effect() activateSubject$ = this.actions$
//     .ofType(SubjectActions.ACTIVATE_SUBJECT)
//     .map(action => action.payload)
//     .switchMap(subject => this.plannerService.activateSubject(subject))
//     .map(message => this.SubjectActions.activateSubjectSuccess(message))
//     .withLatestFrom(this.store$.select(...this.SUBJECT))
//     .map(state => state[1])
//     .map((subject: Subject) => this.SubjectActions.findSubjectById(Subject.id));

//   @Effect() deactivateSubject$ = this.actions$
//     .ofType(SubjectActions.DEACTIVATE_SUBJECT)
//     .map(action => action.payload)
//     .switchMap(subject => this.plannerService.deactivateSubject(subject))
//     .map(message => this.SubjectActions.deactivateSubjectSuccess(message))
//     .withLatestFrom(this.store$.select(...this.SUBJECT))
//     .map(state => state[1])
//     .map((subject: Subject) => this.SubjectActions.findSubjectById(subject.id));

// }
}
