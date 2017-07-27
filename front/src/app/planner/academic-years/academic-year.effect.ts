import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {PlannerService} from '../../../services/planner.service';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../index';
import { AcademicYearActions } from './academic-year.action';
@Injectable()
export class AcademicYearEffects {

   private ACADEMICYEAR: string[] = 'plannerModuleState.course'.split('.');

  constructor(private actions$: Actions,
              private academicYearActions: AcademicYearActions,
              private plannerService: PlannerService,
              private store$: Store<PlannerModuleState>) {
  }

  @Effect() findAcademicYears$ = this.actions$
    .ofType(AcademicYearActions.FIND_ACADEMICYEARS)
    .switchMap(() => this.plannerService.findAcademicYears())
    .map((academicYears) => this.academicYearActions.findAcademicYearsSuccess(academicYears));

}
