import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit } from '@angular/core';
import { EnrollmentApplication } from '../../enrollment-applications/enrollment-application.interface';
import { MdDialog, MdDialogConfig, MdDialogRef } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { EnrollmentApplicationActions } from '../../enrollment-applications/enrollment-application.action';
import { Store } from '@ngrx/store';
import { TermModuleState } from '../../index';
import { Admission } from '../admission.interface';
import { AdmissionEnrollmentDialog } from "../dialog/admission-enrollment.dialog";

@Component( {
    selector: 'pams-admission-enrollmentApplication-list',
    templateUrl: './admission-enrollmentApplication-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class AdmissionEnrollmentApplicationListComponent implements OnInit {

    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'action', label: '' },
    ];

    @Input() enrollmentApplication: EnrollmentApplication;
    @Input() admission: Admission;
    @Input() enrollmentApplications: EnrollmentApplication[];
    @Output() view: EventEmitter<EnrollmentApplication> = new EventEmitter<EnrollmentApplication>();

    private selectedRows: EnrollmentApplication[];
    private creatorDialogRef: MdDialogRef<AdmissionEnrollmentDialog>;
    constructor( private router: Router,
        private route: ActivatedRoute,
        private actions: EnrollmentApplicationActions,
        private store: Store<TermModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog ) {
    }

    ngOnInit(): void {
        //this.selectedRows = this.enrollmentApplications.filter(value => value.selected);
    }

    filter(): void {
    }

    selectRow( enrollmentApplication: EnrollmentApplication ): void {
    }

    selectAllRows( enrollmentApplications: EnrollmentApplication[] ): void {
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

