import {StudyModeSwitcherDialog} from './dialog/study-mode-switcher.dialog';
import {CohortTransfererDialog} from './dialog/cohort-transferer.dialog';
import {Enrollment} from '../../shared/model/term/enrollment.interface';
import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {Store} from '@ngrx/store';
import {Student} from '../../shared/model/identity/student.interface';
import {ProfileActions} from './profile.action';
import {ProfileModuleState} from './index';
import {Contact} from '../../shared/model/profile/contact.interface';
import {Guardian} from '../../shared/model/profile/guardian.interface';
import {Guarantor} from '../../shared/model/profile/guarantor.interface';
import {MdDialog, MdDialogRef, MdSnackBar} from '@angular/material';
import {Observable} from 'rxjs';
import { AdmissionApplication } from "../../shared/model/term/admission-application.interface";
import { Admission } from "../../shared/model/term/admission.interface";

@Component({
  selector: 'pams-advisory-detail',
  templateUrl: 'advisory-detail.page.html',
})

export class AdvisoryDetailPage implements OnInit {
    
  private STUDENT: string[] = 'profileModuleState.student'.split('.');
  private ADDRESSES: string[] = 'profileModuleState.addresses'.split('.');
  private ADMISSION_APPLICATIONS: string[] = 'profileModuleState.admissionApplications'.split('.');
  private ADMISSIONS: string[] = 'profileModuleState.admissions'.split('.');
  private GUARANTORS: string[] = 'profileModuleState.guarantors'.split('.');
  private GUARDIANS: string[] = 'profileModuleState.guardians'.split('.');
  private CONTACTS: string[] = 'profileModuleState.contacts'.split('.');
  private ENROLLMENTS: string[] = 'profileModuleState.enrollments'.split('.');

  private student$: Observable<Student>;
  private admissionApplications$: Observable<AdmissionApplication>;
  private admissions$: Observable<Admission>;
  private addressess$: Observable<Student>;
  private guarantors$: Observable<Guarantor>;
  private guardians$: Observable<Guardian>;
  private contacts$: Observable<Contact>;
  private enrollments$: Observable<Enrollment>;
  private switcherDialogRef: MdDialogRef<StudyModeSwitcherDialog>;
  private transfererDialogRef: MdDialogRef<CohortTransfererDialog>;

  @Input() student: Student;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProfileActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private store: Store<ProfileModuleState>,
              private snackBar: MdSnackBar) {

    this.student$ = this.store.select(...this.STUDENT);
    this.admissionApplications$ = this.store.select(...this.ADMISSION_APPLICATIONS);
    this.admissions$ = this.store.select(...this.ADMISSIONS);
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
    let snackBarRef = this.snackBar.open('Deactivating Student : ?', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
        this.student$.take(1).subscribe((student) =>
          this.store.dispatch(this.actions.deactivateStudent(student)));
      },
    );

  }

  activate(): void {
    let snackBarRef = this.snackBar.open('Activating Student : ?', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
        this.student$.take(1).subscribe((student) =>
          this.store.dispatch(this.actions.activateStudent(student)));
      },
    );

  }

  bar(): void {
    let snackBarRef = this.snackBar.open('Barred Student : ?', 'OK');
    snackBarRef.afterDismissed().subscribe(() => {
        this.student$.take(1).subscribe((student) =>
          this.store.dispatch(this.actions.barStudent(student)));
      },
    );
  }

  disbar(): void {
  }
}

