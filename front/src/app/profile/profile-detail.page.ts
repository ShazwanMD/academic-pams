import {Enrollment} from './../term/enrollments/enrollment.interface';
import {Address} from './address.interface';
import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Student} from "../identity/student.interface";
import {ProfileActions} from "./profile.action";
import {ProfileModuleState} from "./index";
import {Contact} from "./contact.interface";
import {Guardian} from "./guardian.interface";
import {Guarantor} from "./guarantor.interface";


@Component({
  selector: 'pams-profile-detail',
  templateUrl: 'profile-detail.page.html',
})

export class ProfileDetailPage implements OnInit {

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


  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProfileActions,
              private vcf: ViewContainerRef,
              private store: Store<ProfileModuleState>,) {

    this.student$ = this.store.select(...this.STUDENT);
    this.addressess$ = this.store.select(...this.ADDRESSES);
    this.guardians$ = this.store.select(...this.GUARDIANS);
    this.guarantors$ = this.store.select(...this.GUARANTORS);
    this.contacts$ = this.store.select(...this.CONTACTS);
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { identityNo: string }) => {
      let identityNo: string = params.identityNo;
      this.store.dispatch(this.actions.findStudentByIdentityNo(identityNo));
    });
  }


  deactivate(): void {
  }

  activate(): void {
  }

  bar(): void {
  }

  disbar(): void {
  }
}

