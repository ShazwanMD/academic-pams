import { ChangeDetectionStrategy, Component, Input, ViewContainerRef } from '@angular/core';
import { GraduationApplication } from '../../../../shared/model/graduation/graduation-application.interface';
import { MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar } from '@angular/material';
import { Store } from '@ngrx/store';
import { GraduationModuleState } from '../../index';
import { GraduationApplicationActions } from "../graduation-application.action";
import { GraduationApplicationEditorDialog } from "../dialog/graduation-application-editor.dialog";

@Component( {
    selector: 'pams-graduation-application-action',
    templateUrl: './graduation-application-action.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class GraduationApplicationActionComponent {

    private editorDialogRef: MdDialogRef<GraduationApplicationEditorDialog>;

    @Input() graduationApplication: GraduationApplication;

    constructor( private actions: GraduationApplicationActions,
        private store: Store<GraduationModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog,
        private snackBar: MdSnackBar ) {

    }

    updateDialog(): void {
        console.log( 'open graduationApplication dialog' );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '60%';
        config.height = '50%';
        config.position = { top: '0px' };
        this.editorDialogRef = this.dialog.open( GraduationApplicationEditorDialog, config );
        this.editorDialogRef.componentInstance.graduationApplication = this.graduationApplication;

        // set
        this.editorDialogRef.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog graduationApplication update' );

        } );
    }

}
