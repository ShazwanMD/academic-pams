import { CountryCode } from '../../../shared/model/common/country-code.interface';
import { StateCode } from '../../../shared/model/common/state-code.interface';
import { AdmissionApplication } from '../../../shared/model/term/admission-application.interface';
import {MdSnackBar} from '@angular/material/snack-bar';
import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { MdDialogRef } from '@angular/material';
import { Student } from '../../../shared/model/identity/student.interface';
import { ProfileModuleState } from '../index';
import { ProfileActions } from '../profile.action';
import { AddressType } from '../../../shared/model/profile/address-type.enum';
import { Admission } from "../../../shared/model/term/admission.interface";

@Component( {
    selector: 'pams-advisory-editor',
    templateUrl: './advisory-editor.dialog.html',
} )

export class AdvisoryEditorDialog implements OnInit {

    private editorForm: FormGroup;
    private edit: boolean = false;
    private _student: Student;

    private _admissionApplication: AdmissionApplication;
    private _admission: Admission;
    private stateCode: StateCode;

    constructor( private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private viewContainerRef: ViewContainerRef,
        private snackBar: MdSnackBar,
        private dialog: MdDialogRef<AdvisoryEditorDialog>,
        private store: Store<ProfileModuleState>,
        private actions: ProfileActions ) {
    }

    set student( value: Student ) {
        this._student = value;
    }

    set admissionApplication( value: AdmissionApplication ) {
        this._admissionApplication = value;
        this.edit = true;
    }
    
    set admission( value: Admission) {
        this._admission = value;
        this.edit = true;
    }

    ngOnInit(): void {
        this.editorForm = this.formBuilder.group( {
            id: [undefined],
            //advisor: ['', Validators.required],
            advisor: [undefined, Validators.required],

        } );

        //if ( this.edit ) this.editorForm.patchValue( this._admissionApplication );
        if ( this.edit ) this.editorForm.patchValue( this._admission );
    }

    /*submit( admissionApplication: AdmissionApplication, isValid: boolean ) {
        
        if (isValid)
            admissionApplication.id = this._admissionApplication.id;
        
        if ( isValid )
           this.store.dispatch( this.actions.updateAdmissionApplication( this._student, admissionApplication ) );
        console.log( admissionApplication );
        console.log( this._student );
       
        window.alert( this._admissionApplication.academicSession.code + ", " + this._student.name + "is saved" );
        
        this.dialog.close();
        
        let snackBarRef = this.snackBar.open( 'New advisor has been assigned', '', { duration: 3000 } );
        snackBarRef.afterDismissed().subscribe(() => {
       } );
            
    }  */
    
   submit( admission: Admission, isValid: boolean ) {
        
        if (isValid)
            admission.id = this._admission.id;
        
        if ( isValid )
           this.store.dispatch( this.actions.updateAdmission( this._student, admission ) );
        console.log( admission );
        console.log( this._student );
       
        /*window.alert( this._admissionApplication.academicSession.code + ", " + this._student.name + "is saved" );*/
        
        this.dialog.close();
        
        let snackBarRef = this.snackBar.open( 'New advisor has been assigned', '', { duration: 3000 } );
        snackBarRef.afterDismissed().subscribe(() => {
       } );
            
    }  
    
 }


        /*if (isValid)
            _admissionApplication.id = this._admissionApplication.id;
        console.log(admissionApplication);
    
        if (isValid) this.store.dispatch(this.actions.updateAddress(this._student, address));
        else this.store.dispatch(this.actions.addAddress(this._student, address));
        this.dialog.close();*/
    

