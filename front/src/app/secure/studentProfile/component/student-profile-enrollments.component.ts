import { StudentDetailEditorDialog } from './../dialog/student-detail-editor.dialog';
import { Router, ActivatedRoute } from '@angular/router';
import { Student } from './../../../shared/model/identity/student.interface';
import { ChangeDetectionStrategy, Component, Input, ViewContainerRef, EventEmitter, Output } from '@angular/core';
import { Enrollment } from '../../../shared/model/term/enrollment.interface';
import { StudentProfileActions } from "../student-profile.action";
import { StudentProfileModuleState } from "../index";
import { Store } from "@ngrx/store";
import { FormBuilder } from "@angular/forms";
import { MdDialog, MdDialogConfig, MdDialogRef } from "@angular/material";

@Component({
  selector: 'pams-student-profile-enrollments',
  templateUrl: 'student-profile-enrollments.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentProfileEnrollmentsComponent {

  private columns: any[] = [
    { name: 'admission.academicSession.code', label: 'Semester' },
    { name: 'section.offering.code', label: 'Course Code' },
    { name: 'section.offering.course.credit', label: 'Credit' },
    { name: 'gradeCode.code', label: 'Grade' },
  ];

  @Input() enrollments: Enrollment[];

}
