import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef } from '@angular/core';
import { EnrollmentApplication } from "../enrollment-application.interface";
import { MdDialog, MdDialogConfig, MdDialogRef } from "@angular/material";
import { ActivatedRoute, Router } from "@angular/router";
import { Store } from "@ngrx/store";
import { TermModuleState } from "../../index";
import { EnrollmentApplicationItem } from "../enrollment-application-item.interface";
import { EnrollmentApplicationItemEditorDialog } from "../dialog/enrollment-application-item-editor.dialog";

@Component( {
    selector: 'pams-student-enrollment-application-list',
    templateUrl: './student-enrollment-application-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,

} )
export class StudentEnrollmentApplicationListComponent {

    @Input() enrollmentApplication: EnrollmentApplication;
    @Input() enrollmentApplicationItems: EnrollmentApplicationItem[];
    @Output() view = new EventEmitter<EnrollmentApplication>();
    @Output() view2 = new EventEmitter<EnrollmentApplicationItem>();

    //display data enrollments
    private columns: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'action', label: '' }
    ];

    private creatorDialogRef: MdDialogRef<EnrollmentApplicationItemEditorDialog>;

    constructor( private router: Router,
        private route: ActivatedRoute,
        private store: Store<TermModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog ) {
    }

   /* showDialog(): void {
        console.log( "showDialog" );
        console.log( "enrollmentApplication to pass:" + this.enrollmentApplication );

        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '50%';
        config.height = '50%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open( EnrollmentApplicationItemEditorDialog, config );
        this.creatorDialogRef.componentInstance.enrollmentApplication = this.enrollmentApplication;
        this.creatorDialogRef.afterClosed().subscribe( res => {
            console.log( "close dialog" );
            // load something here
        } );
    }*/

}
