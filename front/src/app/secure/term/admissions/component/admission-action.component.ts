import {ChangeDetectionStrategy, Component, Input, ViewContainerRef} from '@angular/core';
import {Admission} from '../../../../shared/model/term/admission.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {AdmissionActions} from '../admission.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {AdmissionCreateTaskCreatorDialog} from '../dialog/admission-create-task-creator.dialog';
import { AssignSupervisorDialog } from "../dialog/assign-supervisor.dialog";
import { AdmissionApplicationCreatorDialog } from "../../admission-applications/dialog/admission-application-creator.dialog";

@Component({
  selector: 'pams-admission-action',
  templateUrl: './admission-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionActionComponent {

  private editorDialogRef: MdDialogRef<AdmissionCreateTaskCreatorDialog>;
  private editorDialogRef2: MdDialogRef<AssignSupervisorDialog>;
  private creatorDialogRef: MdDialogRef<AdmissionApplicationCreatorDialog>;

  @Input() admission: Admission;

  constructor(private actions: AdmissionActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

  }

  updateDialog(): void {
    console.log('open admission dialog');
    console.log(this.admission.id);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '40%';
    config.height = '87%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(AdmissionCreateTaskCreatorDialog, config);
    this.editorDialogRef.componentInstance.admission = this.admission;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog admission update');

    });
  }
  
  //ASSIGN SUPERVISOR
  assignSupervisor(): void {
      console.log('open assign supervisor dialog');
      console.log(this.admission.id);
      let config = new MdDialogConfig();
      config.viewContainerRef = this.vcf;
      config.role = 'dialog';
      config.width = '60%';
      config.height = '40%';
      config.position = {top: '0px'};
      this.editorDialogRef2 = this.dialog.open(AssignSupervisorDialog, config);
      this.editorDialogRef2.componentInstance.admission = this.admission;

      // set
      this.editorDialogRef2.afterClosed().subscribe((res) => {
        console.log('close assign supervisor dialog');

      });
    }
  
//SEMESTER REGISTRATION
  semesterRegister(): void {
      console.log('showDialog');
      let config = new MdDialogConfig();
      config.viewContainerRef = this.vcf;
      config.role = 'dialog';
      config.width = '60%';
      config.height = '40%';
      config.position = { top: '0px' };
      this.creatorDialogRef = this.dialog.open(AdmissionApplicationCreatorDialog, config);
      this.creatorDialogRef.componentInstance.admission = this.admission;
      this.creatorDialogRef.afterClosed().subscribe((res) => {
          console.log('close dialog');
          // load something here
      });
  }

}
