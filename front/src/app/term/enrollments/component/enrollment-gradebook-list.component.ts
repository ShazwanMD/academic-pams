import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';
import {Gradebook} from '../../gradebooks/gradebook.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {GradebookActions} from '../../gradebooks/gradebook.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {Enrollment} from '../enrollment.interface';
import { MdSnackBar } from '@angular/material';

@Component({
  selector: 'pams-enrollment-gradebook-list',
  templateUrl: './enrollment-gradebook-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EnrollmentGradebookListComponent implements OnInit {

  private selectedRows: Gradebook[];
  private columns: any[] = [
    {name: 'ordinal', label: 'Section No'},
    {name: 'code', label: 'Code'},
    {name: 'capacity', label: 'Capacity'},
    {name: 'appointmentCount', label: 'Appointment'},
    {name: 'enrollmentCount', label: 'Enrollment'},
    {name: 'action', label: ''},
  ];

  @Input() gradebook: Gradebook;
  @Input() enrollment: Enrollment;
  @Input() gradebooks: Gradebook[];
  @Output() view = new EventEmitter<Gradebook>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: GradebookActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {
  }

  ngOnInit(): void {
    //this.selectedRows = this.gradebooks.filter((value) => value.selected);
  }

  filter(): void {
  }

  selectRow(gradebook: Gradebook): void {
  }

  selectAllRows(gradebooks: Gradebook[]): void {
  } 

  goBack(route: string): void {
      this.router.navigate(['/enrollments']);
    }
}

