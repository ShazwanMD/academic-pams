import { StudentProfileModuleState } from './../index';
import { StudentProfileActions } from './../student-profile.action';
import { Router, ActivatedRoute } from '@angular/router';
import { AcademicSession } from './../../../shared/model/planner/academic-session.interface';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import { ChangeDetectionStrategy, OnInit, Input, Output, EventEmitter, ViewContainerRef, Component } from "@angular/core";
import { MdDialogRef, MdDialog } from "@angular/material";
import { AcademicSemester } from "../../../shared/model/planner/academic-semester-type.enum";
import { AcademicYear } from "../../../shared/model/planner/academic-year.interface";

@Component({
  selector: 'pams-student-profile-exam',
  templateUrl: './student-profile-exam.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentProfileExamComponent implements OnInit {


  private ACADEMIC_SESSION: string[] = 'studentProfileModuleState.academicSession'.split('.');
  private academicSession$: Observable<AcademicSession>;

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
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findAcademicSessionByCode(code));
    });
  }

}
