import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {TermModuleState} from '../../index';
import {Admission} from '../../../../shared/model/term/admission.interface';

@Component({
  selector: 'pams-admission-delete-task-creator',
  templateUrl: './admission-delete-task-creator.dialog.html',
})

export class AdmissionDeleteTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private dialog: MdDialogRef<AdmissionDeleteTaskCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Admission>{});
  }
}
