import { Enrollment } from './../../../shared/model/term/enrollment.interface';
import { Admission } from './../../../shared/model/term/admission.interface';
import { StudentProfileModuleState } from './../index';
import { StudentProfileActions } from './../student-profile.action';
import { Router, ActivatedRoute } from '@angular/router';
import { AcademicSession } from './../../../shared/model/planner/academic-session.interface';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { FormControl } from '@angular/forms';
import { ChangeDetectionStrategy, OnInit, Input, Output, EventEmitter, ViewContainerRef, Component } from "@angular/core";
import { MdDialogRef, MdDialog } from "@angular/material";
import { AcademicSemester } from "../../../shared/model/planner/academic-semester-type.enum";
import { AcademicYear } from "../../../shared/model/planner/academic-year.interface";
import { Student } from "../../../shared/model/identity/student.interface";

@Component({
  selector: 'pams-student-profile-exam',
  templateUrl: './student-profile-exam.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentProfileExamComponent implements OnInit {


  private STUDENT: string[] = 'studentProfileModuleState.student'.split('.');
  private STUDENTS: string[] = 'studentProfileModuleState.students'.split('.');
  private ACADEMIC_SESSION: string[] = 'studentProfileModuleState.academicSession'.split('.');
  private ENROLLMENTS: string[] = 'studentProfileModuleState.enrollments'.split('.');
  private ADMISSIONS: string[] = 'studentProfileModuleState.admissions'.split('.');
  private ADMISSION: string[] = 'studentProfileModuleState.admission'.split('.');
  private enrollments$: Observable<Enrollment>;
  private admissions$: Observable<Admission[]>;
  private admission$: Observable<Admission>;
  private academicSession$: Observable<AcademicSession>;
  private students$: Observable<Student[]>;
  private student$: Observable<Student>;

  @Input() admissions: Admission[];
  @Input() admission: Admission;
  @Input() enrollments: Enrollment[];
  @Input() enrollment: Enrollment;
  @Input() student: Student;
  @Input() academicSession: AcademicSession;
  @Input() semester: AcademicSemester;
  @Input() year: AcademicYear;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  @Output() view = new EventEmitter<AcademicSession>();


  constructor(private router: Router,
    private route: ActivatedRoute,
    private actions: StudentProfileActions,
    private vcf: ViewContainerRef,
    private store: Store<StudentProfileModuleState>,
    private dialog: MdDialog) {
    this.academicSession$ = this.store.select(...this.ACADEMIC_SESSION);
    this.students$ = this.store.select(...this.STUDENTS);
    this.student$ = this.store.select(...this.STUDENT);
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);
    this.admissions$ = this.store.select(...this.ADMISSIONS);
  }

  private columns: any[] = [
    { name: 'section.offering.code', label: 'Course Code' },
    { name: 'section.offering.course.credit', label: 'Credit' },
    { name: 'gradeCode.code', label: 'Grade' },

  ];

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findAcademicSessionByCode(code));
      this.store.dispatch(this.actions.findStudentByUser());
      console.log(this.enrollment.id);
    });
  }

}
