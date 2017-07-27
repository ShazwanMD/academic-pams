import {GpaCalculateDialog} from '../dialog/gpa-calculate.dialog';
import {GradebookCalculateDialog} from '../dialog/gradebook-calculate.dialog';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Offering} from '../../../shared/model/term/offering.interface';
import {OfferingUpdateDialog} from '../dialog/offering-update.dialog';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {OfferingActions} from '../offering.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';

@Component({
  selector: 'pams-offering-action',
  templateUrl: './offering-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingActionComponent {

  private editorDialogRef: MdDialogRef<OfferingUpdateDialog>;
  private GradebookCalculateDialog: MdDialogRef<GradebookCalculateDialog>;
  private GpaCalculateDialog: MdDialogRef<GpaCalculateDialog>;
  @Input() offering: Offering;

  constructor(private actions: OfferingActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {

  }

  updateDialog(): void {
    console.log('open offering dialog');
    console.log(this.offering.code);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(OfferingUpdateDialog, config);
    this.editorDialogRef.componentInstance.offering = this.offering;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog offering update');

    });
  }

  calculateGradebooks(): void {
    console.log('Open Calculate Alert Box');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.GradebookCalculateDialog = this.dialog.open(GradebookCalculateDialog, config);
    this.GradebookCalculateDialog.componentInstance.offering = this.offering;
    this.GradebookCalculateDialog.afterClosed().subscribe((res) => {
      console.log('Close Calculate Alert Box');

    });
  }

  // calculateGradebook(): void {
  //   console.log("calculate TotalScore");
  //   let snackBarRef = this.snackBar.open('Calculate Gradebook Score :', 'OK');
  //   snackBarRef.afterDismissed().subscribe(() => {
  //   this.store.dispatch(this.actions.calculateGradebook(this.offering));
  // }
  //   );
  // }

  calculateCGPA(): void {
    console.log('Open Calculate Alert Box');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.GpaCalculateDialog = this.dialog.open(GpaCalculateDialog, config);
    this.GpaCalculateDialog.componentInstance.offering = this.offering;
    this.GpaCalculateDialog.afterClosed().subscribe((res) => {
      console.log('Close Calculate Alert Box');

    });
  }

  //   calculateGPA(): void {
  //   console.log("calculate GPA");
  //   let snackBarRef = this.snackBar.open('Calculate GPA :', 'OK');
  //   snackBarRef.afterDismissed().subscribe(() => {
  //   this.store.dispatch(this.actions.calculateGPA(this.offering));
  // }
  //   );
  // }

}
