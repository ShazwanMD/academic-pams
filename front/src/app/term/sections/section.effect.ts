import { Injectable } from '@angular/core';
import { Effect, Actions } from '@ngrx/effects';
import { SectionActions } from "./section.action";
import { TermService } from "../../../services/term.service";


@Injectable()
export class SectionEffects {
  constructor(private actions$: Actions,
    private sectionActions: SectionActions,
    private termService: TermService, ) {
  }

  @Effect() findSectionByCanonicalCode$ = this.actions$
    .ofType(SectionActions.FIND_SECTION_BY_CANONICAL_CODE)
    .map(action => action.payload)
    .switchMap(canonicalCode => this.termService.findSectionByCanonicalCode(canonicalCode))
    .map(section => this.sectionActions.findSectionByCanonicalCodeSuccess(section));
}
