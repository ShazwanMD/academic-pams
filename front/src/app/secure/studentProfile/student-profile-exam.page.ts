import { Admission } from './../../shared/model/term/admission.interface';
import { Student } from './../../shared/model/identity/student.interface';
import { AcademicSession } from './../../shared/model/planner/academic-session.interface';
import { StudentProfileModuleState } from './index';
import { StudentProfileActions } from './student-profile.action';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Enrollment } from "../../shared/model/term/enrollment.interface";


@Component({
  selector: 'pams-student-profile-exam-page',
  templateUrl: './student-profile-exam.page.html',
})

export class StudentProfileExamPage implements OnInit {

  private STUDENT: string[] = 'studentProfileModuleState.student'.split('.');
  private STUDENTS: string[] = 'studentProfileModuleState.students'.split('.');
  private ACADEMIC_SESSION: string[] = 'studentProfileModuleState.academicSession'.split('.');
  private ENROLLMENTS: string[] = 'studentProfileModuleState.enrollmentStudents'.split('.');
  private ENROLLMENT: string[] = 'studentProfileModuleState.enrollment'.split('.');
  private ADMISSIONS: string[] = 'studentProfileModuleState.admissions'.split('.');
  private ADMISSION: string[] = 'studentProfileModuleState.admission'.split('.');
  private enrollments$: Observable<Enrollment>;
  private enrollment$: Observable<Enrollment>;
  private admissions$: Observable<Admission[]>;
  private admission$: Observable<Admission>;
  private academicSession$: Observable<AcademicSession>;
  private students$: Observable<Student[]>;
  private student$: Observable<Student>;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private actions: StudentProfileActions,
    private store: Store<StudentProfileModuleState>) {
    this.academicSession$ = this.store.select(...this.ACADEMIC_SESSION);
    this.students$ = this.store.select(...this.STUDENTS);
    this.student$ = this.store.select(...this.STUDENT);
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);
    this.admissions$ = this.store.select(...this.ADMISSIONS);
    this.admission$ = this.store.select(...this.ADMISSION);
    this.enrollment$ = this.store.select(...this.ENROLLMENT);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { id: number }) => {
      let id: number = params.id;
      this.store.dispatch(this.actions.findAdmissionsById(id));
      this.store.dispatch(this.actions.findEnrollmentsByAdmissionsID(id));

    });
  }

}
