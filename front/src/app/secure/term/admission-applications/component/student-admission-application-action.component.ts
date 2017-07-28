import {AdmissionApplicationTaskEditorDialog} from '../dialog/admission-application-task-editor.dialog';
import {Store} from '@ngrx/store';
import {ChangeDetectionStrategy, Component, Input, ViewContainerRef} from '@angular/core';
import {TermModuleState} from '../../index';
import {AdmissionApplicationActions} from '../admission-application.action';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {AdmissionApplication} from '../../../../shared/model/term/admission-application.interface';

@Component({
  selector: 'pams-student-admission-application-action',
  templateUrl: './student-admission-application-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class StudentAdmissionApplicationActionComponent {

  private editorDialogRef: MdDialogRef<AdmissionApplicationTaskEditorDialog>;
  @Input() admissionApplication: AdmissionApplication;

  constructor(private actions: AdmissionApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

  }

  editDialog(): void {
    console.log('edit application');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(AdmissionApplicationTaskEditorDialog, config);
    this.editorDialogRef.componentInstance.admissionApplication = this.admissionApplication;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

}
