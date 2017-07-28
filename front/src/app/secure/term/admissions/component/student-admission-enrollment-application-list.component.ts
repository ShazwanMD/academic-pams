import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output, ViewContainerRef} from '@angular/core';
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {EnrollmentApplicationActions} from '../../enrollment-applications/enrollment-application.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {Admission} from '../../../../shared/model/term/admission.interface';
import {AdmissionEnrollmentDialog} from '../dialog/admission-enrollment.dialog';

@Component({
  selector: 'pams-student-admission-enrollment-application-list',
  templateUrl: './student-admission-enrollment-application-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentAdmissionEnrollmentApplicationListComponent implements OnInit {

  private columns: any[] = [
    {name: 'id', label: 'Id'}, //referenceNo
    {name: 'referenceNo', label: 'Reference No.'},
    {name: 'auditNo', label: 'Audit No.'},
    {name: 'sourceNo', label: 'Source No.'},
    {name: 'description', label: 'Description'},
    {name: 'applicationType', label: 'Application Type'},
    {name: 'action', label: ''},
  ];
  private selectedRows: EnrollmentApplication[];
  private creatorDialogRef: MdDialogRef<AdmissionEnrollmentDialog>;

  @Input() enrollmentApplication: EnrollmentApplication;
  @Input() admission: Admission;
  @Input() enrollmentApplications: EnrollmentApplication[];
  @Output() view: EventEmitter<EnrollmentApplication> = new EventEmitter<EnrollmentApplication>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
    this.selectedRows = this.enrollmentApplications.filter((value) => value.selected);
  }

  filter(): void {
  }

  selectRow(enrollmentApplication: EnrollmentApplication): void {
  }

  selectAllRows(enrollmentApplications: EnrollmentApplication[]): void {
  }

  showDialog(): void {
    console.log('showDialog details');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '90%';
    config.height = '90%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AdmissionEnrollmentDialog, config);

    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  delete(admission: Admission, application: EnrollmentApplication): void {
    this.store.dispatch(this.actions.removeEnrollmentApplication(this.admission, application));
  }

}
