import { ChangeDetectionStrategy, Component, Input, OnChanges, SimpleChange, ViewChild, AfterViewInit } from '@angular/core';
import { SectionActions } from '../section.action';
import { Store } from '@ngrx/store';
import { TermModuleState } from '../../index';
import { GradebookMatrix } from '../../../../shared/model/term/gradebook-matrix.interface';
import { TdDataTableComponent, TdDataTableSortingOrder, TdDataTableService, ITdDataTableSortChangeEvent, IPageChangeEvent } from '@covalent/core';
import { Assessment } from '../../../../shared/model/term/assessment.interface';
import { Gradebook } from '../../../../shared/model/term/gradebook.interface';
import { Section } from '../../../../shared/model/term/section.interface';

@Component( {
    selector: 'pams-section-gradebook-list',
    templateUrl: './section-gradebook-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class SectionGradebookListComponent implements AfterViewInit, OnChanges {

    @Input() section: Section;
    @Input() gradebooks: Gradebook[];
    @Input() gradebookMatrices: GradebookMatrix[];
    @Input() assessments: Assessment[];
    @ViewChild( 'dataTable' ) dataTable: TdDataTableComponent;

    private selectedRows: GradebookMatrix[];

    columns: any[] = [
        { label: 'Student name', name: 'enrollment.admission.student.name' },
        
    ];


    filteredData: any[];
    filteredTotal: number;
    searchTerm: string = '';
    fromRow: number = 1;
    currentPage: number = 1;
    pageSize: number = 5;
    sortBy: string = 'enrollment.admission.student.name';
    sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

    constructor(
        private _dataTableService: TdDataTableService,
        private actions: SectionActions,
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
    } //end of onChange

    ngOnInit(): void {
        this.selectedRows = this.gradebookMatrices.filter(( value ) => value.selected );
    }

    ngAfterViewInit(): void {
        this.filteredData = this.gradebookMatrices;
        this.filteredTotal = this.gradebookMatrices.length;
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
        let newData: any[] = this.gradebookMatrices;
        newData = this._dataTableService.filterData( newData, this.searchTerm, true );
        this.filteredTotal = newData.length;
        newData = this._dataTableService.sortData( newData, this.sortBy, this.sortOrder );
        newData = this._dataTableService.pageData( newData, this.fromRow, this.currentPage * this.pageSize );
        this.filteredData = newData;
    }

    selectRow( gradebook: Gradebook ): void {
    }

    selectAllRows( gradebookMatrices: GradebookMatrix[] ): void {
    }


}
