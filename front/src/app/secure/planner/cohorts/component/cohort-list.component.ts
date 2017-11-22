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
import {Cohort} from '../../../../shared/model/planner/cohort.interface';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';
import {MdSnackBar} from '@angular/material';

@Component({
  selector: 'pams-cohort-list',
  templateUrl: './cohort-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CohortListComponent implements AfterViewInit, OnChanges {


  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''},
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'id';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

@Input() cohorts: Cohort[];
@Output() view: EventEmitter<Cohort> = new EventEmitter<Cohort>();

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }

  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
      console.log("changes", changes, changes['cohorts']);
      if (changes['cohorts']) {
        this.filteredData = changes['cohorts'].currentValue;
        this.filteredTotal = changes['cohorts'].currentValue.length;
        this.filter();
      }
    }

    ngAfterViewInit(): void {
      this.filteredData = this.cohorts;
      this.filteredTotal = this.cohorts.length;
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
      let newData: any[] = this.cohorts;
      newData = this._dataTableService.filterData(newData, this.searchTerm, true);
      this.filteredTotal = newData.length;
      newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
      newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
      this.filteredData = newData;
    }

    viewCohort(cohort: Cohort): void {
      console.log('Emitting cohort');
      let snackBarRef = this.snackBar.open('Viewing cohort info', 'OK' , { duration: 2000 } );
      snackBarRef.afterDismissed().subscribe(() => {
        this.view.emit(cohort);
      });
    }

  }
