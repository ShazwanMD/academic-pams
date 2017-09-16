import {ChangeDetectionStrategy, Component, Input, ViewContainerRef} from '@angular/core';
import {GraduationApplication} from '../../../../shared/model/graduation/graduation-application.interface';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {Store} from '@ngrx/store';
import {GraduationModuleState} from '../../index';
import { GraduationApplicationActions } from "../graduation-application.action";

@Component({
  selector: 'pams-graduation-application-action',
  templateUrl: './graduation-application-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class GraduationApplicationActionComponent {

  @Input() graduationApplication: GraduationApplication;

  constructor(private actions: GraduationApplicationActions,
              private store: Store<GraduationModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {

  }

 }
