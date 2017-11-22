import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Section} from '../../../../shared/model/term/section.interface';
import {EnrollmentApplicationItem} from '../../../../shared/model/term/enrollment-application-item.interface';
import {EnrollmentApplicationAction} from '../../../../shared/model/term/enrollment-application-action.enum';
import {TermModuleState} from '../../index';
import {EnrollmentApplicationActions} from '../enrollment-application.action';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';
import { Observable } from "rxjs/Observable";
import { AdmissionApplicationConfirmDialog } from "../../admission-applications/dialog/admission-application-confirm.dialog";

@Component({
  selector: 'pams-enrollment-application-item-editor',
  templateUrl: './enrollment-application-item-editor.dialog.html',
})

export class EnrollmentApplicationItemEditorDialog implements OnInit {

  private ENROLLMENT_APPLICATION_ITEM: string[] = 'termModuleState.enrollmentApplicationItem'.split( '.' );
  private enrollmentApplicationItem$: Observable<EnrollmentApplicationItem[]>;
    
  private editForm: FormGroup;
  private _enrollmentApplicationItem: EnrollmentApplicationItem;
  private _enrollmentApplication: EnrollmentApplication;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private snackBar: MdSnackBar,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<TermModuleState>,
              private actions: EnrollmentApplicationActions,
              private dialog: MdDialogRef<EnrollmentApplicationItemEditorDialog>) {
      
      this.enrollmentApplicationItem$ = this.store.select( ...this.ENROLLMENT_APPLICATION_ITEM );

  }

  set enrollmentApplication(value: EnrollmentApplication) {
    this._enrollmentApplication = value;
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
    if (this.edit) this.editForm.patchValue(this._enrollmentApplicationItem);
  }

  save(item: EnrollmentApplicationItem, isValid: boolean) {
    
    console.log('this._enrollmentApplicationItem', this._enrollmentApplicationItem);
    console.log('save student enrollmentApplication', this._enrollmentApplication);
    this.store.dispatch(this.actions.addStudentEnrollmentApplicationItem(this._enrollmentApplication, item));
    this.dialog.close();
    
     
    //alert by snackbar if duplicate
    console.log( "Test subscribe:", this.enrollmentApplicationItem$.subscribe( val => { val['status'] } ) );
    this.enrollmentApplicationItem$.subscribe( val => console.log( 'Accumulated object display:', val['status'] ) );

    this.enrollmentApplicationItem$.subscribe( val => {
        if ( val['status'] == 'Duplicate' ) {

            let snackBarRef = this.snackBar.open( 'Duplicate data', 'OK', { duration: 2000 } );
            snackBarRef.afterDismissed().subscribe(() => {
                console.log( 'The snack-bar was dismissed' );
                console.log( 'Accumulated object:', val )
                val['status'] = '';
                try{
                    this.dialog.close(); 
                    
                } catch(ex){}  
                //this.router.navigate(['/secure']);
            } );

        } else {
            if ( val['status'] == 'success' ) {
                             
                //open dialog to confirm registration
                let snackBarRef = this.snackBar.open( 'Success data', 'OK', { duration: 2000 } );
                snackBarRef.afterDismissed().subscribe(() => {
                    console.log( 'The snack-bar was dismissed' );
                    console.log( 'Accumulated object:', val )
                    val['status'] = '';
                    try{
                        this.dialog.close(); 
                        
                    } catch(ex){}  
                    //this.router.navigate(['/secure']);
                } );
               
            }
        }
    }
    );
    
   //end validation duplicate status 
  
  }
}
