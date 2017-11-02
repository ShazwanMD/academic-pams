import { ChangeDetectionStrategy, Component, Input, OnInit, ViewContainerRef } from '@angular/core';
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { TermModuleState } from '../../index';
import { Store } from '@ngrx/store';
import { EnrollmentApplication } from '../../../../shared/model/term/enrollment-application.interface';
import { EnrollmentApplicationItem } from '../../../../shared/model/term/enrollment-application-item.interface';
import { EnrollmentApplicationItemEditorDialog } from '../dialog/enrollment-application-item-editor.dialog';
import { EnrollmentApplicationActions } from '../enrollment-application.action';
import { AdminEnrollmentApplicationItemEditorDialog } from "../dialog/admin-enrollment-application-item-editor.dialog";

@Component( {
    selector: 'pams-enrollment-application-item-list',
    templateUrl: './enrollment-application-item-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class EnrollmentApplicationItemComponent implements OnInit {

    private editorDialogRef: MdDialogRef<AdminEnrollmentApplicationItemEditorDialog>;
    private selectedRows: EnrollmentApplicationItem[];
    private _snackBar: MdSnackBar;

    private columns: any[] = [
        { name: 'section.offering.academicSession.code', label: 'Academic Session' },
        { name: 'section.ordinal', label: 'Section' },
        { name: 'section.code', label: 'Code' },
        { name: 'section.offering.titleEn', label: 'Title' },
        { name: 'section.offering.course.credit', label: 'Credit' },
        { name: 'action', label: 'Action' },
    ];

    @Input() enrollmentApplication: EnrollmentApplication;
    @Input() enrollmentApplicationItems: EnrollmentApplicationItem[];

    constructor( private router: Router,
        private route: ActivatedRoute,
        private actions: EnrollmentApplicationActions,
        private store: Store<TermModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog,
        private snackBar: MdSnackBar,) {
        
        this._snackBar = snackBar;
    }

    ngOnInit(): void {
        this.selectedRows = this.enrollmentApplicationItems.filter(( value ) => value.selected );
    }

    filter(): void {
    }

    selectRow( item: EnrollmentApplicationItem ): void {
    }

    selectAllRows( items: EnrollmentApplicationItem[] ): void {
    }

    delete( item: EnrollmentApplicationItem ): void {
        this.store.dispatch( this.actions.deleteEnrollmentApplicationItem( this.enrollmentApplication, item ) );
    }

    createDialog(): void {
        console.log( 'show Dialog EnrollmentApplicationItem' );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '50%';
        config.height = '40%';
        config.position = { top: '0px' };
        this.editorDialogRef = this.dialog.open( AdminEnrollmentApplicationItemEditorDialog, config );
        this.editorDialogRef.componentInstance.enrollmentApplication = this.enrollmentApplication;

        // close
        this.editorDialogRef.afterClosed().subscribe(( res ) => {
            // do something
        } );
    }
    
 /*   //click register button 
    register() {   
        
        var r = confirm("Please choose your course first before submit the application.Thank you.");
        if (r == true) {
            
            let snackBarRef = this._snackBar.open( 'Enrollment application completed', 'OK' );
            snackBarRef.afterDismissed().subscribe(() => {
                this.router.navigate( ['/secure'] );
            } );
           
        } else {
            let snackBarRef = this._snackBar.open( 'Please choose courses to enroll', 'OK', {duration:2000} );
            snackBarRef.afterDismissed().subscribe(() => {
                //this.router.navigate( ['/secure'] );
            } );
        }
        
          
    }*/
    
    register() {
       // this.store.dispatch( this.actions.completeEnrollmentApplicationTask( this.enrollmentApplicationTask ) );
        this.goBack();
    }
    
    goBack(): void {
        this.router.navigate( ['/secure/term/enrollment-applications/student-enrollment-center'] );
    }
}
