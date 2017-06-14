import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';
import {Enrollment} from '../../enrollments/enrollment.interface';
import {MdDialog} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {EnrollmentActions} from '../../enrollments/enrollment.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {Admission} from '../admission.interface';

@Component({
  selector: 'pams-admission-enrollment-list',
  templateUrl: './admission-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionEnrollmentListComponent implements OnInit {

  private columns: any[] = [
    {name: 'standing', label: 'Standing'},
    {name: 'status', label: 'Status'},
    {name: 'section.id', label: 'Section'},
    {name: 'action', label: ''},
  ];

  @Input() enrollment: Enrollment;
  @Input() admission: Admission;
  @Input() enrollments: Enrollment[];
  @Output() view: EventEmitter<Enrollment> = new EventEmitter<Enrollment>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
  }

  filter(): void {
  }

  selectRow(enrollment: Enrollment): void {
  }

  selectAllRows(enrollments: Enrollment[]): void {
  }
}

