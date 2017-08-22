import { AcademicSession } from './../../shared/model/planner/academic-session.interface';
import { StudentProfileModuleState } from './index';
import { StudentProfileActions } from './student-profile.action';
import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';


@Component({
  selector: 'pams-student-profile-exam-page',
  templateUrl: './student-profile-exam.page.html',
})

export class StudentProfileExamPage implements OnInit {

  private ACADEMIC_SESSION: string[] = 'studentProfileModuleState.academicSession'.split('.');
  private academicSession$: Observable<AcademicSession>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: StudentProfileActions,
              private store: Store<StudentProfileModuleState>) {
    this.academicSession$ = this.store.select(...this.ACADEMIC_SESSION);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findAcademicSessionByCode(code));
    });
  }

}
