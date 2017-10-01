import {AcademicSessionEditorDialog} from '../dialog/academic-session-editor.dialog';
import {MdDialogConfig, MdDialogRef} from '@angular/material/dialog';
import {MdDialog, MdSnackBar} from '@angular/material';
import {ChangeDetectionStrategy, Component, Input, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';

import {PlannerModuleState} from '../../index';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {AcademicSessionActions} from '../academic-session.action';

@Component({
  selector: 'pams-academic-session-graduation-action',
  templateUrl: './academic-session-graduation-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class AcademicSessionGraduationActionComponent {

  private editorDialogRef: MdDialogRef<AcademicSessionEditorDialog>;

  @Input() academicSession: AcademicSession;

  constructor(private actions: AcademicSessionActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {

  }

  editSession(): void {
    console.log('edit');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(AcademicSessionEditorDialog, config);
    this.editorDialogRef.componentInstance.academicSession = this.academicSession;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

  activate(): void {
    let snackBarRef = this.snackBar.open('Activating Academic Session', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
        this.store.dispatch(this.actions.activateAcademicSession(this.academicSession));
      },
    );
  }

  deactivate(): void {
    let snackBarRef = this.snackBar.open('Deactivating Academic Session', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
        this.store.dispatch(this.actions.deactivateAcademicSession(this.academicSession));
      },
    );
  }
}

