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
import {Graduation} from '../../../../shared/model/graduation/graduation.interface';
import {  IPageChangeEvent,  ITdDataTableSortChangeEvent,  TdDataTableService,  TdDataTableSortingOrder} from '@covalent/core';
import {MdSnackBar, MdDialog} from '@angular/material';
import { Router, ActivatedRoute } from "@angular/router";
import { GraduationApplicationActions } from "../graduation-application.action";
import { FormBuilder } from "@angular/forms";
import { Store } from "@ngrx/store";
import { GraduationModuleState } from "../../index";

@Component({
  selector: 'pams-graduation-list',
  templateUrl: './graduation-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class GraduationListComponent implements AfterViewInit, OnChanges {
   // export class GraduationApplicationListComponent {

    private selectedRows: Graduation[];
    
  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'referenceNo', label: 'Reference No'},
    {name: 'student.name', label: 'Name'},
    {name: 'student.identityNo', label: 'IdentityNo'},
    {name: 'cgpa', label: 'CGPA'},
    {name: 'creditHour', label: 'Credit Hour'},
    //{name: 'description', label: 'Description'},
    {name: 'academicSession.code', label: 'Academic Session'},
    {name: 'action', label: ''},
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'referenceNo';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() graduations: Graduation[];
  @Output() view: EventEmitter<Graduation> = new EventEmitter<Graduation>();

  constructor(private _dataTableService: TdDataTableService,
          private router: Router,
          private route: ActivatedRoute,
          private actions: GraduationApplicationActions,
          private store: Store<GraduationModuleState>,
          private formBuilder: FormBuilder,
          private vcf: ViewContainerRef,
          private snackBar: MdSnackBar,
          private dialog: MdDialog) {
  }

  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    console.log("changes", changes, changes['graduations']);
    if (changes['graduations']) {
      this.filteredData = changes['graduations'].currentValue;
      this.filteredTotal = changes['graduations'].currentValue.length;
      this.filter();
    }
  }

  ngAfterViewInit(): void {
    this.filteredData = this.graduations;
    this.filteredTotal = this.graduations.length;
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
    let newData: any[] = this.graduations;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

 
}
