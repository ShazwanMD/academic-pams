import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {TermModuleState} from "../../index";
import {Section} from "../section.interface";
import {SectionActions} from "../section.action";
import {Offering} from "../../offerings/offering.interface";

@Component({
  selector: 'pams-section-editor',
  templateUrl: './section-editor.dialog.html',
})

export class SectionEditorDialog implements OnInit {

  private _offering: Offering;
  private editorForm: FormGroup;
  private edit: boolean = false;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: SectionActions,
              private dialog: MdDialogRef<SectionEditorDialog>,
              private viewContainerRef: ViewContainerRef) {
  }

  set offering(value: Offering) {
    this._offering = value;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<Section>{
      id: null,
      code: '',
      canonicalCode: '',
      capacity: 0,
      ordinal: 0,
      offering: <Offering>{}
    });

    // set offering by default
    this.editorForm.patchValue({'offering': this._offering});
  }

  submit(section: Section, isValid: boolean) {
    // set codes
    section.canonicalCode = this._offering.canonicalCode + "" + section.ordinal
    section.code = this._offering.code + "" + section.ordinal

    // dispatch action
    this.store.dispatch(this.actions.addSection(this._offering, section));
    this.dialog.close();
  }
}
