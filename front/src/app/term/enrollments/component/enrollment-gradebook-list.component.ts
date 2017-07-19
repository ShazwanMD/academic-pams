import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit, AfterViewInit } from '@angular/core';
import {Gradebook} from '../../gradebooks/gradebook.interface';
import { MdDialog, MdDialogConfig, MdDialogRef } from "@angular/material";
import {ActivatedRoute, Router} from '@angular/router';
import {GradebookActions} from '../../gradebooks/gradebook.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {Enrollment} from '../enrollment.interface';
import { MdSnackBar } from '@angular/material';
import { TdDataTableSortingOrder, TdDataTableService, IPageChangeEvent, ITdDataTableSortChangeEvent } from "@covalent/core";

@Component({
  selector: 'pams-enrollment-gradebook-list',
  templateUrl: './enrollment-gradebook-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EnrollmentGradebookListComponent implements AfterViewInit {

  private columns: any[] = [
    {name: 'assessment.code', label: 'Code'},
    {name: 'assessment.description', label: 'Assessment'},
    {name: 'assessment.assessmentType', label: 'Type'},
    {name: 'assessment.assessmentCategory', label: 'Category'},   
    {name: 'assessment.totalScore', label: 'Total Score'},
    {name: 'score', label: 'Marks'},
    { name: 'enrollment.gradeCode.code', label: 'Grade' },
    { name: 'enrollment.gradeCode.description', label: 'Status' },
    
    {name: 'action', label: ''},
  ];

  @Input() enrollment: Enrollment;
  @Input() gradebook: Gradebook;
  @Input() gradebooks: Gradebook[];
  @Output() view = new EventEmitter<Gradebook>();

  constructor(private router: Router,
              private _dataTableService: TdDataTableService,
              private route: ActivatedRoute,
              private actions: GradebookActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
  }
  
  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'score';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  ngAfterViewInit(): void {
      this.filteredData = this.gradebooks;
      this.filteredTotal = this.gradebooks.length;
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
      let newData: any[] = this.gradebooks;
      newData = this._dataTableService.filterData(newData, this.searchTerm, true);
      this.filteredTotal = newData.length;
      newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
      newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
      this.filteredData = newData;
  }
    
  selectRow(gradebook: Gradebook): void {
  }

  selectAllRows(gradebooks: Gradebook[]): void {
  } 

  goBack(route: string): void {
      this.router.navigate(['/enrollments']);
    }
}

