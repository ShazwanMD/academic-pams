import { EnrollmentActions } from '../../enrollments/enrollment.action';
import { SectionActions } from '../section.action';
import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit } from '@angular/core';
import { Enrollment } from "../../enrollments/enrollment.interface";
import { Section } from "../section.interface";
import { Store } from "@ngrx/store";
import { ActivatedRoute, Router } from "@angular/router";
import { MdDialog, MdDialogConfig, MdDialogRef } from "@angular/material";
import { TermModuleState } from "../../index";
import { EnrollmentEditorDialog } from "../../enrollments/dialog/enrollment-editor.dialog";
import {Gradebook} from "../../gradebooks/gradebook.interface";


@Component({
    selector: 'pams-section-gradebook-list',
    templateUrl: './section-gradebook-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SectionGradebookListComponent implements OnInit {

    @Input() section: Section;
    @Input() gradebook: Gradebook;
    @Input() gradebooks: Gradebook[];
    @Output() view = new EventEmitter<Gradebook>();

    private creatorDialogRef: MdDialogRef<EnrollmentEditorDialog>;
    private selectedRows: Gradebook[];

    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'admission.student.name', label: 'Student' },
        { name: 'admission.student.email', label: 'Email' },
        { name: 'enrollmentStatus', label: 'Status' },
        { name: 'enrollmentStanding', label: 'Standing' },
        { name: 'totalScore', label: 'TotalScore' },      
        { name: 'gradeCode.code', label: 'Grade Code' },       
        { name: 'action', label: '' }
    ];

    constructor(private router: Router,
        private route: ActivatedRoute,
        private actions: EnrollmentActions,
        private store: Store<TermModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog) {
    }

    ngOnInit(): void {
        // this.selectedRows = this.appointments.filter(value => value.selected);
    }

    filter(): void {
    }

    selectRow(enrollment: Enrollment): void {
    }

    selectAllRows(enrollments: Enrollment[]): void {
    }

    //edit dialog
    editDialog(enrollment: Enrollment, isValid: boolean): void {
        console.log("showDialogEnrollment");
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '50%';
        config.height = '50%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open(EnrollmentEditorDialog, config);
        if (isValid) {
            this.creatorDialogRef.componentInstance.enrollment = enrollment;
            this.creatorDialogRef.componentInstance.section = this.section;

        }
        this.creatorDialogRef.afterClosed().subscribe(res => {
            console.log("close dialog");
            // load something here
        });
    }

}