import { TdDataTableSortingOrder, ITdDataTableSortChangeEvent, IPageChangeEvent, TdDataTableService } from '@covalent/core';
import { StudentDetailEditorDialog } from './../dialog/student-detail-editor.dialog';
import { Router, ActivatedRoute } from '@angular/router';
import { Student } from './../../../shared/model/identity/student.interface';
import { ChangeDetectionStrategy, Component, Input, ViewContainerRef, EventEmitter, Output, OnInit, SimpleChange } from '@angular/core';
import { Enrollment } from '../../../shared/model/term/enrollment.interface';
import { StudentProfileActions } from "../student-profile.action";
import { StudentProfileModuleState } from "../index";
import { Store } from "@ngrx/store";
import { FormBuilder } from "@angular/forms";
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from "@angular/material";
import { AcademicSession } from "../../../shared/model/planner/academic-session.interface";
import { Admission } from "../../../shared/model/term/admission.interface";

@Component({
    selector: 'pams-student-profile-academicSession-list',
    templateUrl: 'student-profile-academicSession-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentProfileAcademicSessionComponent implements OnInit {
    [x: string]: any;

    @Input() academicSessions: AcademicSession[];
    @Input() admissions: Admission[];
    @Output() view = new EventEmitter<Admission>();
    @Input() student: Student;

    filteredData: any[];
    filteredTotal: number;
    searchTerm: string = '';
    fromRow: number = 1;
    currentPage: number = 1;
    pageSize: number = 5;
    sortBy: string = 'academicSession.semester';
    sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Ascending;


    private columns: any[] = [
        { name: 'academicSession.code', label: 'SESSION CODE' },
        { name: 'academicSession.semester', label: 'ACADEMIC SEMESTER' },
        { name: 'academicSession.year.year', label: 'YEAR' },
        { name: 'gpa', label: 'GPA', numeric: true, format: (v) => v.toFixed(2), filter: true },
        { name: 'cgpa', label: 'CGPA', numeric: true, format: (v) => v.toFixed(2), filter: true },
        { name: 'action', label: '' },
    ];

    constructor(private _dataTableService: TdDataTableService,
        private snackBar: MdSnackBar) {
    }

    ngOnInit(): void {
        console.log("find Student Profile Detail");

    }
    ngOnChanges(changes: { [propName: string]: SimpleChange }) {
        console.log('changes', changes, changes['admissions']);
        if (changes['admissions']) {
            this.filteredData = changes['admissions'].currentValue;
            this.filteredTotal = changes['admissions'].currentValue.length;
            this.filter();
        }
    }

    ngAfterViewInit(): void {
        this.filteredData = this.admissions;
        this.filteredTotal = this.admissions.length;
        this.filter();
    }

    sort(sortEvent: ITdDataTableSortChangeEvent): void {
        this.sortBy = sortEvent.name;
        this.sortOrder = sortEvent.order;
        this.filter();
    }

    search(searchTerm: string): void {
        this.searchTerm = searchTerm;

        this.filter();
    }

    page(pagingEvent: IPageChangeEvent): void {
        this.fromRow = pagingEvent.fromRow;
        this.currentPage = pagingEvent.page;
        this.pageSize = pagingEvent.pageSize;
        this.filter();
    }

    filter(): void {
        let newData: any[] = this.admissions;
        newData = this._dataTableService.filterData(newData, this.searchTerm, true);
        this.filteredTotal = newData.length;
        newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
        newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
        this.filteredData = newData;
    }

}
