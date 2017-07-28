import {MdDialog, MdSnackBar} from '@angular/material';
import {ChangeDetectionStrategy, Component, Input, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';

import {PlannerModuleState} from '../../index';
import {ProgramLevel} from '../../../../shared/model/planner/program-level.interface';
import {ProgramLevelActions} from '../program-level.action';

@Component({
  selector: 'pams-program-level-action',
  templateUrl: './program-level-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ProgramLevelActionComponent {

  @Input() programLevel: ProgramLevel;

  constructor(private actions: ProgramLevelActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {

  }

  activate(): void {
    // let snackBarRef = this.snackBar.open("Activating Program Level", "OK");
    // snackBarRef.afterDismissed().subscribe(() => {
    //     this.store.dispatch(this.actions.activateProgramLevel(this.programLevel))
    //   }
    // );
  }

  deactivate(): void {
    // let snackBarRef = this.snackBar.open("Deactivating Program Level", "OK");
    // snackBarRef.afterDismissed().subscribe(() => {
    //     this.store.dispatch(this.actions.deactivateProgramLevel(this.programLevel))
    //   }
    // );
  }
}

