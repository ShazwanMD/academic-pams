import {AdmissionCreateTaskCreatorDialog} from './dialog/admission-create-task-creator.dialog';
import {MdDialogRef, MdDialog, MdDialogConfig} from '@angular/material';
import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Admission} from '../../shared/model/term/admission.interface';
import {AdmissionActions} from './admission.action';
import {TermModuleState} from '../index';
import {AdmissionApplication} from '../../shared/model/term/admission-application.interface';

@Component({
  selector: 'pams-admission-center',
  templateUrl: './admission-center.page.html',
})
export class AdmissionCenterPage implements OnInit {

  private ADMISSIONS: string[] = 'termModuleState.admissions'.split('.');
  private admissions$: Observable<Admission[]>;
  private creatorDialogRef: MdDialogRef<AdmissionCreateTaskCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AdmissionActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.admissions$ = this.store.select(...this.ADMISSIONS);
  }

  viewAdmission(admission: Admission) {
    console.log('admission: ' + admission.id);
    this.router.navigate(['/term/admissions', admission.id]);

  }

  viewAdmissionApplication(admissionApplication: AdmissionApplication) {
    // console.log( "admission application: " + admissionApplication.id );
    //this.router.navigate( ['/term/admission-applications', admissionApplication.id] );

  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findAdmissions());
    this.store.dispatch(this.actions.findAdmissionApplications());
  }

  private createDialog(id: Admission): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '65%';
    config.height = '85%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AdmissionCreateTaskCreatorDialog, config);
    if (id) this.creatorDialogRef.componentInstance.admission = id;

    //set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

  /* filter(): void {
   }*/

  goBack(route: string): void {
    this.router.navigate(['/admissions']);
  }
}
