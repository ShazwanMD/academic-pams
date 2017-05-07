import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {OfferingActions} from "./offering.action";
import {TermService} from "../../../services/term.service";


@Injectable()
export class OfferingEffects {
  constructor(private actions$: Actions,
              private offeringActions: OfferingActions,
              private termService: TermService,) {
  }

  @Effect() findOfferings$ = this.actions$
    .ofType(OfferingActions.FIND_OFFERINGS)
    .switchMap(() => this.termService.findOfferings())
    .map(offerings => this.offeringActions.findOfferingsSuccess(offerings));

  @Effect() findOfferingByCanonicalCode$ = this.actions$
    .ofType(OfferingActions.FIND_OFFERING_BY_CANONICAL_CODE)
    .map(action => action.payload)
    .switchMap(canonicalCode => this.termService.findOfferingByCanonicalCode(canonicalCode))
    .map(offering => this.offeringActions.findOfferingByCanonicalCodeSuccess(offering));
}
