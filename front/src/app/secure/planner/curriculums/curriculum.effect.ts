import {Injectable} from '@angular/core';
import {Actions, Effect} from '@ngrx/effects';
import {CurriculumActions} from './curriculum.action';
import {PlannerService} from '../../../../services/planner.service';
import {Curriculum} from '../../../shared/model/planner/curriculum.interface';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../index';
import {from} from 'rxjs/observable/from';

@Injectable()
export class CurriculumEffects {

  private CURRICULUM: string[] = 'plannerModuleState.curriculum'.split('.');

  constructor(private actions$: Actions,
              private curriculumActions: CurriculumActions,
              private plannerService: PlannerService,
              private store$: Store<PlannerModuleState>) {
  }

  @Effect() findCurriculums$ = this.actions$
    .ofType(CurriculumActions.FIND_CURRICULUMS)
    .switchMap(() => this.plannerService.findCurriculums())
    .map((curriculums) => this.curriculumActions.findCurriculumsSuccess(curriculums));


    @Effect() findBundleSubjectPartById$ = this.actions$
    .ofType(CurriculumActions.FIND_BUNDLE_SUBJECT_PART_BY_ID)
    .map((action) => action.payload)
    .switchMap((id) => this.plannerService.findBundleSubjectPartById(id))
    .map((message) => this.curriculumActions.findBundleSubjectPartByIdSuccess(message));


    //  @Effect() findBundleSubjectsByCurriculum$ = this.actions$
    // .ofType(CurriculumActions.FIND_BUNDLE_SUBJECTS_BY_CURRICULUM)
    // .map((action) => action.payload)
    // .switchMap((curriculum) => this.plannerService.findBundleSubjectsByCurriculum(curriculum))
    // .map((subjects) => this.curriculumActions. findBundleSubjectsByCurriculumsSuccess(subjects));

  @Effect() findCurriculumByCode$ = this.actions$
    .ofType(CurriculumActions.FIND_CURRICULUM_BY_CODE)
    .map((action) => action.payload)
    .switchMap((code) => this.plannerService.findCurriculumByCode(code))
    .map((curriculum) => this.curriculumActions.findCurriculumByCodeSuccess(curriculum))
    .mergeMap((action) => from([action,
      this.curriculumActions.findSubjectsByCurriculumAndSubjectCoreType(action.payload),
      this.curriculumActions.findSubjectsByCurriculumAndSubjectCoreElectiveType(action.payload),
      this.curriculumActions.findSubjectsByCurriculumAndSubjectElectiveType(action.payload),
    ]));

  @Effect() findSubjectsByCurriculum$ = this.actions$
    .ofType(CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM)
    .map((action) => action.payload)
    .switchMap((curriculum) => this.plannerService.findSubjectsByCurriculum(curriculum))
    .map((subjects) => this.curriculumActions.findSubjectsByCurriculumSuccess(subjects));
  
  @Effect() findBundleSubjectsPart$ = this.actions$
  .ofType(CurriculumActions.FIND_BUNDLE_SUBJECTS_PART)
  .map((action) => action.payload)
  .switchMap((payload) => this.plannerService.findBundleSubjectsPart(payload.bundleSubject))
  .map((message) => this.curriculumActions.findBundleSubjectPartSuccess(message));

    @Effect() findSubjectsByCurriculumAndSubjectCoreType$ = this.actions$
    .ofType(CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM_AND_SUBJECT_TYPE_CORE)
    .map((action) => action.payload)
    .switchMap((curriculum) => this.plannerService.findSubjectsByCurriculumAndSubjectTypeCore(curriculum))
    .map((subjects) => this.curriculumActions.findSubjectsByCurriculumAndSubjectCoreTypeSuccess(subjects));

    //core elective
    @Effect() findSubjectsByCurriculumAndSubjectCoreElectiveType$ = this.actions$
    .ofType(CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM_AND_SUBJECT_TYPE_CORE_ELECTIVE)
    .map((action) => action.payload)
    .switchMap((curriculum) => this.plannerService.findSubjectsByCurriculumAndSubjectTypeCoreElective(curriculum))
    .map((subjects) => this.curriculumActions.findSubjectsByCurriculumAndSubjectCoreElectiveTypeSuccess(subjects));

    
     @Effect() findSubjectsByCurriculumAndSubjectElectiveType$ = this.actions$
    .ofType(CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM_AND_SUBJECT_TYPE_ELECTIVE)
    .map((action) => action.payload)
    .switchMap((curriculum) => this.plannerService.findSubjectsByCurriculumAndSubjectTypeElective(curriculum))
    .map((subjects) => this.curriculumActions.findSubjectsByCurriculumAndSubjectElectiveTypeSuccess(subjects));

  @Effect() saveCurriculum$ = this.actions$
    .ofType(CurriculumActions.SAVE_CURRICULUM)
    .map((action) => action.payload)
    .switchMap((curriculum) => this.plannerService.saveCurriculum(curriculum))
    .map((curriculum) => this.curriculumActions.saveCurriculumSuccess(curriculum))
    .mergeMap((action) => from([action,this.curriculumActions.findCurriculums()]));

  @Effect() updateCurriculum$ = this.actions$
    .ofType(CurriculumActions.UPDATE_CURRICULUM)
    .map((action) => action.payload)
    .switchMap((curriculum) => this.plannerService.updateCurriculum(curriculum))
    .map((message) => this.curriculumActions.updateCurriculumSuccess(message))
    .withLatestFrom(this.store$.select(...this.CURRICULUM))
    .map((state) => state[1])
    .map((curriculum: Curriculum) => this.curriculumActions.findCurriculumByCode(curriculum.code));

  @Effect() addSingleSubject$ =
    this.actions$
      .ofType(CurriculumActions.ADD_SINGLE_SUBJECT)
      .map((action) => action.payload)
      .switchMap((payload) => this.plannerService.addSingleSubject(payload.curriculum, payload.subject))
      .map((message) => this.curriculumActions.addSingleSubjectSuccess(message))
      .withLatestFrom(this.store$.select(...this.CURRICULUM))
      .map((state) => state[1])
      .map((curriculum: Curriculum) => this.curriculumActions.findCurriculumByCode(curriculum.code));
  
  @Effect() addBundleSubject$ =
      this.actions$
        .ofType(CurriculumActions.ADD_BUNDLE_SUBJECT)
        .map((action) => action.payload)
        .switchMap((payload) => this.plannerService.addBundleSubject(payload.curriculum, payload.subject))
        .map((message) => this.curriculumActions.addBundleSubjectSuccess(message))
        .withLatestFrom(this.store$.select(...this.CURRICULUM))
        .map((state) => state[1])
        .map((curriculum: Curriculum) => this.curriculumActions.findCurriculumByCode(curriculum.code));

  @Effect() addSubjectPart$ =
    this.actions$
      .ofType(CurriculumActions.ADD_SUBJECT_PART)
      .map((action) => action.payload)
      .switchMap((payload) => this.plannerService.addSubjectPart(payload.bundleSubject, payload.subject))
      .map((message) => this.curriculumActions.addSubjectPartSuccess(message))
      .withLatestFrom(this.store$.select(...this.CURRICULUM))
      .map((state) => state[1])
      .map((curriculum: Curriculum) => this.curriculumActions.findCurriculumByCode(curriculum.code));

 @Effect() deleteSubject$ = this.actions$
    .ofType(CurriculumActions.REMOVE_SUBJECT)
    .map((action) => action.payload)
    .switchMap((payload) => this.plannerService.deleteSubject(payload.curriculum, payload.subject))
    .map((message) => this.curriculumActions.deleteSubjectSuccess(message))
    .withLatestFrom(this.store$.select(...this.CURRICULUM))
    .map((state) => state[1])
    .map((curriculum: Curriculum) => this.curriculumActions.findCurriculumByCode(curriculum.code));

 @Effect() deleteSubjectPart$ =
    this.actions$
      .ofType(CurriculumActions.REMOVE_SUBJECT_PART)
      .map((action) => action.payload)
      .switchMap((payload) => this.plannerService.deleteSubjectPart(payload.bundleSubject, payload.subject))
      .map((message) => this.curriculumActions.deleteSubjectPartSuccess(message))
      // .mergeMap((action) => from([action, this.curriculumActions.findCurriculums()]));
      .withLatestFrom(this.store$.select(...this.CURRICULUM))
      .map((state) => state[1])
      .map((curriculum: Curriculum) => this.curriculumActions.findCurriculumByCode(curriculum.code));    

    }