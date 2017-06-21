import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Section} from "../../sections/section.interface";
import {EnrollmentApplicationItem} from "../enrollment-application-item.interface";
import {EnrollmentApplicationAction} from "../enrollment-application-action.enum";
import {TermModuleState} from "../../index";
import {EnrollmentApplicationActions} from "../enrollment-application.action";
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {EnrollmentApplication} from "../enrollment-application.interface";


@Component({
  selector: 'pams-enrollment-application-item-update',
  templateUrl: './enrollment-application-item-update.dialog.html',
})

export class EnrollmentApplicationItemUpdateDialog implements OnInit {

  private editForm: FormGroup;
  private _enrollmentApplicationItem: EnrollmentApplicationItem;
  private _application: EnrollmentApplication;
  private edit: boolean = false;


  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<TermModuleState>,
              private actions: EnrollmentApplicationActions,
              private dialog: MdDialogRef<EnrollmentApplicationItemUpdateDialog>) {

  }

  set enrollmentApplication(value: EnrollmentApplication) {
    this._application = value;
  }

  set enrollmentApplicationItem(value: EnrollmentApplicationItem) {
    this._enrollmentApplicationItem = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<EnrollmentApplicationItem>{
      id: null,
      action: EnrollmentApplicationAction.ADD,
      section: <Section>{},
    });
    
  /*  if (this.edit) this.editForm.patchValue(this._enrollmentApplicationItem);
  }*/
    
    this.editForm.patchValue({'enrollmentApplication': this._application});
    if (this.edit) this.editForm.patchValue(this._enrollmentApplicationItem);
  }

  /*save(item: EnrollmentApplicationItem, isValid: boolean) {
    console.log("enrollmentApplicationItem", item);
    console.log("enrollmentApplication", this._enrollmentApplication);
    this.store.dispatch(this.actions.addEnrollmentApplicationItem(this._enrollmentApplication, item));
    this.dialog.close();
  }*/
  
  save(item: EnrollmentApplicationItem, isValid: boolean) {
      // set codes
      console.log("enrollmentApplicationItem", item);
      console.log("enrollmentApplication", this._application);

      if (!item.id)
        this.store.dispatch(this.actions.addEnrollmentApplicationItem(this._application, item));
      else this.store.dispatch(this.actions.updateEnrollmentApplicationItem(this._application, item));
      this.dialog.close();

    }
  
  
}
