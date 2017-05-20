import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {SectionActions} from "./section.action";
import {TermService} from "../../../services/term.service";
import {Store} from "@ngrx/store";
import {TermModuleState} from "../index";
import {OfferingActions} from "../offerings/offering.action";
import {Offering} from "../offerings/offering.interface";


@Injectable()
export class SectionEffects {

  private OFFERING: string[] = "termModuleState.offering".split(".");

  constructor(private actions$: Actions,
              private sectionActions: SectionActions,
              private offeringActions: OfferingActions,
              private termService: TermService,
              private store$: Store<TermModuleState>) {
  }

  @Effect() findSectionByCanonicalCode$ = this.actions$
    .ofType(SectionActions.FIND_SECTION_BY_CANONICAL_CODE)
    .map(action => action.payload)
    .switchMap(canonicalCode => this.termService.findSectionByCanonicalCode(canonicalCode))
    .map(section => this.sectionActions.findSectionByCanonicalCodeSuccess(section));

  @Effect() addSection$ =
    this.actions$
      .ofType(SectionActions.ADD_SECTION)
      .map(action => action.payload)
      .switchMap(payload => this.termService.addSection(payload.offering, payload.section))
      .map(message => this.sectionActions.addSectionSuccess(message))
      .withLatestFrom(this.store$.select(...this.OFFERING))
      .map(state => state[1])
      .map((offering: Offering) => this.offeringActions.findOfferingByCanonicalCode(offering.canonicalCode));

}
