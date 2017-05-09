import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AdmissionActions} from "./admission.action";
import {TermService} from "../../../services/term.service";


@Injectable()
export class AdmissionEffects {
  constructor(private actions$: Actions,
              private admissionActions: AdmissionActions,
              private termService: TermService,) {
  }

  @Effect() findAdmissions$ = this.actions$
    .ofType(AdmissionActions.FIND_ADMISSIONS)
    .switchMap(() => this.termService.findAdmissions())
    .map(admissions => this.admissionActions.findAdmissionsSuccess(admissions));

  @Effect() findAdmissionById$ = this.actions$
    .ofType(AdmissionActions.FIND_ADMISSION_BY_ID)
    .map(action => action.payload);
  // todo
    // .switchMap(id => this.termService.findAdmissionById(id))
    // .map(admission => this.admissionActions.findAdmissionByIdSuccess(admission));
}
