import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Admission} from "../admission.interface";
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from "@angular/material";
import {AdmissionActions} from "../admission.action";
import {Store} from "@ngrx/store";
import {TermModuleState} from "../../index";
import { AdmissionCreateTaskCreatorDialog } from "../dialog/admission-create-task-creator.dialog";

@Component({
  selector: 'pams-admission-action',
  templateUrl: './admission-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionActionComponent {

  @Input() admission: Admission;
  private editorDialogRef: MdDialogRef<AdmissionCreateTaskCreatorDialog>;

  constructor(private actions: AdmissionActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

  }

  updateDialog(): void {
    console.log("open admission dialog");
    console.log(this.admission.id);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '95%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(AdmissionCreateTaskCreatorDialog, config);
    this.editorDialogRef.componentInstance.admission = this.admission;

    // set
    this.editorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog admission update");
      
    });
  }

}