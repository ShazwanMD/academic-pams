import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {SectionActions} from "./section.action";
import {TermService} from "../../../services/term.service";


@Injectable()
export class SectionEffects {
  constructor(private actions$: Actions,
              private sectionActions: SectionActions,
              private termService: TermService,) {
  }

  @Effect() findSections$ = this.actions$
    .ofType(SectionActions.FIND_SECTIONS)
    .switchMap(() => this.termService.findSections())
    .map(sections => this.sectionActions.findSectionsSuccess(sections));

  @Effect() findSectionById$ = this.actions$
    .ofType(SectionActions.FIND_SECTION_BY_CANONICAL_CODE)
    .map(action => action.payload)
    .switchMap(id => this.termService.findSectionByCanonicalCode(id))
    .map(section => this.sectionActions.findSectionByCanonicalCodeSuccess(section));
}
