import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, AfterViewInit} from '@angular/core';
import {Course} from "../course.interface";
import { TdDataTableSortingOrder, TdDataTableService, ITdDataTableSortChangeEvent, IPageChangeEvent } from '@covalent/core';
import { PlannerModuleState } from './../../index';
import { Observable } from 'rxjs';
import { CourseActions } from './../course.action';
import { MdSnackBar } from "@angular/material";

@Component({
  selector: 'pams-course-list',
  templateUrl: './course-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CourseListComponent implements AfterViewInit  {

  
    @Input() courses: Course[];
    @Output() view = new EventEmitter<Course>();

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'titleEn', label: 'Title(En)'},
    {name: 'titleMs', label: 'Title(Ms)'},
    {name: 'credit', label: 'Credit'},
    {name: 'action', label: ''}
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'code';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;


   constructor(private _dataTableService: TdDataTableService,
          private snackBar: MdSnackBar) {}
  
  
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
   console.log("Emitting courses");
   let snackBarRef = this.snackBar.open("Viewing courses info", "OK");
   snackBarRef.afterDismissed().subscribe(() => {
   this.view.emit(course);
    });
  }
}

