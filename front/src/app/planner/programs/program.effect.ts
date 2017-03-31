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

  @Effect() loadPrograms$ = this.actions$
    .ofType(ProgramActions.LOAD_PROGRAMS)
    .switchMap(() => this.plannerService.findPrograms())
    .map(programs =>
       this.programActions.loadProgramsSuccess(programs));

  // @Effect() getProgram$ = this.actions$
  //   .ofType(ProgramActions.GET_PROGRAM)
  //   .map<string>(action => action.payload)
  //   .switchMap(code => this.plannerService.findProgramByCode(code))
  //   .map(program => this.programActions.getProgramSuccess(program));

  // @Effect() saveProgram$ = this.actions$
  //   .ofType(ProgramActions.SAVE_PROGRAM)
  //   .map(action => action.payload)
  //   .switchMap(program => this.svc.saveProgram(program))
  //   .map(program => this.programActions.saveProgramSuccess(program));
  //
  // @Effect() createProgram = this.actions$
  //   .ofType(ProgramActions.CREATE_PROGRAM)
  //   .map(action => action.payload)
  //   .switchMap(program => this.svc.saveProgram(program))
  //   .map(program => this.programActions.addProgramSuccess(program));
  //
  // @Effect() deleteProgram$ = this.actions$
  //   .ofType(ProgramActions.DELETE_PROGRAM)
  //   .map(action => action.payload)
  //   .switchMap(program => this.svc.deleteProgram(program))
  //   .map(program => this.programActions.deleteProgramSuccess(program));
}
