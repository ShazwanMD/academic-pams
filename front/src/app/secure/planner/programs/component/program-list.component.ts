import {Observable} from 'rxjs';
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
import {Program} from '../../../../shared/model/planner/program.interface';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';
import {MdSnackBar} from '@angular/material';

@Component({
  selector: 'pams-program-list',
  templateUrl: './program-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramListComponent implements OnChanges, AfterViewInit {

  private PROGRAMS: string[] = 'plannerModuleState.bankCodes'.split('.');
  private programs$: Observable<Program>;
  @Input() programs: Program[];
  @Output() view = new EventEmitter<Program>();

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'titleEn', label: 'TitleEn'},
    {name: 'action', label: ''},
  ];

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }

  viewProgram(program: Program): void {
    console.log('Emitting programs');
    let snackBarRef = this.snackBar.open('Viewing program info', 'OK' , { duration: 2000 } );
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(program);
    });

  }

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'code';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    console.log('changes', changes, changes['programs']);
    if (changes['programs']) {
      this.filteredData = changes['programs'].currentValue;
      this.filteredTotal = changes['programs'].currentValue.length;
      this.filter();
    }
  }

  ngAfterViewInit(): void {
    this.filteredData = this.programs;
    this.filteredTotal = this.programs.length;
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
    let newData: any[] = this.programs;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

}