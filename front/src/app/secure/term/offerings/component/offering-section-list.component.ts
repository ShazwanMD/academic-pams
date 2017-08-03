import { ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output, ViewContainerRef, SimpleChange, AfterViewInit, OnChanges } from '@angular/core';
import { Section } from '../../../../shared/model/term/section.interface';
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { SectionActions } from '../../sections/section.action';
import { Store } from '@ngrx/store';
import { TermModuleState } from '../../index';
import { SectionEditorDialog } from '../../sections/dialog/section-editor.dialog';
import { Offering } from '../../../../shared/model/term/offering.interface';
import { TdDataTableSortingOrder, IPageChangeEvent, ITdDataTableSortChangeEvent, TdDataTableService} from "@covalent/core";
import { FormBuilder } from "@angular/forms";

@Component( {
    selector: 'pams-offering-section-list',
    templateUrl: './offering-section-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class OfferingSectionListComponent implements AfterViewInit, OnChanges {
       

    @Input() section: Section;
    @Input() offering: Offering;
    @Input() sections: Section[];
    @Output() view = new EventEmitter<Section>();

    private selectedRows: Section[];
    private creatorDialogRef: MdDialogRef<SectionEditorDialog>;
    private columns: any[] = [
        { name: 'ordinal', label: 'Section No' },
        { name: 'code', label: 'Code' },
        { name: 'capacity', label: 'Capacity' },
        { name: 'appointmentCount', label: 'Appointment' },
        { name: 'enrollmentCount', label: 'Enrollment' },
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
            private router: Router,
            private route: ActivatedRoute,
            private actions: SectionActions,
            private store: Store<TermModuleState>,
            private formBuilder: FormBuilder,
            private vcf: ViewContainerRef,
            private snackBar: MdSnackBar,
            private dialog: MdDialog  ) {
     }
    
    ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
        console.log("changes", changes, changes['sections']);
        if (changes['sections']) {
          this.filteredData = changes['sections'].currentValue;
          this.filteredTotal = changes['sections'].currentValue.length;
          this.filter();
        }
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
        let newData: any[] = this.sections;
        newData = this._dataTableService.filterData( newData, this.searchTerm, true );
        this.filteredTotal = newData.length;
        newData = this._dataTableService.sortData( newData, this.sortBy, this.sortOrder );
        newData = this._dataTableService.pageData( newData, this.fromRow, this.currentPage * this.pageSize );
        this.filteredData = newData;
    }


    ngOnInit(): void {
        this.selectedRows = this.sections.filter((value) => value.selected);
      }

      ngAfterViewInit(): void {
        this.filteredData = this.sections;
        this.filteredTotal = this.sections.length;
        this.filter();
      }


    selectRow( section: Section ): void {
    }

    selectAllRows( sections: Section[] ): void {
    }

    editDialog( section: Section, isValid: boolean ): void {
        console.log( 'Section:{}', section );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '60%';
        config.height = '30%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open( SectionEditorDialog, config );
        if ( isValid ) {
            this.creatorDialogRef.componentInstance.section = section;
            this.creatorDialogRef.componentInstance.offering = this.offering;

        }
        this.creatorDialogRef.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog section' );
            // load something here
        } );
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
        this.creatorDialogRef.componentInstance.offering = this.offering;
        this.creatorDialogRef.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog' );
            // load something here
        } );
    }

    deleteSection( section: Section ): void {
        if ( section.enrollmentCount || section.appointmentCount > 0 ) {
            console.log( "Don't delete this Section" ); //try to print at console
            let snackBarRef = this.snackBar.open( 'Section cannot be deleted', 'OK' );
        } else {
            console.log( 'deleteSection' ); // move on
            this.store.dispatch( this.actions.deleteSection( this.offering, section ) );
        }
    }

    goBack( route: string ): void {
        this.router.navigate( ['/offerings'] );
    }
}

