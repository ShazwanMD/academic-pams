import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {ProfileActions} from "./profile.action";
import {Student} from "../identity/student.interface";
<<<<<<< HEAD
import {ProfileModuleState} from "./index";
=======
 import {ProfileModuleState} from "./index";
>>>>>>> 461c3a13eb004bc026e8724da3e6f63611c95374

@Component({
  selector: 'pams-profile-center',
  templateUrl: 'profile-center.page.html',
})

export class ProfileCenterPage implements OnInit {

  private STUDENTS = "profileModuleState.students".split(".");
  private students$: Observable<Student[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProfileActions,
<<<<<<< HEAD
             private store: Store<ProfileModuleState>
             ) {

  this.students$ = this.store.select(...this.STUDENTS);
=======
               private store: Store<ProfileModuleState>
  ) {

     this.students$ = this.store.select(...this.STUDENTS);
>>>>>>> 461c3a13eb004bc026e8724da3e6f63611c95374
  }

  goBack(route: string): void {
    this.router.navigate(['/profiles']);
  }

  viewProfile(student: Student) {
    console.log("profile: " + student.identityNo);
    this.router.navigate(['/profiles-detail', student.identityNo]);
  }

  ngOnInit(): void {
    console.log("find profiles");
<<<<<<< HEAD
    this.store.dispatch(this.actions.findProfiles());
=======
     this.store.dispatch(this.actions.findProfiles());
>>>>>>> 461c3a13eb004bc026e8724da3e6f63611c95374
  }
}

