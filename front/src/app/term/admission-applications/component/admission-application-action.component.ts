import { AdmissionApplicationTaskEditorDialog } from './../dialog/admission-application-task-editor.dialog';
import { Store } from '@ngrx/store';
import { ViewContainerRef, ChangeDetectionStrategy, Input, Component } from '@angular/core';
import { TermModuleState } from './../../index';
import { AdmissionApplicationActions } from './../admission-application.action';
import { MdDialogRef, MdDialogConfig, MdDialog } from '@angular/material';
import { AdmissionApplication } from './../admission-application.interface';

@Component({
    selector: 'pams-admission-application-action',
    templateUrl: './admission-application-action.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})

export class AdmissionApplicationActionComponent {

    @Input() admissionApplication: AdmissionApplication;
    private editorDialogRef: MdDialogRef<AdmissionApplicationTaskEditorDialog>;

    constructor(private actions: AdmissionApplicationActions,
        private store: Store<TermModuleState>,
        private vcf: ViewContainerRef,
        private dialog: MdDialog) {

    }

    editDialog(): void {
        console.log("edit application");
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '60%';
        config.height = '50%';
        config.position = { top: '0px' };
        this.editorDialogRef = this.dialog.open(AdmissionApplicationTaskEditorDialog, config);
        this.editorDialogRef.componentInstance.admissionApplication = this.admissionApplication;

        // set
        this.editorDialogRef.afterClosed().subscribe(res => {
            console.log("close dialog");
        });


    }



}
