import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit } from '@angular/core';
import { Enrollment } from '../../enrollments/enrollment.interface';
import { MdDialog, MdDialogConfig, MdDialogRef } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { EnrollmentActions } from '../../enrollments/enrollment.action';
import { Store } from '@ngrx/store';
import { TermModuleState } from '../../index';
import { Admission } from '../admission.interface';
import { AdmissionEnrollmentDialog } from "../dialog/admission-enrollment.dialog";

@Component( {
    selector: 'pams-admission-enrollment-list',
    templateUrl: './admission-enrollment-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class AdmissionEnrollmentListComponent implements OnInit {

    private columns: any[] = [
        { name: 'section.id', label: 'Section' },
        { name: 'section.offering.academicSession.code', label: 'Session' },
        { name: 'section.code', label: 'Code' },
        { name: 'section.offering.titleEn', label: 'Title' },
        { name: 'section.offering.program.code', label: 'Program' },
        { name: 'section.offering.course.faculty.name', label: 'Faculty' },
        { name: 'enrollmentStatus', label: 'Status' },
        { name: 'action', label: '' },
    ];

    @Input() enrollment: Enrollment;
    @Input() admission: Admission;
    @Input() enrollments: Enrollment[];
    @Output() view: EventEmitter<Enrollment> = new EventEmitter<Enrollment>();

    private selectedRows: Enrollment[];
    private creatorDialogRef: MdDialogRef<AdmissionEnrollmentDialog>;
    constructor( private router: Router,
        private route: ActivatedRoute,
        private actions: EnrollmentActions,
        private store: Store<TermModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog ) {
    }

    ngOnInit(): void {
        this.selectedRows = this.enrollments.filter(value => value.selected);
    }

    filter(): void {
    }

    selectRow( enrollment: Enrollment ): void {
    }

    selectAllRows( enrollments: Enrollment[] ): void {
    }
    
    showDialog(): void {
        console.log("showDialog details");
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '90%';
        config.height = '90%';
        config.position = {top: '0px'};
        this.creatorDialogRef = this.dialog.open(AdmissionEnrollmentDialog, config);
        
        this.creatorDialogRef.afterClosed().subscribe(res => {
          console.log("close dialog");
          // load something here
        });
      }
}

