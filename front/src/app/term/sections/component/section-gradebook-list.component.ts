import {SectionActions} from '../section.action';
import {
  Component,
  Input,
  EventEmitter,
  Output,
  ChangeDetectionStrategy,
  ViewContainerRef,
  OnInit,
  AfterViewInit
} from '@angular/core';
import {Enrollment} from '../../../shared/model/term/enrollment.interface';
import {Section} from '../../../shared/model/term/section.interface';
import {Store} from '@ngrx/store';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {TermModuleState} from '../../index';
import {EnrollmentEditorDialog} from '../../enrollments/dialog/enrollment-editor.dialog';
import {Gradebook} from '../../../shared/model/term/gradebook.interface';
import {GradebookActions} from '../../gradebooks/gradebook.action';
import {
  TdDataTableSortingOrder,
  TdDataTableService,
  IPageChangeEvent,
  ITdDataTableSortChangeEvent
} from '@covalent/core';

@Component({
  selector: 'pams-section-gradebook-list',
  templateUrl: './section-gradebook-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SectionGradebookListComponent implements AfterViewInit {

  private creatorDialogRef: MdDialogRef<EnrollmentEditorDialog>;
  private selectedRows: Gradebook[];
  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'assessment.description', label: 'Assessment'},
    {name: 'assessment.weight', label: 'weight(%)'},
    {name: 'assessment.assessmentCategory', label: 'assessmentCategory'},
    {name: 'enrollment.admission.student.identityNo', label: 'Identity No'},
    {name: 'enrollment.admission.student.name', label: 'Name'},
    {name: 'score', label: 'Score'},
    {name: 'enrollment.gradeCode.code', label: 'Grade'},

    {name: 'action', label: ''},
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'score';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  @Input() section: Section;
  @Input() gradebook: Gradebook;
  @Input() gradebooks: Gradebook[];
  @Output() view = new EventEmitter<Gradebook>();

  constructor(private _dataTableService: TdDataTableService,
              private router: Router,
              private route: ActivatedRoute,
              private actions: GradebookActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }

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
}
