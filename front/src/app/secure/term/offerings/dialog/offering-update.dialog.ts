import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Offering} from '../../../../shared/model/term/offering.interface';
import {OfferingActions} from '../offering.action';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {Store} from '@ngrx/store';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {Course} from '../../../../shared/model/planner/course.interface';
import {Program} from '../../../../shared/model/planner/program.interface';
import {TermModuleState} from '../../index';

@Component({
  selector: 'pams-offering-update',
  templateUrl: './offering-update.dialog.html',
})

export class OfferingUpdateDialog implements OnInit {
  private createForm: FormGroup;
  private edit: boolean = false;
  private _offering: Offering;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private store: Store<TermModuleState>,
    private viewContainerRef: ViewContainerRef,
    private actions: OfferingActions,
    private snackBar: MdSnackBar,
    public dialog: MdDialogRef<OfferingUpdateDialog>) {
  }

  set offering(value: Offering) {
    this._offering = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Offering>{
      id: null,
      code: '',
      canonicalCode: '',
      capacity: 0,
      titleMs: '',
      titleEn: '',
      academicSession: <AcademicSession>{},
      course: <Course>{},
      program: <Program>{},

    });

    if (this.edit) this.createForm.patchValue(this._offering);
  }

  submit(offering: Offering, isValid: boolean) {
    console.log(JSON.stringify(offering));
    this.store.dispatch(this.actions.updateOffering(offering));
    this.dialog.close();
    let snackBarRef = this.snackBar.open('New offering: ' + offering.code + ' has been updated', '', {duration: 3000});

  }

  //submit update button
  /*
   submit(offering: Offering, isValid: boolean) {
   console.log(JSON.stringify(offering));
   if (!offering.id) this.store.dispatch(this.actions.saveOffering(offering));
   else  this.store.dispatch(this.actions.updateOffering(offering));
   this.dialog.close();

   }
   */
}

