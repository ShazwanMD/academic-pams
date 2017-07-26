import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, AfterViewInit, SimpleChange, OnChanges} from '@angular/core';
import {AcademicSession} from "../academic-session.interface";
import { TdDataTableSortingOrder, ITdDataTableSortChangeEvent, IPageChangeEvent, TdDataTableService } from "@covalent/core";
import { MdSnackBar } from "@angular/material";
import { PlannerModuleState } from './../../index';
import { Observable } from 'rxjs';
import { AcademicSessionActions } from './../academic-session.action';

@Component ({
    selector: 'pams-academic-session-list',
    templateUrl: './academic-session-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})

export class AcademicSessionListComponent implements AfterViewInit, OnChanges {

  
    @Input() academicSessions: AcademicSession[];
    @Output() view = new EventEmitter<AcademicSession>();
    
    private columns: any [] = [
        {name: 'code', label: 'Code'},
        {name: 'description', label: 'Description'},
        {name: 'current', label: 'Status'},
        {name: 'action', label: ''},

    ];
    
    constructor(private _dataTableService: TdDataTableService,
            private snackBar: MdSnackBar) {}
    
    viewAcademicSession(academicSession:AcademicSession): void {
        console.log("Emitting academicSessions");
        let snackBarRef = this.snackBar.open("Viewing academicSession info", "OK");
        snackBarRef.afterDismissed().subscribe(() => {
        this.view.emit(academicSession);
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
  
    
    ngOnChanges(changes: {[ propName: string]: SimpleChange}) {
      console.log("changes",changes,changes['academicSessions']);
          if (changes['academicSessions']){
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
