import { PlannerModuleState } from './../../index';
import { Observable } from 'rxjs';
import { ProgramActions } from './../program.action';
import { Store } from '@ngrx/store';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy} from '@angular/core';
import {Program} from "../program.interface";
import { TdDataTableSortingOrder, TdDataTableService, IPageChangeEvent, ITdDataTableSortChangeEvent } from "@covalent/core";
import { MdSnackBar } from "@angular/material";

@Component({
  selector: 'pams-program-list',
  templateUrl: './program-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramListComponent {


 private PROGRAMS:string[] = "plannerModuleState.bankCodes".split(".");
 private programs$: Observable<Program>;
  @Input() programs: Program[];
  @Output() view = new EventEmitter<Program>();

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'titleEn', label: 'TitleEn'},
    {name: 'action', label: ''}
  ];

  constructor(private _dataTableService: TdDataTableService,
          private snackBar: MdSnackBar) {}
  
  viewProgram(program:Program): void {
      console.log("Emitting programs");
      let snackBarRef = this.snackBar.open("Viewing program info", "OK");
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

  
  
  
 /*constructor(private store: Store<PlannerModuleState>,
              private actions: ProgramActions) {
   this.programs$ = this.store.select(...this.PROGRAMS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findPrograms());

  }

  filter(): void {
  }
}*/