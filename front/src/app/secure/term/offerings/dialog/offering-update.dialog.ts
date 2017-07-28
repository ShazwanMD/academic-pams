import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Offering} from '../../../../shared/model/term/offering.interface';
import {OfferingActions} from '../offering.action';
import {MdDialogRef} from '@angular/material';
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

