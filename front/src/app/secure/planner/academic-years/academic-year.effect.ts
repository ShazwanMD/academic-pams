import {Injectable} from '@angular/core';
import {Actions, Effect} from '@ngrx/effects';
import {AcademicYearActions} from './academic-year.action';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../index';
import {from} from 'rxjs/observable/from';
import {PlannerService} from '../../../../services/planner.service';
import {AcademicYear} from '../../../shared/model/planner/academic-year.interface';
import { NotificationService } from "../../../../services/notification.service";

@Injectable()
export class AcademicYearEffects {

    private ACADEMIC_YEAR: string[] = 'plannerModuleState.academicYear'.split('.');

    constructor(private actions$: Actions,
        private academicYearActions: AcademicYearActions,
        private plannerService: PlannerService,
        private notificationService: NotificationService,
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
        .map((academicYear) => this.academicYearActions.updateAcademicYearSuccess(academicYear))
        //.mergeMap((action) => from([action, this.academicYearActions.findAcademicYears()]));
        .switchMap(() => this.plannerService.findAcademicYears())
        .map((academicYears) => this.academicYearActions.findAcademicYearsSuccess(academicYears));
}
