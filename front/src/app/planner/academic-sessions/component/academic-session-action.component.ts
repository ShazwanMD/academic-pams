import {MdDialog, MdSnackBar} from '@angular/material';
import {Input, Component, ViewContainerRef, ChangeDetectionStrategy} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';

import {PlannerModuleState} from "../../index";
import {AcademicSession} from "./../academic-session.interface";
import {AcademicSessionActions} from "../academic-session.action";


@Component({
  selector: 'pams-academic-session-action',
  templateUrl: './academic-session-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class AcademicSessionActionComponent {

  @Input() academicSession: AcademicSession;

  constructor(private actions: AcademicSessionActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {

  }

  activate(): void {
    let snackBarRef = this.snackBar.open("Activating Academic Session", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
        this.store.dispatch(this.actions.activateAcademicSession(this.academicSession))
      }
    );
  }

  deactivate(): void {
    let snackBarRef = this.snackBar.open("Deactivating Academic Session", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
        this.store.dispatch(this.actions.deactivateAcademicSession(this.academicSession))
      }
    );
  }
}


