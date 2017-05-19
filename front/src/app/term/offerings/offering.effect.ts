import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {OfferingActions} from "./offering.action";
import {TermService} from "../../../services/term.service";
import {from} from "rxjs/observable/from";


@Injectable()
export class OfferingEffects {
  constructor(private actions$: Actions,
              private offeringActions: OfferingActions,
              private termService: TermService) {
  }

  @Effect() findOfferings$ = this.actions$
    .ofType(OfferingActions.FIND_OFFERINGS)
    .switchMap(() => this.termService.findOfferings())
    .map(offerings => this.offeringActions.findOfferingsSuccess(offerings));

  @Effect() findOfferingByCanonicalCode$ = this.actions$
    .ofType(OfferingActions.FIND_OFFERING_BY_CANONICAL_CODE)
    .map(action => action.payload)
    .switchMap(canonicalCode => this.termService.findOfferingByCanonicalCode(canonicalCode))
    .map(offering => this.offeringActions.findOfferingByCanonicalCodeSuccess(offering))
    .mergeMap(action => from([action,
      this.offeringActions.findSectionsByOffering(action.payload),
      this.offeringActions.findAssessmentsByOffering(action.payload),
      this.offeringActions.findEnrollmentsByOffering(action.payload),
      this.offeringActions.findAppointmentsByOffering(action.payload)
    ]));

  @Effect() findSectionsByOffering$ = this.actions$
    .ofType(OfferingActions.FIND_SECTIONS_BY_OFFERING)
    .map(action => action.payload)
    .switchMap(offering => this.termService.findSectionsByOffering(offering))
    .map(sections => this.offeringActions.findSectionsByOfferingSuccess(sections));

  @Effect() findAssessmentsByOffering$ = this.actions$
    .ofType(OfferingActions.FIND_ASSESSMENTS_BY_OFFERING)
    .map(action => action.payload)
    .switchMap(offering => this.termService.findAssessmentsByOffering(offering))
    .map(sections => this.offeringActions.findAssessmentsByOfferingSuccess(sections));

  @Effect() findEnrollmentsByOffering$ = this.actions$
    .ofType(OfferingActions.FIND_ENROLLMENTS_BY_OFFERING)
    .map(action => action.payload)
    .switchMap(offering => this.termService.findEnrollmentsByOffering(offering))
    .map(sections => this.offeringActions.findEnrollmentsByOfferingSuccess(sections));

  @Effect() findAppointmentsByOffering$ = this.actions$
    .ofType(OfferingActions.FIND_APPOINTMENTS_BY_OFFERING)
    .map(action => action.payload)
    .switchMap(offering => this.termService.findAppointmentsByOffering(offering))
    .map(sections => this.offeringActions.findAppointmentsByOfferingSuccess(sections));
}
