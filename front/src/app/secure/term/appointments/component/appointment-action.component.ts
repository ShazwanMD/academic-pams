import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Appointment} from '../../../../shared/model/term/appointment.interface';
import {Section} from '../../../../shared/model/term/section.interface';
import {AppointmentEditorDialog} from '../dialog/appointment-editor.dialog';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {AppointmentActions} from '../appointment.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';

@Component({
  selector: 'pams-appointment-action',
  templateUrl: './appointment-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AppointmentActionComponent {

  private editorDialogRef: MdDialogRef<AppointmentEditorDialog>;
  @Input() section: Section;
  @Input() appointment: Appointment;

  constructor(private actions: AppointmentActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

  }

  updateDialog(): void {
    console.log('open appointment dialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(AppointmentEditorDialog, config);
    this.editorDialogRef.componentInstance.appointment = this.appointment;
    this.editorDialogRef.componentInstance.section = this.section;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog offering update');

    });
  }

}
