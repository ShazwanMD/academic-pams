import { ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output, ViewContainerRef, SimpleChange, AfterViewInit, OnChanges } from '@angular/core';
import { EnrollmentApplicationItem } from '../../../../shared/model/term/enrollment-application-item.interface';
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { SectionActions } from '../../sections/section.action';
import { Store } from '@ngrx/store';
import { TermModuleState } from '../../index';
import { SectionEditorDialog } from '../../sections/dialog/section-editor.dialog';
import { EnrollmentApplication } from '../../../../shared/model/term/enrollment-application.interface';
import { TdDataTableSortingOrder, IPageChangeEvent, ITdDataTableSortChangeEvent, TdDataTableService } from "@covalent/core";
import { FormBuilder } from "@angular/forms";
import { ConfirmationDialog } from "../../sections/dialog/confirmation.dialog";
import { EnrollmentApplicationActions } from "../enrollment-application.action";

@Component( {
    selector: 'pams-enrollment-application-items',
    templateUrl: './enrollment-application-items.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class EnrollmentApplicationItemsComponent implements AfterViewInit, OnChanges {
    
    @Input() enrollmentApplication: EnrollmentApplication;
    @Input() enrollmentApplicationItems: EnrollmentApplicationItem[];
    //@Output() view: EventEmitter<EnrollmentApplicationItem> = new EventEmitter<EnrollmentApplicationItem>();

    private selectedRows: EnrollmentApplicationItem[];
    private creatorDialogRef: MdDialogRef<SectionEditorDialog>;
    private creatorDialogRef2: MdDialogRef<ConfirmationDialog>;
    private columns: any[] = [
        { name: 'id', label: 'Id' },
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

    
    constructor( private _dataTableService: TdDataTableService,
        private router: Router,
        private route: ActivatedRoute,
        private actions: EnrollmentApplicationActions,
        private store: Store<TermModuleState>,
        private formBuilder: FormBuilder,
        private vcf: ViewContainerRef,
        private snackBar: MdSnackBar,
        private dialog: MdDialog ) {
    }

    ngOnChanges( changes: { [propName: string]: SimpleChange } ) {
        console.log( "changes", changes, changes['enrollmentApplicationItems'] );
        if ( changes['enrollmentApplicationItems'] ) {
            this.filteredData = changes['enrollmentApplicationItems'].currentValue;
            this.filteredTotal = changes['enrollmentApplicationItems'].currentValue.length;
            this.filter();
        }
    }

    ngOnInit(): void {
        this.selectedRows = this.enrollmentApplicationItems.filter(( value ) => value.selected );
    }

    ngAfterViewInit(): void {
        this.filteredData = this.enrollmentApplicationItems;
        this.filteredTotal = this.enrollmentApplicationItems.length;
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
        let newData: any[] = this.enrollmentApplicationItems;
        newData = this._dataTableService.filterData( newData, this.searchTerm, true );
        this.filteredTotal = newData.length;
        newData = this._dataTableService.sortData( newData, this.sortBy, this.sortOrder );
        newData = this._dataTableService.pageData( newData, this.fromRow, this.currentPage * this.pageSize );
        this.filteredData = newData;
    }

    selectRow( enrollmentApplicationItem: EnrollmentApplicationItem ): void {
    }

    selectAllRows( enrollmentApplicationItems: EnrollmentApplicationItem[] ): void {
    }



    addSectionDialog(): void {
        console.log( 'showDialog' );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '50%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open( SectionEditorDialog, config );
        // this.creatorDialogRef.componentInstance.offering = this.offering;
        this.creatorDialogRef.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog' );
            // load something here
        } );
    }


    goBack( route: string ): void {
        this.router.navigate( ['/offerings'] );
    }
}

