import { Observable } from 'rxjs';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {Input, Component, ViewContainerRef, ChangeDetectionStrategy} from '@angular/core';
import {Store} from '@ngrx/store';
import {ProfileActions} from "../profile.action";
import {ProfileModuleState} from "../index";
import {Student} from "../../identity/student.interface";
import {StudyModeSwitcherDialog} from "../dialog/study-mode-switcher.dialog";
import {CohortTransfererDialog} from "../dialog/cohort-transferer.dialog";

@Component({
  selector: 'pams-profile-action',
  templateUrl: './profile-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ProfileActionComponent {
  @Input() student: Student;

    private student$: Observable<Student>;
  private switcherDialogRef: MdDialogRef<StudyModeSwitcherDialog>;
  private transfererDialogRef: MdDialogRef<CohortTransfererDialog>;

  constructor(private actions: ProfileActions,
              private store: Store<ProfileModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
   
              private snackBar: MdSnackBar) {
  
}


  showTransferDialog(): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.transfererDialogRef = this.dialog.open(CohortTransfererDialog, config);
    this.transfererDialogRef.componentInstance.student = this.student;
    this.transfererDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  showSwitchDialog(): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.switcherDialogRef = this.dialog.open(StudyModeSwitcherDialog, config);
    this.switcherDialogRef.componentInstance.student = this.student;
    this.switcherDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

  deactivate(): void {
    let snackBarRef = this.snackBar.open("Deactivating Student : ?", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
        this.student$.take(1).subscribe(student =>
          this.store.dispatch(this.actions.deactivateStudent(student)))
      }
    );

  }

  activate(): void {
    let snackBarRef = this.snackBar.open("Activating Student : ?", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
        this.student$.take(1).subscribe(student =>
          this.store.dispatch(this.actions.activateStudent(student)))
      }
    );

  }

  bar(): void {
    let snackBarRef = this.snackBar.open("Barred Student : ?", "OK");
    snackBarRef.afterDismissed().subscribe(() => {
        this.student$.take(1).subscribe(student =>
          this.store.dispatch(this.actions.barStudent(student)))
      }
    );
  }

  disbar(): void {
  }
  

}

