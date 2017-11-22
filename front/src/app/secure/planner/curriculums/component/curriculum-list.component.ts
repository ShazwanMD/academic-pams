import {MdSnackBar} from '@angular/material/snack-bar';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';
import {SimpleChange, ChangeDetectionStrategy,  Component,  EventEmitter,  Input,  Output} from '@angular/core';
import {Curriculum} from '../../../../shared/model/planner/curriculum.interface';

@Component({
  selector: 'pams-curriculum-list',
  templateUrl: './curriculum-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CurriculumListComponent {

  // todo: credithours, etc etc
  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'code', label: 'Code'},
    {name: 'coreCredit.number', label: 'Core Credit'},
    {name: 'totalCredit.number', label: 'Total Credit'},
    {name: 'action', label: ''},
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'code';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() curriculums: Curriculum[];
  @Output() view = new EventEmitter<Curriculum>();

  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }

  ngAfterViewInit(): void {
    this.filteredData = this.curriculums;
    this.filteredTotal = this.curriculums.length;
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
    let newData: any[] = this.curriculums;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;

  }

  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    // console.log("changes", changes, changes['subjects'])
   
      this.filter();
  }

  viewCurriculum(curriculum: Curriculum): void {
    console.log("Emitting curriculums");
    let snackBarRef = this.snackBar.open("Viewing curriculums info", "OK" , { duration: 2000 } );
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(curriculum);
    });
  }
}
