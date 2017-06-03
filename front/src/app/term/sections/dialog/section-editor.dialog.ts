import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {TermModuleState} from "../../index";
import {Section} from "../section.interface";
import {SectionActions} from "../section.action";
import {Offering} from "../../offerings/offering.interface";
import {Router, ActivatedRoute} from '@angular/router';

@Component({
    selector: 'pams-section-editor',
    templateUrl: './section-editor.dialog.html',
})

export class SectionEditorDialog implements OnInit {

    private _section: Section; //section dibawa dari button click in list
    private _offering: Offering;
    private editorForm: FormGroup;
    private edit: boolean = false;

    constructor(private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private store: Store<TermModuleState>,
        private actions: SectionActions,
        private dialog: MdDialogRef<SectionEditorDialog>,
        private viewContainerRef: ViewContainerRef) {
    }

    set offering(value: Offering) {
        this._offering = value;
       
    }
    
    set section(value: Section) { //set value section yang dibawa
        this._section = value;
        this.edit = true;
       
    }

    ngOnInit(): void {
        this.editorForm = this.formBuilder.group(<Section>{
            id: null,
            code: '',
            canonicalCode: '',
            capacity: 0,
            ordinal: 0,
            offering: <Offering>{}
        });

        // set offering by default
        this.editorForm.patchValue({ 'offering': this._offering });
        if (this.edit) this.editorForm.patchValue(this._section);
        //console.log(this.section.canonicalCode);
    }
    
    submit(section: Section, isValid: boolean) {
        //console.log("section code:",this._section.code);
        //console.log("section code:",this._section.canonicalCode);
        //console.log(section);
        
        // set codes
        section.canonicalCode = this._offering.canonicalCode + "" + section.ordinal
        section.code = this._offering.code + "" + section.ordinal
        
        //console.log(section.canonicalCode);
        //console.log(section.code);
        
       
        if (!section.id)
            this.store.dispatch(this.actions.addSection(this._offering, section));
        else this.store.dispatch(this.actions.updateSection(this._offering, section));
        this.dialog.close();

    }
}
