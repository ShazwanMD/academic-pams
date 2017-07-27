import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {CurriculumActions} from './curriculum.action';
import {PlannerService} from '../../../services/planner.service';
import {Curriculum} from './curriculum.interface';
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

  @Effect() findCurriculumByCode$ = this.actions$
    .ofType(CurriculumActions.FIND_CURRICULUM_BY_CODE)
    .map((action) => action.payload)
    .switchMap((code) => this.plannerService.findCurriculumByCode(code))
    .map((curriculum) => this.curriculumActions.findCurriculumByCodeSuccess(curriculum))
    .mergeMap((action) => from([action,
      this.curriculumActions.findSubjectsByCurriculum(action.payload),
    ]));

  @Effect() findSubjectsByCurriculum$ = this.actions$
    .ofType(CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM)
    .map((action) => action.payload)
    .switchMap((curriculum) => this.plannerService.findSubjectsByCurriculum(curriculum))
    .map((subjects) => this.curriculumActions.findSubjectsByCurriculumSuccess(subjects));

  @Effect() saveCurriculum$ = this.actions$
    .ofType(CurriculumActions.SAVE_CURRICULUM)
    .map((action) => action.payload)
    .switchMap((curriculum) => this.plannerService.saveCurriculum(curriculum))
    .map((curriculum) => this.curriculumActions.saveCurriculumSuccess(curriculum));

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
      .withLatestFrom(this.store$.select(...this.CURRICULUM))
      .map((state) => state[1])
      .map((curriculum: Curriculum) => this.curriculumActions.findCurriculumByCode(curriculum.code));
}
