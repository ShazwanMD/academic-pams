import {Component, Input, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {ActivatedRoute, Router} from "@angular/router";
import {TermModuleState} from "../../index";
import {Store} from "@ngrx/store";
import {EnrollmentApplication} from "../enrollment-application.interface";
import {EnrollmentApplicationItem} from "../enrollment-application-item.interface";
import {EnrollmentApplicationItemEditorDialog} from "../dialog/enrollment-application-item-editor.dialog";
import {EnrollmentApplicationActions} from "../enrollment-application.action";

@Component({
  selector: 'pams-enrollment-application-item-list',
  templateUrl: './enrollment-application-item-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EnrollmentApplicationItemComponent {
  @Input() enrollmentApplication: EnrollmentApplication;
  @Input() enrollmentApplicationItems: EnrollmentApplicationItem[];
  private editorDialogRef: MdDialogRef<EnrollmentApplicationItemEditorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentApplicationActions,
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
    config.height = '40%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(EnrollmentApplicationItemEditorDialog, config);
    this.editorDialogRef.componentInstance.enrollmentApplication = this.enrollmentApplication;

    // close
    this.editorDialogRef.afterClosed().subscribe(res => {
      // do something
    });
  }
}
