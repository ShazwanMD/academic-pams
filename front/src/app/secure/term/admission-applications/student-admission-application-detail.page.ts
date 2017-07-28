import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {AdmissionApplication} from '../../../shared/model/term/admission-application.interface';
import {AdmissionApplicationActions} from './admission-application.action';
import {TermModuleState} from '../index';
import {MdDialog} from '@angular/material';

@Component({
  selector: 'pams-student-admission-application-detail',
  templateUrl: './student-admission-application-detail.page.html',
})

export class StudentAdmissionApplicationDetailPage implements OnInit {

  private ADMISSION_APPLICATION: string[] = 'termModuleState.admissionApplication'.split('.');
  private admissionApplication$: Observable<AdmissionApplication>;

  @Input() admissionApplication: AdmissionApplication;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AdmissionApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.admissionApplication$ = this.store.select(...this.ADMISSION_APPLICATION);

  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { referenceNo: string }) => {
      let referenceNo: string = params.referenceNo;
      this.store.dispatch(this.actions.findAdmissionApplicationByReferenceNo(referenceNo));
    });
  }

  filter(): void {

  }

  goBack(route: string): void {
    this.router.navigate(['/admission-applications']);
  }

}

