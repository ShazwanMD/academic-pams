import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef, Input, EventEmitter, Output} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {AdmissionApplication} from '../../shared/model/term/admission-application.interface';
import {AdmissionApplicationActions} from './admission-application.action';
import {TermModuleState} from '../index';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';

@Component({
  selector: 'pams-admission-application-detail',
  templateUrl: './admission-application-detail.page.html',
})

export class AdmissionApplicationDetailPage implements OnInit {

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

