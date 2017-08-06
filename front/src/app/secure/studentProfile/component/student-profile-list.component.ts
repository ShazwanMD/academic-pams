import { Observable } from 'rxjs/Observable';
import { MdDialog } from '@angular/material';
import { FormBuilder } from '@angular/forms';
import { StudentProfileModuleState } from './../index';
import { Store } from '@ngrx/store';
import { StudentProfileActions } from './../student-profile.action';
import { Component, OnInit, ViewContainerRef, Input, ChangeDetectionStrategy } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { Student } from "../../../shared/model/identity/student.interface";


@Component({
    selector: 'pams-student-profile-list',
    templateUrl: 'student-profile-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentProfileListPage implements OnInit {
    //inputs
    @Input() student: Student;

    private STUDENT: string[] = 'studentprofileModuleState.student'.split('.');
    private student$: Observable<Student>;

    //Constructor
    constructor(private router: Router,
        private route: ActivatedRoute,
        private actions: StudentProfileActions,
        private vcf: ViewContainerRef,
        private store: Store<StudentProfileModuleState>,
        private formBuilder: FormBuilder,
        private dialog: MdDialog) {
    }


    ngOnInit(): void {
        this.route.params.subscribe((params: { identityNo: string }) => {
            let identityNo: string = params.identityNo;
            this.store.dispatch(this.actions.findStudentByIdentityNo(identityNo));
        });

    }

    goBack(route: string): void {
        this.router.navigate(['/studentProfile']);
    }
}