import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Section} from '../../../../shared/model/term/section.interface';
import {EnrollmentApplicationItem} from '../../../../shared/model/term/enrollment-application-item.interface';
import {EnrollmentApplicationAction} from '../../../../shared/model/term/enrollment-application-action.enum';
import {TermModuleState} from '../../index';
import {EnrollmentApplicationActions} from '../enrollment-application.action';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';

@Component({
  selector: 'pams-admin-enrollment-application-item-editor',
  templateUrl: './admin-enrollment-application-item-editor.dialog.html',
})

export class AdminEnrollmentApplicationItemEditorDialog implements OnInit {

  private editForm: FormGroup;
  private _enrollmentApplicationItem: EnrollmentApplicationItem;
  private _enrollmentApplication: EnrollmentApplication;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<TermModuleState>,
              private actions: EnrollmentApplicationActions,
              private dialog: MdDialogRef<AdminEnrollmentApplicationItemEditorDialog>) {

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
    console.log('enrollmentApplicationItem', item);
    console.log('this._enrollmentApplicationItem', this._enrollmentApplicationItem);
    console.log('save student enrollmentApplication', this._enrollmentApplication);
    this.store.dispatch(this.actions.addEnrollmentApplicationItem(this._enrollmentApplication, item));
    this.dialog.close();
    
     
    //alert by snackbar if duplicate
    /* console.log( "Test subscribe:", this.enrollmentApplicationItem$.subscribe( val => { val['status'] } ) );
      this.admissionApplication$.subscribe( val => console.log( 'Accumulated object display:', val['status'] ) );

    this.admissionApplication$.subscribe( val => {
        if ( val['status'] == 'Duplicate' ) {

            let snackBarRef = this.snackBar.open( 'Duplicate data: ' + admissionApplication.student.identityNo + ' Application has been submitted', '', { duration: 5000 } );
            snackBarRef.afterDismissed().subscribe(() => {
                console.log( 'The snack-bar was dismissed' );
                console.log( 'Accumulated object:', val )
                val['status'] = '';
                try{
                    this.dialog.closeAll(); 
                    
                } catch(ex){}  
                //this.router.navigate(['/secure']);
            } );

        } else {
            if ( val['status'] == 'success' ) {
                             
                //open dialog to confirm registration
                console.log('showDialog');
                let config = new MdDialogConfig();
                config.viewContainerRef = this.vcf;
                config.role = 'dialog';
                config.width = '60%';
                config.height = '50%';
                config.position = { top: '0px' };
                this.creatorDialogRefConfirm = this.dialog.open(AdmissionApplicationConfirmDialog, config);
                this.creatorDialogRefConfirm.componentInstance.admission = this._admission;
                this.creatorDialogRefConfirm.afterClosed().subscribe((res) => {
                    console.log('close dialog');
                    try{
                        this.dialog.closeAll(); 
                        
                    } catch(ex){}  
                    //router navigate to my profile
                    //this.router.navigate(['/secure']);
                    
                });
            }
        }
    }
    );
    */
   //end validation duplicate status 
  
  }
}
