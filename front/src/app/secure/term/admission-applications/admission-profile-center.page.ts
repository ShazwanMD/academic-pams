import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import { ProfileActions } from "../../profile/profile.action";
import { Student } from "../../../shared/model/identity/student.interface";
import { ProfileModuleState } from "../../profile/index";

@Component({
  selector: 'pams-admission-profile-center',
  templateUrl: 'admission-profile-center.page.html',
})

export class AdmissionProfileCenterPage2  {

  /*private STUDENTS: string[] = 'profileModuleState.students'.split('.');
  private students$: Observable<Student[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProfileActions,
              private store: Store<ProfileModuleState>) {

    this.students$ = this.store.select(...this.STUDENTS);
  }

  goBack(route: string): void {
    this.router.navigate(['/profiles']);
  }

  viewProfile(student: Student) {
    console.log('profile: ' + student.identityNo);
    this.router.navigate(['/profiles-detail', student.identityNo]);
  }

  ngOnInit(): void {
    console.log('find profiles');
    this.store.dispatch(this.actions.findStudents());
  }*/
}

