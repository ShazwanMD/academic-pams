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
import { AcademicYear } from '../../../../shared/model/planner/academic-year.interface';
import {
    IPageChangeEvent,
    ITdDataTableSortChangeEvent,
    TdDataTableService,
    TdDataTableSortingOrder
} from '@covalent/core';
import { MdSnackBar, MdDialogConfig, MdDialogRef, MdDialog } from '@angular/material';
import { AcademicYearCreatorDialog } from "../dialog/academic-year-creator.dialog";
import { Store } from '@ngrx/store';
import { PlannerModuleState } from "../../index";
import { AcademicYearActions } from "../academic-year.action";

@Component( {
    selector: 'pams-academic-year-list',
    templateUrl: './academic-year-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )

export class AcademicYearListComponent implements AfterViewInit, OnChanges {

    private creatorDialogRef: MdDialogRef<AcademicYearCreatorDialog>;

    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'code', label: 'Code' },
        { name: 'description', label: 'Description' },
        { name: 'year', label: 'Year' },

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

    @Input() academicYears: AcademicYear[];
    @Output() view = new EventEmitter<AcademicYear>();

    constructor( 
            private store: Store<PlannerModuleState>,
            private actions: AcademicYearActions,
            private _dataTableService: TdDataTableService,
            private vcf: ViewContainerRef,
            private dialog: MdDialog,
            private snackBar: MdSnackBar ) {
    }

    viewAcademicYear( academicYear: AcademicYear ): void {
        console.log( 'Emitting academicYears' );
        let snackBarRef = this.snackBar.open( 'Viewing academicYear info', 'OK' );
        snackBarRef.afterDismissed().subscribe(() => {
            this.view.emit( academicYear );
        } );

    }

    ngOnChanges( changes: { [propName: string]: SimpleChange } ) {
        console.log( 'changes', changes, changes['academicYears'] );
        if ( changes['academicYears'] ) {
            this.filteredData = changes['academicYears'].currentValue;
            this.filteredTotal = changes['academicYears'].currentValue.length;
            this.filter();
        }
    }

    ngAfterViewInit(): void {
        this.filteredData = this.academicYears;
        this.filteredTotal = this.academicYears.length;
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
        let newData: any[] = this.academicYears;
        newData = this._dataTableService.filterData( newData, this.searchTerm, true );
        this.filteredTotal = newData.length;
        newData = this._dataTableService.sortData( newData, this.sortBy, this.sortOrder );
        newData = this._dataTableService.pageData( newData, this.fromRow, this.currentPage * this.pageSize );
        this.filteredData = newData;
    }
    
    editDialog( academicYear: AcademicYear, isValid: boolean ): void {
        console.log( 'academicYear:{}', academicYear );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '60%';
        config.height = '50%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open( AcademicYearCreatorDialog, config );
        if ( isValid ) {
            this.creatorDialogRef.componentInstance.academicYear = academicYear;
            
        }
        this.creatorDialogRef.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog academicYear' );
            // load something here
        } );
    }
    
    //remove academic year
    delete( academicYear: AcademicYear ): void {
        
        if (confirm("Are you sure to delete this academic year?") == true) {
            this.store.dispatch( this.actions.removeAcademicYear( academicYear ) )
              let snackBarRef = this.snackBar.open( 'Academic Year: ' + academicYear.code + ' has been deleted', '', { duration: 3000 } );
              snackBarRef.afterDismissed().subscribe(() => {
              } );
          } else {
              let snackBarRef = this.snackBar.open( 'Academic Year: ' + academicYear.code + ' has been cancel deleted', '', { duration: 3000 } );
              snackBarRef.afterDismissed().subscribe(() => {
              } );
          }   
       
    }

}
