import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef, Input, EventEmitter, Output} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Admission} from './admission.interface';
import {AdmissionActions} from './admission.action';
import {TermModuleState} from '../index';
import {AdmissionUpdateTaskCreatorDialog} from './dialog/admission-update-task-creator.dialog';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {AdmissionDeleteTaskCreatorDialog} from './dialog/admission-delete-task-creator.dialog';
import {Enrollment} from '../enrollments/enrollment.interface';

@Component({
  selector: 'pams-admission-detail',
  templateUrl: './admission-detail.page.html',
})

export class AdmissionDetailPage implements OnInit {

  private ADMISSION: string[] = 'termModuleState.admission'.split('.');
  private ENROLLMENTS: string[] = 'termModuleState.admissionEnrollments'.split('.');
  private admission$: Observable<Admission>;
  private enrollments$: Observable<Enrollment[]>;
  private creatorDialogRef: MdDialogRef<AdmissionUpdateTaskCreatorDialog>;
  private creatorDialogRefDel: MdDialogRef<AdmissionDeleteTaskCreatorDialog>;
  @Input() admission: Admission;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AdmissionActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.admission$ = this.store.select(...this.ADMISSION);
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);
  }

  showDialog(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '40%';
    config.height = '70%';
    config.position = {top: '3px'};
    this.creatorDialogRef = this.dialog.open(AdmissionUpdateTaskCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  showDialogDelete(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '40%';
    config.height = '45%';
    config.position = {top: '3px'};
    this.creatorDialogRefDel = this.dialog.open(AdmissionDeleteTaskCreatorDialog, config);
    this.creatorDialogRefDel.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { id: number }) => {
      let id: number = params.id;
      this.store.dispatch(this.actions.findAdmissionById(id));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/admissions']);
  }
}
