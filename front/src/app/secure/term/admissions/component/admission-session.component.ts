import {Admission} from '../../../../shared/model/term/admission.interface';
import {Enrollment} from '../../../../shared/model/term/enrollment.interface';
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { FormControl } from '@angular/forms';
import { ChangeDetectionStrategy, OnInit, Input, Output, EventEmitter, ViewContainerRef, Component } from "@angular/core";
import { MdDialogRef, MdDialog } from "@angular/material";
import { StudentProfileActions } from '../../../studentProfile/student-profile.action';
import { StudentProfileModuleState } from '../../../studentProfile/index';

@Component({
  selector: 'pams-admission-session',
  templateUrl: './admission-session.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionSessionComponent {

  @Input() admission: Admission;
  @Input() enrollments: Enrollment[];
  @Input() enrollmentApplications: EnrollmentApplication[];
  @Output() view = new EventEmitter<Admission>();
  
  
  private ENROLLMENTS: string[] = 'studentProfileModuleState.enrollments'.split('.');
  private enrollments$: Observable<Enrollment>;
  
  
  constructor(private router: Router,
          private route: ActivatedRoute,
          private actions: StudentProfileActions,
          private vcf: ViewContainerRef,
          private store: Store<StudentProfileModuleState>,
          private dialog: MdDialog) {
         
          this.enrollments$ = this.store.select(...this.ENROLLMENTS);
         
        }
  
  private columns: any[] = [
      { name: 'section.offering.titleEn', label: 'Course Title' },
      { name: 'section.offering.code', label: 'Course Code' },
      { name: 'section.offering.course.credit', label: 'Credit' },
      { name: 'gradeCode.code', label: 'Grade' },
      { name: 'gradeCode.description', label: 'Description' },
      ];
  
  
}
