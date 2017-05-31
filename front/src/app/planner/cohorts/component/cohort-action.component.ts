import { CohortUpdateDialog } from './../dialog/cohort-update.dialog';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Cohort} from "../cohort.interface";
import {CohortEditorDialog} from "../dialog/cohort-editor.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from "@angular/material";
import {CohortActions} from "../cohort.action";
import {Store} from "@ngrx/store";
import {PlannerModuleState} from "../../index";

@Component({
  selector: 'pams-cohort-action',
  templateUrl: './cohort-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CohortActionComponent {

  @Input() cohort: Cohort;
  private editorDialogRef: MdDialogRef<CohortUpdateDialog>;

  constructor(private actions: CohortActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {

  }

  editorDialog(): void {
    console.log("edit");
    console.log(this.cohort);  
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(CohortUpdateDialog, config);
    this.editorDialogRef.componentInstance.cohort = this.cohort;
    // set
    this.editorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

  delate(): void {
    let snackBarRef = this.snackBar.open("Delate Cohort", "OK");
   // snackBarRef.afterDismissed().subscribe(() => this.store.dispatch(this.actions.delateCohort(this.cohort)));
  }
}
