import {Component, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {FormBuilder, Validators} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Offering} from '../offering.interface';
import {OfferingActions} from '../offering.action';
import {MdDialogRef} from '@angular/material';
import {Store} from '@ngrx/store';
import {AcademicSession} from '../../../planner/academic-sessions/academic-session.interface';
import {Course} from '../../../planner/courses/course.interface';
import {Program} from '../../../planner/programs/program.interface';
import {TermModuleState} from '../../index';

@Component({
  selector: 'pams-offering-editor',
  templateUrl: './offering-editor.dialog.html',
})

export class OfferingEditorDialog implements OnInit {

  private createForm: FormGroup;
  private edit: boolean = false;
  private _offering: Offering;
  private _program: Program;
  private _course: Course;
  private isOfferingExists: boolean;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: OfferingActions,
              public dialog: MdDialogRef<OfferingEditorDialog>) {
    // no op
  }

  ngOnInit(): void {
      this.createForm = this.formBuilder.group({
      id: [undefined],
      code: '',
      canonicalCode: '',
      capacity: ['', Validators.required],
      titleMs: '',
      titleEn: '',
      academicSession: [<AcademicSession>{}, Validators.required],
      course:[<Course>{}, Validators.required],
      program: [<Program>{}, Validators.required],
    });
    if (this.edit) {
      this.createForm.patchValue(this._offering);
    }
  }

  submit(offering: Offering, isValid: boolean, isOfferingExists: boolean): void {
           
    // workaround
    this._program = offering.program;
    this._course = offering.course;

    // console.log(JSON.stringify(offering));
    console.log('program: ' + JSON.stringify(this._program));
    console.log('course: ' + JSON.stringify(this._course));

    offering.canonicalCode = this._program.code + '-' + this._course.code;
    offering.code = this._course.code;
    offering.titleMs = this._course.titleMs;
    offering.titleEn = this._course.titleEn;

    console.log('code:' + this._program.code);
    console.log('courseCode:' + this._course.code);
    console.log('conicalCode:' + offering.canonicalCode);
    console.log('offeringcode:' + offering.code);
    console.log('offeringtitleMs:' + offering.titleMs);
    console.log('offeringtitleEn:' + offering.titleEn);
   
    if (!this.edit) {
        this.store.dispatch(this.actions.saveOffering(this._program, this._course, offering));
        console.log('Offering data will be save');
        this.dialog.close();
    
    } else {  
        this.store.dispatch(this.actions.updateOffering(offering));
        console.log('Offering data will be update');
        this.dialog.close();
    }
  }
}

