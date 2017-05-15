import { Address } from './address.interface';
import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
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

  private STUDENT = "profileModuleState.student".split(".");
  private ADDRESSES = "profileModuleState.addresses".split(".");
  private GUARANTORS = "profileModuleState.guarantors".split(".");
  private GUARDIANS = "profileModuleState.guardians".split(".");
  private CONTACTS = "profileModuleState.contacts".split(".");

  private student$: Observable<Student>;
  private addressess$: Observable<Student>;
  private guarantors$: Observable<Guarantor>;
  private guardians$: Observable<Guardian>;
  private contacts$: Observable<Contact>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProfileActions,
              private store: Store<ProfileModuleState>) {

    this.student$ = this.store.select(...this.STUDENT);
    this.addressess$ = this.store.select(...this.ADDRESSES);
    this.guardians$ = this.store.select(...this.GUARDIANS);
    this.guarantors$ = this.store.select(...this.GUARANTORS);
    this.contacts$ = this.store.select(...this.CONTACTS);
  }

  ngOnInit(): void {
     this.route.params.subscribe((params: {identityNo: string}) => {
       let identityNo: string = params.identityNo;
      this.store.dispatch(this.actions.findProfile(identityNo));
    });
   }

  goBack(route: string): void {
    this.router.navigate(['/profiles']);
  }
}

