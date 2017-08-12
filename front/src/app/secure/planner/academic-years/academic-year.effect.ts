import {Injectable} from '@angular/core';
import {Actions, Effect} from '@ngrx/effects';
import {PlannerService} from '../../../../services/planner.service';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../index';
import {AcademicYearActions} from './academic-year.action';
import {from} from 'rxjs/observable/from';

@Injectable()
export class AcademicYearEffects {

    private ACADEMIC_YEAR: string[] = 'plannerModuleState.academicYear'.split('.');

  constructor(private actions$: Actions,
              private academicYearActions: AcademicYearActions,
              private plannerService: PlannerService,
              private store$: Store<PlannerModuleState>) {
  }

  @Effect() findAcademicYears$ = this.actions$
    .ofType(AcademicYearActions.FIND_ACADEMIC_YEARS)
    .switchMap(() => this.plannerService.findAcademicYears())
    .map((academicYears) => this.academicYearActions.findAcademicYearsSuccess(academicYears));

  @Effect() findAcademicYearByCode$ = this.actions$
  .ofType(AcademicYearActions.FIND_ACADEMIC_YEAR_BY_CODE)
  .map((action) => action.payload)
  .switchMap((code) => this.plannerService.findAcademicYearByCode(code))
  .map((academicYear) => this.academicYearActions.findAcademicYearByCodeSuccess(academicYear));

  @Effect() saveAcademicYear$ = this.actions$
  .ofType(AcademicYearActions.SAVE_ACADEMIC_YEAR)
  .map((action) => action.payload)
  .switchMap((academicYear) => this.plannerService.saveAcademicYear(academicYear))
  .map((message) => this.academicYearActions.saveAcademicYearSuccess(message))
  .mergeMap((action) => from([action, this.academicYearActions.findAcademicYears()]));
  //.catch((error) => this.notificationService.showError(error));

@Effect() updateAcademicYear$ = this.actions$
  .ofType(AcademicYearActions.UPDATE_ACADEMIC_YEAR)
  .map((action) => action.payload)
  .switchMap((academicYear) => this.plannerService.updateAcademicYear(academicYear))
  .map((academicYear) => this.academicYearActions.updateAcademicYearSuccess(academicYear));
  //.withLatestFrom(this.store$.select(...this.ACADEMIC_YEAR))
  //.map((state) => state[1])
  //.map((academicYear: AcademicYear) => this.academicYearActions.findAcademicYearByCode(academicYear.code));

  
}
