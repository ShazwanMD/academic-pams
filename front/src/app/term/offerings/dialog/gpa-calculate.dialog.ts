import {Component, ViewContainerRef, OnInit, Input} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Offering} from '../../../shared/model/term/offering.interface';
import {OfferingActions} from '../offering.action';
import {MdDialogRef} from '@angular/material';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';

@Component({
  selector: 'pams-gpa-calculate',
  templateUrl: './gpa-calculate.dialog.html',
})
export class GpaCalculateDialog {

  @Input() offering: Offering;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private viewContainerRef: ViewContainerRef,
              private actions: OfferingActions,
              public dialog: MdDialogRef<GpaCalculateDialog>) {
  }

  calculate(offering: Offering) {
    console.log('offering CanonicalCode:{}', this.offering.canonicalCode);
    this.store.dispatch(this.actions.calculateGPA(this.offering));
    this.dialog.close();
  }

  cancel(offering: Offering) {
    this.dialog.close();
  }

}

