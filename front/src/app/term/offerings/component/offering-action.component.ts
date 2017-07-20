import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef } from '@angular/core';
import { Offering } from '../offering.interface';
import { OfferingUpdateDialog } from '../dialog/offering-update.dialog';
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from '@angular/material';
import { OfferingActions } from '../offering.action';
import { Store } from '@ngrx/store';
import { TermModuleState } from '../../index';

@Component({
  selector: 'pams-offering-action',
  templateUrl: './offering-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingActionComponent {

  @Input() offering: Offering;
  private editorDialogRef: MdDialogRef<OfferingUpdateDialog>;

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
    config.position = { top: '0px' };
    this.editorDialogRef = this.dialog.open(OfferingUpdateDialog, config);
    this.editorDialogRef.componentInstance.offering = this.offering;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog offering update');

    });
  }

  calculateGradebook(): void {
    console.log("calculate TotalScore");
    let snackBarRef = this.snackBar.open('Calculate Gradebook Score :', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
    this.store.dispatch(this.actions.calculateGradebook(this.offering));
  }
    );
  }
}
