import { from } from 'rxjs/observable/from';
import { Admission } from './admission.interface';
import { TermModuleState } from "./../index";
import { Store } from '@ngrx/store';
import { Injectable } from '@angular/core';
import { Effect, Actions } from '@ngrx/effects';
import { AdmissionActions } from "./admission.action";
import { TermService } from "../../../services/term.service";


@Injectable()
export class AdmissionEffects {

  private ADMISSION: string[] = "termModuleState.admission".split(".");

  constructor(private actions$: Actions,
    private admissionActions: AdmissionActions,
    private termService: TermService,
    private store$: Store<TermModuleState>) {

  }

  @Effect() findAdmissions$ = this.actions$
    .ofType(AdmissionActions.FIND_ADMISSIONS)
    .switchMap(() => this.termService.findAdmissions())
    .map(admissions => this.admissionActions.findAdmissionsSuccess(admissions));

  @Effect() findAdmissionById$ = this.actions$
    .ofType(AdmissionActions.FIND_ADMISSION_BY_ID)
    .map(action => action.payload)
    .switchMap(id => this.termService.findAdmissionById(id))
    .map(admission => this.admissionActions.findAdmissionByIdSuccess(admission));

  @Effect() saveAdmission$ = this.actions$
    .ofType(AdmissionActions.SAVE_ADMISSION)
    .map(action => action.payload)
    .switchMap(payload => this.termService.saveAdmission(payload.admission))
    .map(admission => this.admissionActions.saveAdmissionSuccess(admission))
    .mergeMap(action => from([action,this.admissionActions.findAdmissions()
    ])); 
    // .withLatestFrom(this.store$.select(...this.ADMISSION))
    // .map(state => state[1])
    // .mergeMap(action => from([action, this.admissionActions.findAdmissions()]))
    // .map((admission: Admission) => this.admissionActions.findAdmissions(admission))
  

  @Effect() updateAdmission$ = this.actions$
    .ofType(AdmissionActions.UPDATE_ADMISSION)
    .map(action => action.payload)
    .switchMap(payload => this.termService.updateAdmission(payload))
    .map(message => this.admissionActions.updateAdmissionSuccess(message))
    .withLatestFrom(this.store$.select(...this.ADMISSION))
    .map(state => state[1])
    // .mergeMap(action => from([action, this.admissionActions.findAdmissions()]))
    .map((admission: Admission) => this.admissionActions.findAdmissions())
  ;
}
