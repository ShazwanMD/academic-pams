import { StudyModeSwitcherDialog } from './dialog/study-mode-switcher.dialog';
import { CohortTransfererDialog } from './dialog/cohort-transferer.dialog';
import {Enrollment} from './../term/enrollments/enrollment.interface';
import {Address} from './address.interface';
import {Input,Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Student} from "../identity/student.interface";
import {ProfileActions} from "./profile.action";
import {ProfileModuleState} from "./index";
import {Contact} from "./contact.interface";
import {Guardian} from "./guardian.interface";
import {Guarantor} from "./guarantor.interface";
import { MdSnackBar, MdDialogConfig, MdDialog, MdDialogRef } from '@angular/material';
import {Observable} from 'rxjs';

@Component({
  selector: 'pams-profile-detail',
  templateUrl: 'profile-detail.page.html',
})

export class ProfileDetailPage implements OnInit {
  @Input() student: Student;
  private STUDENT: string[] = "profileModuleState.student".split(".");
  private ADDRESSES: string[] = "profileModuleState.addresses".split(".");
  private GUARANTORS: string[] = "profileModuleState.guarantors".split(".");
  private GUARDIANS: string[] = "profileModuleState.guardians".split(".");
  private CONTACTS: string[] = "profileModuleState.contacts".split(".");
  private ENROLLMENTS: string[] = "profileModuleState.enrollments".split(".");

  private student$: Observable<Student>;
  private addressess$: Observable<Student>;
  private guarantors$: Observable<Guarantor>;
  private guardians$: Observable<Guardian>;
  private contacts$: Observable<Contact>;
  private enrollments$: Observable<Enrollment>;

  private switcherDialogRef: MdDialogRef<StudyModeSwitcherDialog>;
  private transfererDialogRef: MdDialogRef<CohortTransfererDialog>;  
  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProfileActions,
              private vcf: ViewContainerRef,
               private dialog: MdDialog,
              private store: Store<ProfileModuleState>,

              private snackBar: MdSnackBar) {

    this.student$ = this.store.select(...this.STUDENT);
    this.addressess$ = this.store.select(...this.ADDRESSES);
    this.guardians$ = this.store.select(...this.GUARDIANS);
    this.guarantors$ = this.store.select(...this.GUARANTORS);
    this.contacts$ = this.store.select(...this.CONTACTS);
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);
  }

  goBack(route: string): void {
    this.router.navigate(['/profiles']);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { identityNo: string }) => {
      let identityNo: string = params.identityNo;
      this.store.dispatch(this.actions.findStudentByIdentityNo(identityNo));
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

