import { ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output, ViewContainerRef, SimpleChange, AfterViewInit, OnChanges } from '@angular/core';
import { Graduation } from '../../../../shared/model/graduation/graduation.interface';
import { AcademicSession } from '../../../../shared/model/planner/academic-session.interface';
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { GraduationModuleState } from '../../../graduation/index';
import { TdDataTableSortingOrder, IPageChangeEvent, ITdDataTableSortChangeEvent, TdDataTableService } from "@covalent/core";
import { FormBuilder } from "@angular/forms";

@Component( {
    selector: 'pams-academic-session-graduation-list',
    templateUrl: './academic-session-graduation-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class AcademicSessionGraduationListComponent implements AfterViewInit, OnChanges {

    private selectedRows: Graduation[];
   
    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'student.name', label: 'Name' },
        { name: 'student.identityNo', label: 'Matric No.' },
        { name: 'cgpa', label: 'CGPA' },
        { name: 'creditHour', label: 'Credit Hour' },
        { name: 'referenceNo', label: 'Reference No' },
       
        { name: 'action', label: '' },
    ];

    filteredData: any[];
    filteredTotal: number;
    searchTerm: string = '';
    fromRow: number = 1;
    currentPage: number = 1;
    pageSize: number = 5;
    sortBy: string = 'id';
    sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

    @Input() academicSession: AcademicSession;
    @Input() graduations: Graduation[];
    @Output() view: EventEmitter<Graduation> = new EventEmitter<Graduation>();

    constructor( private _dataTableService: TdDataTableService,
        private router: Router,
        private route: ActivatedRoute,
        private store: Store<GraduationModuleState>,
        private formBuilder: FormBuilder,
        private vcf: ViewContainerRef,
        private snackBar: MdSnackBar,
        private dialog: MdDialog ) {
    }

    ngOnChanges( changes: { [propName: string]: SimpleChange } ) {
        console.log( "changes", changes, changes['graduations'] );
        if ( changes['graduations'] ) {
            this.filteredData = changes['graduations'].currentValue;
            this.filteredTotal = changes['graduations'].currentValue.length;
            this.filter();
        }
    }

    ngOnInit(): void {
        this.selectedRows = this.graduations.filter(( value ) => value.selected );
    }

    ngAfterViewInit(): void {
        this.filteredData = this.graduations;
        this.filteredTotal = this.graduations.length;
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
        let newData: any[] = this.graduations;
        newData = this._dataTableService.filterData( newData, this.searchTerm, true );
        this.filteredTotal = newData.length;
        newData = this._dataTableService.sortData( newData, this.sortBy, this.sortOrder );
        newData = this._dataTableService.pageData( newData, this.fromRow, this.currentPage * this.pageSize );
        this.filteredData = newData;
    }

    selectRow( graduation: Graduation ): void {
    }

    selectAllRows( graduations: Graduation[] ): void {
    }

    goBack( route: string ): void {
        this.router.navigate( ['/graduations'] );
    }
}

