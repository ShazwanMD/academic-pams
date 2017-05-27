import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Program} from "../program.interface";
import {ProgramEditorDialog} from "../dialog/program-editor.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from "@angular/material";
import {ProgramActions} from "../program.action";
import {Store} from "@ngrx/store";
import {PlannerModuleState} from "../../index";

@Component({
  selector: 'pams-program-action',
  templateUrl: './program-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramActionComponent {

  @Input() program: Program;
  private editorDialogRef: MdDialogRef<ProgramEditorDialog>;

  constructor(private actions: ProgramActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {

  }

  editorDialog(): void {
    console.log("edit");
    console.log(this.program);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(ProgramEditorDialog, config);
    this.editorDialogRef.componentInstance.program = this.program;

    // set
    this.editorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

  // deleteProgram(program:Program): void {
  //   this.store.dispatch(this.actions.deleteProgram(this._Program))
  // }


  deactivate(): void {
    let snackBarRef = this.snackBar.open("Deactivating Program", "OK");
    snackBarRef.afterDismissed().subscribe(() => this.store.dispatch(this.actions.deactivateProgram(this.program)));
  }

  activate(): void {
    let snackBarRef = this.snackBar.open("Activating Program", "OK");
    snackBarRef.afterDismissed().subscribe(() => this.store.dispatch(this.actions.activateProgram(this.program)));
  }
}
