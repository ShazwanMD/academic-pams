import { CohortActions } from './../cohort.action';
import { Cohort } from './../cohort.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {MdDialogRef} from "@angular/material";
import {Router, ActivatedRoute} from '@angular/router';



@Component({
  selector: 'pams-cohort-editor',
  templateUrl: './cohort-editor.dialog.html',
})

export class CohortEditorDialog implements OnInit {

  private cohort: Cohort;
  private editForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private actions: CohortActions,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CohortEditorDialog>) {
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Cohort>{
    code: '',
    description: '',

   });


    this.editForm.patchValue(this.cohort);
  }

  save(Cohort: Cohort, isValid: boolean) {
    // do something
  }
}
