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
  selector: 'pams-confirmation',
  templateUrl: './confirmation.dialog.html',
})

export class ConfirmationDialog implements OnInit {

  private SECTIONS: string[] = 'termModuleState.offeringSections'.split('.');
  private sections$: Observable<Section[]>;
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
              private dialog: MdDialogRef<ConfirmationDialog>,
              private viewContainerRef: ViewContainerRef) {
      
      this.sections$ = this.store.select(...this.SECTIONS);
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
      
      this.store.dispatch(this.actions.findSections());   
      
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
    this.editorForm.patchValue({'section': this._section});
    if (this.edit) this.editorForm.patchValue(this._section);
  }

  deleteOK(): void {
      console.log( "section code",this._section.code );
      console.log( "section code",this._offering.code );
      this.store.dispatch( this.actions.deleteSection( this._offering, this._section ) );
      let snackBarRef = this.snackBar.open( 'Section:' + this._section.code + 'is deleted', 'OK', { duration: 3000 } );
      snackBarRef.afterDismissed().subscribe(() => {
          console.log( 'The snack-bar was dismissed' );
          this.dialog.close();
        } ); 
   
   }
  
  cancel(): void {
      let snackBarRef = this.snackBar.open( 'Cancel deleted', 'OK', { duration: 3000 } );
      snackBarRef.afterDismissed().subscribe(() => {
          console.log( 'The snack-bar was dismissed' );
          this.dialog.close();
          
        } ); 
  }
  
  goBack(){
      window.history.go(-1);
      
  }
}
