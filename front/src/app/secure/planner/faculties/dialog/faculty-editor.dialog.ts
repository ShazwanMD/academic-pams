import { MdDialogRef, MdSnackBar } from '@angular/material';
import {Store} from '@ngrx/store';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {Faculty} from '../../../../shared/model/planner/faculty.interface';
import {PlannerModuleState} from '../../index';
import {FacultyActions} from '../faculty.action';
import {FacultyStatus} from '../../../../shared/model/planner/faculty-status.enum';

@Component({
  selector: 'pams-faculty-editor',
  templateUrl: './faculty-editor.dialog.html',
})

export class FacultyEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _faculty: Faculty;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: FacultyActions,
              private router: Router,
              private snackBar: MdSnackBar,
              private route: ActivatedRoute,
              private vcf: ViewContainerRef,
              private dialog: MdDialogRef<FacultyEditorDialog>) {
  }

  set faculty(value: Faculty) {
    this._faculty = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<Faculty>{
      id: null,
      code: '',
      description: '',
      name: '',
      prefix: '',
      status: FacultyStatus.NEW,
    });
    if (this.edit) this.editorForm.patchValue(this._faculty);
  }

  save(faculty: Faculty, isValid: boolean) {
    console.log('updating faculty');
    if (!faculty.id) this.store.dispatch(this.actions.saveFaculty(faculty));
    else this.store.dispatch(this.actions.updateFaculty(faculty));
    let snackBarRef = this.snackBar.open( 'New Faculty: ' + faculty.code + ' has been updated', 'OK', { duration: 3000 } );
    snackBarRef.afterDismissed().subscribe(() => {
   } );
    this.dialog.close();
  }

}
