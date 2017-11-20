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
import {Course} from '../../../../shared/model/planner/course.interface';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';
import {MdSnackBar} from '@angular/material';

@Component({
  selector: 'pams-course-list',
  templateUrl: './course-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CourseListComponent implements AfterViewInit, OnChanges {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'code', label: 'Code'},
    {name: 'titleEn', label: 'Title(En)'},
    {name: 'titleMs', label: 'Title(Ms)'},
    {name: 'credit', label: 'Credit'},
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

  @Input() courses: Course[];
  @Output() view = new EventEmitter<Course>();


  constructor(private _dataTableService: TdDataTableService,
              private snackBar: MdSnackBar) {
  }

  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    console.log('changes', changes, changes['courses']);
    if (changes['courses']) {
      this.filteredData = changes['courses'].currentValue;
      this.filteredTotal = changes['courses'].currentValue.length;
      this.filter();
    }
  }

  ngAfterViewInit(): void {
    this.filteredData = this.courses;
    this.filteredTotal = this.courses.length;
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
    let newData: any[] = this.courses;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

  viewCourse(course: Course): void {
    console.log('Emitting courses');
    let snackBarRef = this.snackBar.open('Viewing courses info', '' , { duration: 3000 } );
    snackBarRef.afterDismissed().subscribe(() => {
      this.view.emit(course);
    });
  }
}

