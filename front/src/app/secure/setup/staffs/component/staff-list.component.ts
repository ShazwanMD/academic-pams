import { Staff } from './../../../../shared/model/identity/staff.interface';
import {
    AfterViewInit,
    ChangeDetectionStrategy,
    Component,
    EventEmitter,
    Input,
    OnChanges,
    Output,
    SimpleChange,
    ViewContainerRef
} from '@angular/core';

import {
    IPageChangeEvent,
    ITdDataTableSortChangeEvent,
    TdDataTableService,
    TdDataTableSortingOrder
} from '@covalent/core';
import { MdSnackBar, MdDialog, MdDialogRef, MdDialogConfig } from '@angular/material';
import { StaffActions } from '../../../identity/staffs/staff.action';
import { SetupActions } from '../../setup.action';
import { Router, ActivatedRoute } from '@angular/router';
import { StaffAcademicEditorDialog } from '../dialog/staff-academic-editor.dialog';

@Component( {
    selector: 'pams-staff-academic-list',
    templateUrl: './staff-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )

export class StaffAcademicListComponent implements AfterViewInit, OnChanges {

    private columns: any[] = [
        { name: 'identityNo', label: 'IdentityNo' },
        { name: 'name', label: 'Name' },
        { name: 'email', label: 'Email' },
        { name: 'action', label: '' },

    ];

    filteredData: any[];
    filteredTotal: number;
    searchTerm: string = '';
    fromRow: number = 1;
    currentPage: number = 1;
    pageSize: number = 5;
    sortBy: string = 'name';
    sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

    @Input() staffs: Staff[];
    @Output() view: EventEmitter<Staff> = new EventEmitter<Staff>();

    private creatorDialogRef: MdDialogRef<StaffAcademicEditorDialog>;

    constructor( private _dataTableService: TdDataTableService,
        private snackBar: MdSnackBar,
        private actions: StaffActions,
        private setupactions: SetupActions,
        private vcf: ViewContainerRef,
        private router: Router,
        private route: ActivatedRoute,
        private dialog : MdDialog
    ) {
    }

    ngOnChanges( changes: { [propName: string]: SimpleChange } ) {
        console.log( "changes", changes, changes['staffs'] );
        if ( changes['staffs'] ) {
            this.filteredData = changes['staffs'].currentValue;
            this.filteredTotal = changes['staffs'].currentValue.length;
            this.filter();
        }
    }

    ngAfterViewInit(): void {
        this.filteredData = this.staffs;
        this.filteredTotal = this.staffs.length;
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
        let newData: any[] = this.staffs;
        newData = this._dataTableService.filterData( newData, this.searchTerm, true );
        this.filteredTotal = newData.length;
        newData = this._dataTableService.sortData( newData, this.sortBy, this.sortOrder );
        newData = this._dataTableService.pageData( newData, this.fromRow, this.currentPage * this.pageSize );
        this.filteredData = newData;
    }

    viewStaff( staff: Staff ): void {
        console.log( 'Emitting staffs' );
        let snackBarRef = this.snackBar.open( 'Viewing staffs info', 'OK' );
        snackBarRef.afterDismissed().subscribe(() => {
            this.view.emit( staff );
        } );

    }

    editDialog( staff: Staff ): void {
        this.showDialog( staff );
    }

    private showDialog( staff: Staff ): void {
        console.log( "create" );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '65%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open( StaffAcademicEditorDialog, config );
        if ( staff ) this.creatorDialogRef.componentInstance.staff = staff; // set
        this.creatorDialogRef.afterClosed().subscribe( res => {
            console.log( "close dialog" );
        } );
    }

}
