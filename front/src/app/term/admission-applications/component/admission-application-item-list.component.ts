import {Component, Input, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {ActivatedRoute, Router} from "@angular/router";
import {TermModuleState} from "../../index";
import {Store} from "@ngrx/store";
import {AdmissionApplication} from "../admission-application.interface";
import {AdmissionApplicationItem} from "../admission-application-item.interface";
import {AdmissionApplicationItemEditorDialog} from "../dialog/admission-application-item-editor.dialog";
import {AdmissionApplicationActions} from "../admission-application.action";

@Component({
  selector: 'pams-admission-application-item-list',
  templateUrl: './admission-application-item-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionApplicationItemComponent {
  @Input() admissionApplication: AdmissionApplication;
  @Input() admissionApplicationItems: AdmissionApplicationItem[];
  private editorDialogRef: MdDialogRef<AdmissionApplicationItemEditorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AdmissionApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }


  showDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '60%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(AdmissionApplicationItemEditorDialog, config);
    this.editorDialogRef.componentInstance.admissionApplication = this.admissionApplication;

    // close
    this.editorDialogRef.afterClosed().subscribe(res => {
      // do something
    });
  }
}
