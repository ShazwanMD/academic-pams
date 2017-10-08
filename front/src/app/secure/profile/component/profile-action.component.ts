import { MinAmountDialog } from './../dialog/minAmount.dialog';
import {StudentStatusDialog} from '../dialog/student-status.dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {ChangeDetectionStrategy, Component, Input, ViewContainerRef} from '@angular/core';
import {Store} from '@ngrx/store';
import {ProfileActions} from '../profile.action';
import {ProfileModuleState} from '../index';
import {Student} from '../../../shared/model/identity/student.interface';
import {StudyModeSwitcherDialog} from '../dialog/study-mode-switcher.dialog';
import {CohortTransfererDialog} from '../dialog/cohort-transferer.dialog';

@Component({
  selector: 'pams-profile-action',
  templateUrl: './profile-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ProfileActionComponent {

  private student$: Observable<Student>;
  private switcherDialogRef: MdDialogRef<StudyModeSwitcherDialog>;
  private transfererDialogRef: MdDialogRef<CohortTransfererDialog>;
  private studentStatusDialogRef: MdDialogRef<StudentStatusDialog>;
  private minAmountDialogRef: MdDialogRef<MinAmountDialog>;
  @Input() student: Student;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProfileActions,
              private store: Store<ProfileModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { identityNo: string }) => {
      let identityNo: string = params.identityNo;
      this.store.dispatch(this.actions.findStudentByIdentityNo(identityNo));
    });

  }

  showTransferDialog(student: Student): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.transfererDialogRef = this.dialog.open(CohortTransfererDialog, config);
    this.transfererDialogRef.componentInstance.student = this.student;
    this.transfererDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  showSwitchDialog(student: Student): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.switcherDialogRef = this.dialog.open(StudyModeSwitcherDialog, config);
    this.switcherDialogRef.componentInstance.student = this.student;
    this.switcherDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  studentStatusDialog(student: Student): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.studentStatusDialogRef = this.dialog.open(StudentStatusDialog, config);
    this.studentStatusDialogRef.componentInstance.student = this.student;
    this.studentStatusDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

    addMinAmountDialog(student: Student): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.minAmountDialogRef = this.dialog.open(MinAmountDialog, config);
    this.minAmountDialogRef.componentInstance.student = this.student;
    this.minAmountDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

}

