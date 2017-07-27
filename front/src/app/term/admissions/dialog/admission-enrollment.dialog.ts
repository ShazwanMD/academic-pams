import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef, Input, EventEmitter, Output} from '@angular/core';
import { Cohort } from '../../../shared/model/planner/cohort.interface';
import { StudyCenter } from '../../../setup/study-centers/study-center.interface';
import { Student } from '../../../shared/model/identity/student.interface';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Store } from '@ngrx/store';
import { MdDialogRef } from '@angular/material';
import { TermModuleState } from '../../index';
import { AcademicSession } from '../../../shared/model/planner/academic-session.interface';
import { Admission } from '../../../shared/model/term/admission.interface';
import { AdmissionActions } from '../admission.action';
import { Observable } from 'rxjs/Observable';
import { Enrollment } from '../../../shared/model/term/enrollment.interface';

@Component( {
    selector: 'pams-admission-enrollment',
    templateUrl: './admission-enrollment.dialog.html',
} )

export class AdmissionEnrollmentDialog implements OnInit {

    private ADMISSION: string[] = 'termModuleState.admission'.split('.');
    private ENROLLMENTS: string[] = 'termModuleState.admissionEnrollments'.split('.');
    private admission$: Observable<Admission>;
    private enrollments$: Observable<Enrollment[]>;
    private creatorForm: FormGroup;
    private create: boolean = false;
    private _admission: Admission;
    private session: AcademicSession;
    private cohort: Cohort;
    private student: Student;
    private studyCenter: StudyCenter;

    @Input() admission: Admission;

    constructor( private formBuilder: FormBuilder,
        private store: Store<TermModuleState>,
        private actions: AdmissionActions,
        private dialog: MdDialogRef<AdmissionEnrollmentDialog>,
        private router: Router,
        private route: ActivatedRoute,
        private vcf: ViewContainerRef ) {

        this.admission$ = this.store.select(...this.ADMISSION);
        this.enrollments$ = this.store.select(...this.ENROLLMENTS);
    }

    ngOnInit(): void {
        this.route.params.subscribe((params: { id: number }) => {
          let id: number = params.id;
          this.store.dispatch(this.actions.findAdmissionById(id));
        });
      }

}
