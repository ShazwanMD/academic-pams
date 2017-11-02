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
import { AdmissionActions } from "../../term/admissions/admission.action";
import { ReportActions } from "../../../shared/report/report.action";
import { TermModuleState } from "../../term/index";


@Component({
  selector: 'pams-student-profile-exam',
  templateUrl: './student-profile-exam.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentProfileExamComponent {

  @Input() admission: Admission;
  @Input() student: Student;
  @Input() enrollments: Enrollment[];
  
  constructor( private actions: AdmissionActions,
          private store: Store<TermModuleState>,
          private reportActions: ReportActions,
          private vcf: ViewContainerRef,
          private dialog: MdDialog ) {

      }

  
  private columns: any[] = [
   
    { name: 'section.offering.code', label: 'Course Code' },
    { name: 'section.offering.titleEn', label: 'Course Name' },
    { name: 'section.offering.course.credit', label: 'Credit' },
    { name: 'gradeCode.code', label: 'Grade' },
    { name: 'gradeCode.description', label: 'Description' },
  ];
  
//download report
  downloadReport( reportId, parameterReport: Admission ): void {
      let repParam = reportId + '&identity_no=' + parameterReport.student.identityNo + '&session_code=' + parameterReport.academicSession.code ;
      this.store.dispatch( this.reportActions.downloadReport( repParam ) );
  }
  
}
