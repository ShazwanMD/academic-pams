import { Component, Input, OnInit, ViewContainerRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from '@angular/material';
import { GraduationApplicationTask } from '../../../../shared/model/graduation/graduation-application-task.interface';
import { GraduationApplicationActions } from '../graduation-application.action';
import { Store } from '@ngrx/store';
import { GraduationModuleState } from '../../index';
import { GraduationApplicationEditorDialog } from '../dialog/graduation-application-editor.dialog';
import { GraduationService } from "../../../../../services/graduation.service";
import {GraduationApplication} from '../../../../shared/model/term/graduation-application.interface';

@Component( {
    selector: 'pams-student-graduation-application-draft-task',
    templateUrl: './student-graduation-application-draft-task.panel.html',
} )

export class StudentGraduationApplicationDraftTaskPanel implements OnInit {


    //@Input() graduationApplicationTask: GraduationApplicationTask;
    @Input() graduationApplication: GraduationApplication;
    
    private editorDialogRef: MdDialogRef<GraduationApplicationEditorDialog>;
    private _route: ActivatedRoute;
    private _graduationService: GraduationService;
    private _snackBar: MdSnackBar;
    private _viewContainerRef: ViewContainerRef;
    private _dialog: MdDialog;
    private graduationApplicationTask: GraduationApplicationTask = <GraduationApplicationTask>{};

    constructor( private router: Router,
        private route: ActivatedRoute,
        private viewContainerRef: ViewContainerRef,
        private actions: GraduationApplicationActions,
        private store: Store<GraduationModuleState>,
        graduationService: GraduationService,
        private dialog: MdDialog,
        private vcf: ViewContainerRef,
        private snackBar: MdSnackBar ) {

        this._route = route;
        this._graduationService = graduationService;
        this._snackBar = snackBar;
        this._viewContainerRef = viewContainerRef;
        this._dialog = dialog;
    }

    ngOnInit(): void {
        this._route.params.subscribe(( params: { taskId: string } ) => {
            let taskId: string = params.taskId;
            // ngrx
        } );
    }

    /*register() {
      this.store.dispatch(this.actions.completeGraduationApplicationTask(this.graduationApplicationTask));
      this.goBack();
    }*/

    register(): void {
        this._graduationService.studentCompleteGraduationApplicationTask( this.graduationApplicationTask ).subscribe(( res ) => {
            let snackBarRef = this._snackBar.open( 'Graduation application completed', 'OK' );
            snackBarRef.afterDismissed().subscribe(() => {
                this.goBack();
            } );
        } );
    }

    remove() {

        var txt;
        var r = confirm( "Are you sure to remove this  application?" );
        if ( r == true ) {
            this.store.dispatch( this.actions.releaseGraduationApplicationTask( this.graduationApplicationTask ) );
            let snackBarRef = this._snackBar.open( 'Graduation application has been released', 'OK', {duration: 3000,}  );
            snackBarRef.afterDismissed().subscribe(() => {
                this.goBack();
            } );
           
        } else {
            let snackBarRef = this._snackBar.open( 'Release graduation application has been cancelled', 'OK', {duration: 3000,} );
            snackBarRef.afterDismissed().subscribe(() => {
                this.goBack();
            } );
        }
    }


    goBack(): void {
        this.router.navigate( ['secure/graduation/graduation-applications/student-graduation-application-center'] );
    }

   /* showDialog(): void {
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '50%';
        config.height = '40%';
        config.position = { top: '65px' };
        this.creatorDialogRef = this.dialog.open( GraduationApplicationEditorDialog, config );
        this.creatorDialogRef.componentInstance.application = this.graduationApplicationTask.application;

        // close
        this.creatorDialogRef.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog' );
            // load something here
        } );
    }*/
    
    showDialog(): void {
        console.log('open graduation app update dialog');
        console.log(this.graduationApplicationTask.id);
        let config = new MdDialogConfig();
        config.viewContainerRef = this._viewContainerRef;
        config.role = 'dialog';
        config.width = '60%';
        config.height = '50%';
        config.position = {top: '0px'};
        this.editorDialogRef = this._dialog.open(GraduationApplicationEditorDialog, config);
        this.editorDialogRef.componentInstance.graduationApplication = this.graduationApplicationTask.application;
      }

}
