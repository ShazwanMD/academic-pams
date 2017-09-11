/*import {
    AfterViewInit,
    ChangeDetectionStrategy,
    Component,
    EventEmitter,
    Input,
    Output,
    ViewContainerRef,
    OnChanges,
SimpleChange
} from '@angular/core';
import { Section } from '../../../../shared/model/term/section.interface';
import { Store } from '@ngrx/store';
import { ActivatedRoute, Router } from '@angular/router';
import { MdDialog, MdDialogRef } from '@angular/material';
import { TermModuleState } from '../../index';
import { EnrollmentEditorDialog } from '../../enrollments/dialog/enrollment-editor.dialog';
import { Gradebook } from '../../../../shared/model/term/gradebook.interface';
import { GradebookActions } from '../../gradebooks/gradebook.action';
import {
    IPageChangeEvent,
    ITdDataTableSortChangeEvent,
    TdDataTableService,
    TdDataTableSortingOrder
} from '@covalent/core';
import { GradebookMatrix } from "../../../../shared/model/term/gradebook-matrix.interface";

@Component( {
    selector: 'pams-section-gradebook-list',
    templateUrl: './section-gradebook-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class SectionGradebookListComponent implements AfterViewInit, OnChanges {

    private creatorDialogRef: MdDialogRef<EnrollmentEditorDialog>;
    private selectedRows: Gradebook[];
    
    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'enrollment.admission.student.name', label: 'Name' },
        { name: 'enrollment.admission.student.identityNo', label: 'Identity No' },
        { name: 'assessment.description', label: 'Assessment' },
        { name: 'assessment.weight', label: 'weight(%)' },
        { name: 'assessment.assessmentCategory', label: 'assessmentCategory' },
        { name: 'score', label: 'Score' },
        { name: 'enrollment.gradeCode.code', label: 'Grade' },

        { name: 'action', label: '' },
    ];

    private columns: any[] = [
        { label: 'Student name', name: 'enrollment.admission.student.name' },
        { label: 'Student matric', name: 'enrollment.admission.student.identityNo' },
        //{ label: 'assessmentCategory', name: 'assessment.assessmentCategory' },
        //{ label: 'Score', name: 'score' },
        //{ label: 'Grade', name: 'enrollment.gradeCode.code' },
    ];
    

    filteredData: any[];
    filteredTotal: number;
    searchTerm: string = '';
    fromRow: number = 1;
    currentPage: number = 1;
    pageSize: number = 5;
    sortBy: string = 'enrollment.admission.student.name';
    sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

    @Input() section: Section;
    @Input() gradebook: Gradebook;
    @Input() gradebooks: Gradebook[];
    @Input() gradebookMatrices: GradebookMatrix[];
    @Output() view = new EventEmitter<Gradebook>();

    constructor( private _dataTableService: TdDataTableService,
        private router: Router,
        private route: ActivatedRoute,
        private actions: GradebookActions,
        private store: Store<TermModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog ) {
    }
    
    ngOnChanges(changes: { [propName: string]: SimpleChange }) {
        if (changes['gradebookMatrices'] && this.gradebookMatrices) {
          let a = changes['gradebookMatrices']['currentValue'];
          if (a.length > 0) {
            a.forEach((i) => {
              let b = i['gradebooks'];
              if (b.length > 0) {
                for (let j = 0; j < b.length; j++) {
                  this.columns[j + 1] = {
                    label: b[j].assessment.description,
                    name: 'gradebooks.' + j + '.score',
                  };
                }
                console.log(this.columns);
              }
              console.log(i['gradebooks']);
            });

          }
        }
      }
    

    ngAfterViewInit(): void {
        this.filteredData = this.gradebooks;
        this.filteredTotal = this.gradebooks.length;
        this.filter();
    }

    sort( sortEvent: ITdDataTableSortChangeEvent ): void {
        this.sortBy = sortEvent.name;
        this.sortOrder = sortEvent.order;
        this.filter();
    }

    search( searchTerm: string ): void {
        this.searchTerm = searchTerm;
        this.filter();
    }

    page( pagingEvent: IPageChangeEvent ): void {
        this.fromRow = pagingEvent.fromRow;
        this.currentPage = pagingEvent.page;
        this.pageSize = pagingEvent.pageSize;
        this.filter();
    }

    filter(): void {
        let newData: any[] = this.gradebooks;
        newData = this._dataTableService.filterData( newData, this.searchTerm, true );
        this.filteredTotal = newData.length;
        newData = this._dataTableService.sortData( newData, this.sortBy, this.sortOrder );
        newData = this._dataTableService.pageData( newData, this.fromRow, this.currentPage * this.pageSize );
        this.filteredData = newData;
    }

    selectRow( gradebook: Gradebook ): void {
    }

    selectAllRows( gradebooks: Gradebook[] ): void {
    }
}
*/

import { ChangeDetectionStrategy, Component, Input, OnChanges, SimpleChange, ViewChild } from '@angular/core';
import { SectionActions } from '../section.action';
import { Store } from '@ngrx/store';
import { TermModuleState } from '../../index';
import { GradebookMatrix } from '../../../../shared/model/term/gradebook-matrix.interface';
import { TdDataTableComponent } from '@covalent/core';
import { Assessment } from '../../../../shared/model/term/assessment.interface';
import { Section } from '../../../../shared/model/term/section.interface';

@Component( {
    selector: 'pams-section-gradebook-list',
    templateUrl: './section-gradebook-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class SectionGradebookListComponent implements OnChanges {

    @Input() section: Section;
    @Input() gradebookMatrices: GradebookMatrix[];
    @Input() assessments: Assessment[];
    @ViewChild( 'dataTable' ) dataTable: TdDataTableComponent;

    columns: any[] = [
        { label: 'Student name', name: 'enrollment.admission.student.name' },
    ];

    constructor( private actions: SectionActions,
        private store: Store<TermModuleState> ) {
    }

    ngOnChanges( changes: { [propName: string]: SimpleChange } ) {
        if ( changes['gradebookMatrices'] && this.gradebookMatrices ) {
            let a = changes['gradebookMatrices']['currentValue'];
            if ( a.length > 0 ) {
                a.forEach(( i ) => {
                    let b = i['gradebooks'];
                    if ( b.length > 0 ) {
                        for ( let j = 0; j < b.length; j++ ) {
                            this.columns[j + 1] = {
                                label: b[j].assessment.description,
                                name: 'gradebooks.' + j + '.score',
                            };
                        }
                        console.log( this.columns );
                    }
                    console.log( i['gradebooks'] );
                } );

            }
        }
    }

}
