import {FacultyEditorDialog} from './../dialog/faculty-editor.dialog';
import {Store} from '@ngrx/store';
import {MdSnackBar, MdDialogConfig, MdDialogRef} from '@angular/material';
import {MdDialog} from '@angular/material';
import {PlannerModuleState} from '../..';
import {ChangeDetectionStrategy, Component, Input, ViewContainerRef} from '@angular/core';

import {FacultyActions} from './../faculty.action';
import {Faculty} from '../../../shared/model/planner/faculty.interface';

@Component({
  selector: 'pams-faculty-action',
  templateUrl: './faculty-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class FacultyActionComponent {

  private FACULTY: string[] = 'plannerModuleState.faculty'.split('.');
  private editorDialogRef: MdDialogRef<FacultyEditorDialog>;

  @Input() faculty: Faculty;

  constructor(private actions: FacultyActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {

  }

  editorDialog(): void {
    console.log('edit');
    console.log(this.faculty);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(FacultyEditorDialog, config);
    this.editorDialogRef.componentInstance.faculty = this.faculty;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

  activate(): void {
    let snackBarRef = this.snackBar.open('Activating Faculty', 'OK');
    snackBarRef.afterDismissed().subscribe(() =>
      this.store.dispatch(this.actions.activateFaculty(this.faculty)));
  }

  deactivate(): void {
    let snackBarRef = this.snackBar.open('Deactivating Faculty', 'OK');
    snackBarRef.afterDismissed().subscribe(() =>
      this.store.dispatch(this.actions.deactivateFaculty(this.faculty)));
  }
}
