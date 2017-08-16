import { MdDialogRef, MdDialogConfig, MdDialog } from '@angular/material';
import { Contact } from './../../shared/model/profile/contact.interface';
import { Guardian } from './../../shared/model/profile/guardian.interface';
import { Guarantor } from './../../shared/model/profile/guarantor.interface';
import { ProfileActions } from './../profile/profile.action';
import { StudentProfileModuleState } from './index';
import { StudentProfileActions } from './student-profile.action';
import { Component, OnInit, Input, EventEmitter, Output, ViewContainerRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';

import { Student } from '../../shared/model/identity/student.interface';
import { Address } from "../../shared/model/profile/address.interface";
import { Enrollment } from "../../shared/model/term/enrollment.interface";
import { FormBuilder } from "@angular/forms";

@Component({
  selector: 'pams-student-profile-center',
  templateUrl: 'student-profile-center.page.html',
})

export class StudentProfileCenterPage implements OnInit {


  @Input() student: Student;
  @Input() addressess: Address[];

  private STUDENT: string[] = 'studentProfileModuleState.student'.split('.');
  private ADDRESSES: string[] = 'studentProfileModuleState.addresses'.split('.');
  private STUDENTS: string[] = 'studentProfileModuleState.students'.split('.');
  private GUARANTORS: string[] = 'studentProfileModuleState.guarantors'.split('.');
  private GUARDIANS: string[] = 'studentProfileModuleState.guardians'.split('.');
  private CONTACTS: string[] = 'studentProfileModuleState.contacts'.split('.');
  private ENROLLMENTS: string[] = 'studentProfileModuleState.enrollments'.split('.');

  private students$: Observable<Student[]>;
  private student$: Observable<Student>;
  private addressess$: Observable<Address[]>;
  private guarantors$: Observable<Guarantor>;
  private guardians$: Observable<Guardian>;
  private contacts$: Observable<Contact>;
  private enrollments$: Observable<Enrollment>;

  private _student: Student;
  constructor(private router: Router,
    private route: ActivatedRoute,
    private actions: StudentProfileActions,
    private profileActions: ProfileActions,
    private dialog: MdDialog,
    private vcf: ViewContainerRef,
    private formBuilder: FormBuilder,
    private store: Store<StudentProfileModuleState>) {

    this.students$ = this.store.select(...this.STUDENTS);
    this.student$ = this.store.select(...this.STUDENT);
    this.addressess$ = this.store.select(...this.ADDRESSES);
    this.guardians$ = this.store.select(...this.GUARDIANS);
    this.guarantors$ = this.store.select(...this.GUARANTORS);
    this.contacts$ = this.store.select(...this.CONTACTS);
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);
  }

  goBack(route: string): void {
    this.router.navigate(['/studentProfiles']);
  }
  
  viewDetail(student: Student) {
    console.log('profile: ' + student.identityNo);
    // this.router.navigate(['/profiles-detail', student.identityNo]);
  }
  
  ngOnInit(): void {
    console.log("find Student Profile");
    this.store.dispatch(this.actions.findStudentByUser());
    //this.actions.findStudentByIdentityNo(student.identityNo);

  }
}

