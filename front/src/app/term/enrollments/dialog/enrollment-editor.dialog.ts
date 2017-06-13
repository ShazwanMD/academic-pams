import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {TermService} from "../../../../services/term.service";
import {Enrollment} from "../enrollment.interface";
import {EnrollmentActions} from "../enrollment.action";
import {MdDialog} from '@angular/material';
import { Section } from "../../sections/section.interface";
import { Store } from "@ngrx/store";
import { MdDialogRef } from "@angular/material";
import { EnrollmentStatus } from "../enrollment-status.enum";
import { TermModuleState } from "../../index";

@Component({
    selector: 'pams-enrollment-editor',
    templateUrl: './enrollment-editor.dialog.html',
})

export class EnrollmentEditorDialog implements OnInit {

    private editorForm: FormGroup;
    private _section: Section;
    private _enrollment: Enrollment;
    private edit: boolean = false;

    constructor(private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private store: Store<TermModuleState>,
        private actions: EnrollmentActions,
        private dialog: MdDialogRef<EnrollmentEditorDialog>,
        private viewContainerRef: ViewContainerRef) {
    }

    set section(value: Section) {
        this._section = value;
    }

    set enrollment(value: Enrollment) {
        this._enrollment = value;
        this.edit = true;
    }

   
    ngOnInit(): void {
        this.editorForm = this.formBuilder.group(<Enrollment>{
            id: null,
            enrollmentStatus: <EnrollmentStatus>{},

        });

        // set offering by default
        this.editorForm.patchValue({ 'section': this._section });
        if (this.edit) this.editorForm.patchValue(this._enrollment);
    }

    submit(enrollment: Enrollment, isValid: boolean) {
        console.log("enrollment", enrollment);
        console.log("section", this.section);
        console.log(this._section);
        console.log(this._enrollment);

        // set codes
        this.store.dispatch(this.actions.updateEnrollment(this._section, enrollment));
        this.dialog.close();
    }
}
