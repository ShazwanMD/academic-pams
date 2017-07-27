import { MdSnackBar } from '@angular/material/snack-bar';
import { IPageChangeEvent, ITdDataTableSortChangeEvent, TdDataTableService, TdDataTableSortingOrder } from '@covalent/core';
import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy } from '@angular/core';
import { Curriculum } from '../curriculum.interface';

@Component( {
    selector: 'pams-curriculum-list',
    templateUrl: './curriculum-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class CurriculumListComponent {

    @Input() curriculums: Curriculum[];
    @Output() view = new EventEmitter<Curriculum>();


    // todo: credithours, etc etc
    private columns: any[] = [
        { name: 'code', label: 'Code' },
        { name: 'coreCredit.number', label: 'Core Credit' },
        { name: 'totalCredit.number', label: 'Total Credit' },
        //{name:'maxPeriod.number', label:'Max Period'},
        // {name: 'curriculumCredit.number', label: 'Curriculum Credit'},
        //{name: 'electiveCredit.number', label: 'Elective Credit'},
        //{name: 'generalCredit', label: 'General Credit'},
        // {name: 'languageCredit', label: 'Language Credit'},
        // {name: 'otherCredit', label: 'Other Credit'},
        // {name: 'requiredCredit', label: 'Required Credit'},

        // {name: 'ordinal', label: 'Ordinal'},
        //{name: 'program.code', label: 'Program'},
        { name: 'action', label: '' },
    ];

    filteredData: any[];
    filteredTotal: number;
    searchTerm: string = '';
    fromRow: number = 1;
    currentPage: number = 1;
    pageSize: number = 5;
    sortBy: string = 'code';
    sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

    constructor( private _dataTableService: TdDataTableService,
        private snackBar: MdSnackBar ) { }

    ngAfterViewInit(): void {
        this.filteredData = this.curriculums;
        this.filteredTotal = this.curriculums.length;
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
        let newData: any[] = this.curriculums;
        newData = this._dataTableService.filterData( newData, this.searchTerm, true );
        this.filteredTotal = newData.length;
        newData = this._dataTableService.sortData( newData, this.sortBy, this.sortOrder );
        newData = this._dataTableService.pageData( newData, this.fromRow, this.currentPage * this.pageSize );
        this.filteredData = newData;

    }

    viewCurriculum( curriculum: Curriculum ): void {
        console.log( "Emitting curriculums" );
        let snackBarRef = this.snackBar.open( "Viewing curriculums info", "OK" );
        snackBarRef.afterDismissed().subscribe(() => {
            this.view.emit( curriculum );
        } );
    }
}
