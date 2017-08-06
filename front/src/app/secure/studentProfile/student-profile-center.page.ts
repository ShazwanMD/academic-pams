import { StudentProfileModuleState } from './index';
import { StudentProfileActions } from './student-profile.action';
import { Component, OnInit, Input } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';

import {Student} from '../../shared/model/identity/student.interface';


@Component({
  selector: 'pams-student-profile-center',
  templateUrl: 'student-profile-center.page.html',
})

export class StudentProfileCenterPage implements OnInit {

  @Input() student: Student;
  private STUDENT: string[] = 'studentprofileModuleState.student'.split('.');
  private student$: Observable<Student>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: StudentProfileActions,
              private store: Store<StudentProfileModuleState>) {

    this.student$ = this.store.select(...this.STUDENT);
  }

  goBack(route: string): void {
    this.router.navigate(['/studentProfiles']);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { identityNo: string }) => {
      let identityNo: string = params.identityNo;
      this.store.dispatch(this.actions.findStudentByIdentityNo(identityNo));
    });
  }
}

