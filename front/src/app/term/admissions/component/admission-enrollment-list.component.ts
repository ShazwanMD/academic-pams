import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit } from '@angular/core';
import { Enrollment } from '../../enrollments/enrollment.interface';
import { MdDialog } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { EnrollmentActions } from '../../enrollments/enrollment.action';
import { Store } from '@ngrx/store';
import { TermModuleState } from '../../index';
import { Admission } from '../admission.interface';

@Component( {
    selector: 'pams-admission-enrollment-list',
    templateUrl: './admission-enrollment-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class AdmissionEnrollmentListComponent implements OnInit {

    private columns: any[] = [
        { name: 'section.id', label: 'Section No.' },
        { name: 'section.code', label: 'Code Section' },
        { name: 'section.offering.titleEn', label: 'Course Title' },
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
}

