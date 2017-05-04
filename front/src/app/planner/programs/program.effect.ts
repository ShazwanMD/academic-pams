import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {ProgramActions} from "./program.action";
import {PlannerService} from "../../../services/planner.service";


@Injectable()
export class ProgramEffects {
  constructor(private actions$: Actions,
              private programActions: ProgramActions,
              private plannerService: PlannerService,) {
  }

  @Effect() findPrograms$ = this.actions$
    .ofType(ProgramActions.FIND_PROGRAMS)
    .switchMap(() => this.plannerService.findPrograms())
    .map(programs => this.programActions.findProgramsSuccess(programs));

  @Effect() findProgram$ = this.actions$
    .ofType(ProgramActions.FIND_PROGRAM)
    .map(action => action.payload)
    .switchMap(code => this.plannerService.findProgramByCode(code))
    .map(program => this.programActions.getProgramSuccess(program));

  @Effect() saveProgram$ = this.actions$
    .ofType(ProgramActions.SAVE_PROGRAM)
    .map(action => action.payload)
    .switchMap(program => this.plannerService.saveProgram(program))
    .map(program => this.programActions.saveProgramSuccess(program));
   // .map(() => this.programActions.findPrograms())

  @Effect() updateProgram$ = this.actions$
    .ofType(ProgramActions.UPDATE_PROGRAM)
    .map(action => action.payload)
    .switchMap(program => this.plannerService.updateProgram(program))
    .map(program => this.programActions.updateProgramSuccess(program));

  // @Effect() createProgram = this.actions$
  //   .ofType(ProgramActions.CREATE_PROGRAM)
  //   .map(action => action.payload)
  //   .switchMap(program => this.plannerService.saveProgram(program))
  //   .map(program => this.programActions.addProgramSuccess(program));
  //
  // @Effect() deleteProgram$ = this.actions$
  //   .ofType(ProgramActions.DELETE_PROGRAM)
  //   .map(action => action.payload)
  //   .switchMap(program => this.plannerService.deleteProgram(program))
  //   .map(program => this.programActions.deleteProgramSuccess(program));
}
