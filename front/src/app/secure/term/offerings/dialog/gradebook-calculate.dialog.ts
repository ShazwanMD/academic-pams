import {Component, Input, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Offering} from '../../../../shared/model/term/offering.interface';
import {OfferingActions} from '../offering.action';
import {MdDialogRef} from '@angular/material';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';

@Component({
  selector: 'pams-gradebook-calculate',
  templateUrl: './gradebook-calculate.dialog.html',
})
export class GradebookCalculateDialog {

  @Input() offering: Offering;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private viewContainerRef: ViewContainerRef,
              private actions: OfferingActions,
              public dialog: MdDialogRef<GradebookCalculateDialog>) {
  }

  calculate(offering: Offering) {
    console.log('offering CanonicalCode:{}', this.offering.canonicalCode);
    this.store.dispatch(this.actions.calculateGradebook(this.offering));
    this.dialog.close();
  }

  cancel(offering: Offering) {
    this.dialog.close();
  }

}

