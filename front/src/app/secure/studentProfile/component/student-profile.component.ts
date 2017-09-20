import { ProfileActions } from './../../profile/profile.action';
import { Observable } from 'rxjs/Observable';
import { MdDialog } from '@angular/material';
import { FormBuilder } from '@angular/forms';
import { StudentProfileModuleState } from './../index';
import { Store } from '@ngrx/store';
import { StudentProfileActions } from './../student-profile.action';
import { Component, OnInit, ViewContainerRef, Input, ChangeDetectionStrategy } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { Student } from "../../../shared/model/identity/student.interface";
import { Address } from "../../../shared/model/profile/address.interface";


@Component({
    selector: 'pams-student-profile',
    templateUrl: 'student-profile.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentProfilePage {
    //inputs
    @Input() student: Student;
    @Input() addressess: Address[];


    //Address
    private address: any[] = [
        { name: 'addressType', label: 'Address Type' },
        { name: 'address1', label: 'Address 1' },
        { name: 'address2', label: 'Address 2' },
        { name: 'address3', label: 'City' },
        { name: 'postcode', label: 'Postcode' },
        { name: 'stateCode.descriptionEn', label: 'State' },
        { name: 'countryCode.descriptionEn', label: 'Country' },
        { name: 'action', label: 'Action' },
    ];

    //Constructor
    constructor(private router: Router,
        private route: ActivatedRoute,
        private actions: StudentProfileActions,
        private profileActions: ProfileActions,
        private vcf: ViewContainerRef,
        private store: Store<StudentProfileModuleState>,
        private formBuilder: FormBuilder,
        private dialog: MdDialog) {
    }

    goBack(route: string): void {
        this.router.navigate(['/studentProfile']);
    }

}