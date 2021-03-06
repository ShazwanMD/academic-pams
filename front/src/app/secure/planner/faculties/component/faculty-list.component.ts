import {
    AfterViewInit,
    ChangeDetectionStrategy,
    Component,
    EventEmitter,
    Input,
    OnChanges,
    Output,
    SimpleChange
} from '@angular/core';
import { Faculty } from '../../../../shared/model/planner/faculty.interface';
import {
    IPageChangeEvent,
    ITdDataTableSortChangeEvent,
    TdDataTableService,
    TdDataTableSortingOrder
} from '@covalent/core';
import { MdSnackBar } from '@angular/material';

@Component( {
    selector: 'pams-faculty-list',
    templateUrl: './faculty-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )

export class FacultyListComponent implements AfterViewInit, OnChanges {

    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'code', label: 'Code' },
        { name: 'name', label: 'Name' },
        { name: 'description', label: 'Description' },
        { name: 'status', label: 'Status' },
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

    @Input() faculties: Faculty[];
    @Output() view: EventEmitter<Faculty> = new EventEmitter<Faculty>();

    constructor( private _dataTableService: TdDataTableService,
        private snackBar: MdSnackBar ) {
    }

    ngOnChanges( changes: { [propName: string]: SimpleChange } ) {
        console.log( "changes", changes, changes['faculties'] );
        if ( changes['faculties'] ) {
            this.filteredData = changes['faculties'].currentValue;
            this.filteredTotal = changes['faculties'].currentValue.length;
            this.filter();
        }
    }

    ngAfterViewInit(): void {
        this.filteredData = this.faculties;
        this.filteredTotal = this.faculties.length;
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
        let newData: any[] = this.faculties;
        newData = this._dataTableService.filterData( newData, this.searchTerm, true );
        this.filteredTotal = newData.length;
        newData = this._dataTableService.sortData( newData, this.sortBy, this.sortOrder );
        newData = this._dataTableService.pageData( newData, this.fromRow, this.currentPage * this.pageSize );
        this.filteredData = newData;
    }

    viewFaculty( faculty: Faculty ): void {
        console.log( 'Emitting faculties' );
        let snackBarRef = this.snackBar.open( 'Viewing faculty info', 'OK' );
        snackBarRef.afterDismissed().subscribe(() => {
            this.view.emit( faculty );
        } );

    }

}
