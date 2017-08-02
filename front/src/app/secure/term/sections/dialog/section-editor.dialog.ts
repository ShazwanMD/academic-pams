import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {TermModuleState} from '../../index';
import {Section} from '../../../../shared/model/term/section.interface';
import {SectionActions} from '../section.action';
import {Offering} from '../../../../shared/model/term/offering.interface';
import {ActivatedRoute, Router} from '@angular/router';
import { Observable } from "rxjs/Observable";

@Component({
  selector: 'pams-section-editor',
  templateUrl: './section-editor.dialog.html',
})

export class SectionEditorDialog implements OnInit {

  private SECTION: string[] = 'termModuleState.section'.split('.');
  private section$: Observable<Section[]>;
    
  private _section: Section;
  private _offering: Offering;
  private editorForm: FormGroup;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: SectionActions,
              private snackBar: MdSnackBar,
              private dialog: MdDialogRef<SectionEditorDialog>,
              private viewContainerRef: ViewContainerRef) {
      
      this.section$ = this.store.select(...this.SECTION);
  }

  set offering(value: Offering) {
    this._offering = value;

  }

  set section(value: Section) {
    this._section = value;
    this.edit = true;

  }

  ngOnInit(): void {
      
      //this.store.dispatch(this.actions.findSections());   
      
      this.editorForm = this.formBuilder.group({
      id: undefined,
      code: '',
      canonicalCode: '',
      capacity: ['', Validators.required],
      ordinal: ['', Validators.required],
      offering: ['', Validators.required],
      //offering: <Offering>{},
    });

    // set offering by default
    this.editorForm.patchValue({'offering': this._offering});
    if (this.edit) this.editorForm.patchValue(this._section);
  }

  submit(section: Section, isValid: boolean): void {
    // set codes
    section.canonicalCode = this._offering.canonicalCode + '' + section.ordinal;
    section.code = this._offering.code + '' + section.ordinal;

    if (!section.id){
    
      this.store.dispatch(this.actions.addSection(this._offering, section));
      this.section$.subscribe( val => console.log( 'Accumulated object section:', val['status'] ) );
      this.dialog.close();
         
     //start subscribe
      this.section$.subscribe(val => {
          if(val['status']== 'Duplicate'){
             console.log('Accumulated object:', val) 
             window.alert('Duplicate new data');
             
              
          }else{
              if(val['status']== 'success'){
              window.alert('Success insert new data:');
              console.log('Accumulated object:', val)
              val['status'] = '';
              }
          }
      }
      
      
      );
     //end subscribe
     
      
    } else { 
     
      this.store.dispatch(this.actions.updateSection(this._offering, section));
      this.dialog.close();

    }  
   }
}
