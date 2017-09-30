/*import {
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
import {Graduation} from '../../../../shared/model/graduation/graduation.interface';
import {  IPageChangeEvent,  ITdDataTableSortChangeEvent,  TdDataTableService,  TdDataTableSortingOrder} from '@covalent/core';
import {MdSnackBar, MdDialog} from '@angular/material';
import { Router, ActivatedRoute } from "@angular/router";
import { GraduationApplicationActions } from "../graduation-application.action";
import { FormBuilder } from "@angular/forms";
import { Store } from "@ngrx/store";
import { GraduationModuleState } from "../../index";
import { AcademicSession } from "../../../../shared/model/planner/academic-session.interface";
import { TermModuleState } from "../../../term/index";
import { AcademicSessionActions } from "../../../planner/academic-sessions/academic-session.action";

@Component({
  selector: 'pams-graduation-session-list',
  templateUrl: './graduation-session-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class GraduationSessionListComponent implements AfterViewInit, OnChanges {
   // export class GraduationApplicationListComponent {

  //  private selectedRows: Graduation[];
  private selectedRows: AcademicSession[];
    
  private columns: any[] = [
    {name: 'id', label: 'Id'},
   
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

  
  @Input() academicSessions: AcademicSession[];
  
  //@Input() graduations: Graduation[];
  @Output() view: EventEmitter<AcademicSession> = new EventEmitter<AcademicSession>();

  constructor(private _dataTableService: TdDataTableService,
          private router: Router,
          private route: ActivatedRoute,
          private actions: AcademicSessionActions,
          private store: Store<TermModuleState>,
          private formBuilder: FormBuilder,
          private vcf: ViewContainerRef,
          private snackBar: MdSnackBar,
          private dialog: MdDialog) {
  }

  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    console.log("changes", changes, changes['academicSessions']);
    if (changes['academicSessions']) {
      this.filteredData = changes['academicSessions'].currentValue;
      this.filteredTotal = changes['academicSessions'].currentValue.length;
      this.filter();
    }
  }

  ngAfterViewInit(): void {
    this.filteredData = this.academicSessions;
    this.filteredTotal = this.academicSessions.length;
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
    let newData: any[] = this.academicSessions;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

 
}
*/



import { ChangeDetectionStrategy, Component, EventEmitter, Input, Output } from '@angular/core';
import { AcademicSession } from "../../../../shared/model/planner/academic-session.interface";

@Component( {
    selector: 'pams-graduation-session-list',
    templateUrl: './graduation-session-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )

export class GraduationSessionListComponent {

    private columns: any[] = [
                              { name: 'id', label: 'Id' },
        { name: 'code', label: 'Code' },
        { name: 'description', label: 'Description' },
        { name: 'year.code', label: 'Session' },
        { name: 'year.year', label: 'Year' },
        { name: 'action', label: '' }
    ];

    @Input() academicSessions: AcademicSession[];
    @Output() view = new EventEmitter<AcademicSession>();
}
