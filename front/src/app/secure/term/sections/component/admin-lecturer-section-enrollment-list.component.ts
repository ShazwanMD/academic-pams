import {EnrollmentActions} from '../../enrollments/enrollment.action';
import {
  AfterViewInit,
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  Output,
  ViewContainerRef
} from '@angular/core';
import {Enrollment} from '../../../../shared/model/term/enrollment.interface';
import {Section} from '../../../../shared/model/term/section.interface';
import {Store} from '@ngrx/store';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {TermModuleState} from '../../index';
import {EnrollmentEditorDialog} from '../../enrollments/dialog/enrollment-editor.dialog';
import {
  IPageChangeEvent,
  ITdDataTableSortChangeEvent,
  TdDataTableService,
  TdDataTableSortingOrder
} from '@covalent/core';

@Component({
  selector: 'pams-admin-lecturer-section-enrollment-list',
  templateUrl: './admin-lecturer-section-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdminLecturerSectionEnrollmentListComponent implements AfterViewInit {

  @Input() section: Section;
  @Input() enrollment: Enrollment;
  @Input() enrollments: Enrollment[];
  @Output() view = new EventEmitter<Enrollment>();

  private creatorDialogRef: MdDialogRef<EnrollmentEditorDialog>;
  private selectedRows: Enrollment[];

  private columns: any[] = [
   
    {name: 'admission.student.name', label: 'Student'},
    {name: 'enrollmentStatus', label: 'Status'},
    {name: 'enrollmentStanding', label: 'Standing'},
    {name: 'totalScore', label: 'TotalScore'},
    {name: 'gradeCode.code', label: 'Grade Code'},
    {name: 'admission.student.studentStatus', label: 'studentStatus'},
    {name: 'action', label: ''},
  ];

  filteredData: any[];
  filteredTotal: number;
  searchTerm: string = '';
  fromRow: number = 1;
  currentPage: number = 1;
  pageSize: number = 5;
  sortBy: string = 'admission.student.name';
  sortOrder: TdDataTableSortingOrder = TdDataTableSortingOrder.Descending;

  constructor(private _dataTableService: TdDataTableService,
              private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }

  ngAfterViewInit(): void {
    this.filteredData = this.enrollments;
    this.filteredTotal = this.enrollments.length;
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
    let newData: any[] = this.enrollments;
    newData = this._dataTableService.filterData(newData, this.searchTerm, true);
    this.filteredTotal = newData.length;
    newData = this._dataTableService.sortData(newData, this.sortBy, this.sortOrder);
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }

  selectRow(enrollment: Enrollment): void {
  }

  selectAllRows(enrollments: Enrollment[]): void {
  }

  //edit dialog
  editDialog(enrollment: Enrollment, isValid: boolean): void {
    console.log('showDialogEnrollment');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(EnrollmentEditorDialog, config);
    if (isValid) {
      this.creatorDialogRef.componentInstance.enrollment = enrollment;
      this.creatorDialogRef.componentInstance.section = this.section;

    }
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

}
