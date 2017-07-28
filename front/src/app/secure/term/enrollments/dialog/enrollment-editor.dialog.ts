import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Enrollment} from '../../../../shared/model/term/enrollment.interface';
import {EnrollmentActions} from '../enrollment.action';
import {Section} from '../../../../shared/model/term/section.interface';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {EnrollmentStatus} from '../../../../shared/model/term/enrollment-status.enum';
import {TermModuleState} from '../../index';

@Component({
  selector: 'pams-enrollment-editor',
  templateUrl: './enrollment-editor.dialog.html',
})

export class EnrollmentEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private _section: Section;
  private _enrollment: Enrollment;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: EnrollmentActions,
              private dialog: MdDialogRef<EnrollmentEditorDialog>,
              private viewContainerRef: ViewContainerRef) {
  }

  set section(value: Section) {
    this._section = value;
  }

  set enrollment(value: Enrollment) {
    this._enrollment = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<Enrollment>{
      id: undefined,
      enrollmentStatus: <EnrollmentStatus>{},

    });

    // set offering by default
    this.editorForm.patchValue({'section': this._section});
    if (this.edit) this.editorForm.patchValue(this._enrollment);
  }

  submit(enrollment: Enrollment, isValid: boolean) {
    console.log('enrollment', enrollment);
    console.log('section', this._section);
    console.log(this._section);
    console.log(this._enrollment);

    // set codes
    this.store.dispatch(this.actions.updateEnrollment(this._section, enrollment));
    this.dialog.close();
  }
}
