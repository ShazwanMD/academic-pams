import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {TermModuleState} from '../../index';
import {Section} from '../../../shared/model/term/section.interface';
import {SectionActions} from '../section.action';
import {Offering} from '../../../shared/model/term/offering.interface';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'pams-section-editor',
  templateUrl: './section-editor.dialog.html',
})

export class SectionEditorDialog implements OnInit {

  private _section: Section;
  private _offering: Offering;
  private editorForm: FormGroup;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: SectionActions,
              private dialog: MdDialogRef<SectionEditorDialog>,
              private viewContainerRef: ViewContainerRef) {
  }

  set offering(value: Offering) {
    this._offering = value;

  }

  set section(value: Section) {
    this._section = value;
    this.edit = true;

  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group({
      id: undefined,
      code: '',
      canonicalCode: '',
      capacity: ['', Validators.required],
      ordinal: ['', Validators.required],
      offering: ['', Validators.required],
      //offering: <Offering>{},
    });

    // set offering by default
    this.editorForm.patchValue({'offering': this._offering});
    if (this.edit) this.editorForm.patchValue(this._section);
  }

  submit(section: Section, isValid: boolean): void {
    // set codes
    section.canonicalCode = this._offering.canonicalCode + '' + section.ordinal;
    section.code = this._offering.code + '' + section.ordinal;

    if (!section.id)
      this.store.dispatch(this.actions.addSection(this._offering, section));
    else this.store.dispatch(this.actions.updateSection(this._offering, section));
    this.dialog.close();

  }
}
