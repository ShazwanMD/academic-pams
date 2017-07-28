import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {GradebookActions} from './gradebook.action';
import {TermService} from '../../../../services/term.service';
import {Store} from '@ngrx/store';
import {SectionActions} from '../sections/section.action';
import {TermModuleState} from '../index';

@Injectable()
export class GradebookEffects {

  private SECTION: string[] = 'termModuleState.section'.split('.');

  constructor(private actions$: Actions,
              private gradebookActions: GradebookActions,
              private sectionActions: SectionActions,
              private termService: TermService,
              private store$: Store<TermModuleState>) {
  }

  @Effect() findGradebookById$ = this.actions$
    .ofType(GradebookActions.FIND_GRADEBOOK_BY_ID)
    .map((action) => action.payload)
    .switchMap((id) => this.termService.findGradebookById(id))
    .map((gradebook) => this.gradebookActions.findGradebookByIdSuccess(gradebook));

}
