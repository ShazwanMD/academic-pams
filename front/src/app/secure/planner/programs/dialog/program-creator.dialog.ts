import {MdSnackBar} from '@angular/material/snack-bar';
import {Faculty} from '../../../../shared/model/planner/faculty.interface';
import {Program} from '../../../../shared/model/planner/program.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {ProgramActions} from '../program.action';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';
import {ProgramStatus} from '../../../../shared/model/planner/program-status.enum';

@Component({
  selector: 'pams-program-creator',
  templateUrl: './program-creator.dialog.html',
})

export class ProgramCreatorDialog implements OnInit {
  private creatorForm: FormGroup;
  private create: boolean = false;
  private _program: Program;
  private faculty: Faculty;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: ProgramActions,
              private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private snackBar: MdSnackBar,
              private dialog: MdDialogRef<ProgramCreatorDialog>) {
  }

  set program(value: Program) {
    this._program = value;
    this.create = true;
  }

  ngOnInit(): void {
    this.creatorForm = this.formBuilder.group({
      id: null,
      code: ['', Validators.required],
      titleMs: ['', Validators.required],
      titleEn: ['', Validators.required],
      status: [ProgramStatus.INACTIVE, Validators.required],
      faculty: ['', Validators.required],
      level: ['', Validators.required],
      //status: ProgramStatus.INACTIVATED,

      //faculty: <Faculty>{},
      //level: <ProgramLevel>{},
    });

    if (this.create) this.creatorForm.patchValue(this._program);
  }

  submit(program: Program, isValid: boolean) {
    console.log('adding program');
    if (!program.id) this.store.dispatch(this.actions.saveProgram(program));
    else this.store.dispatch(this.actions.updateProgram(program));
    this.dialog.close();
    console.log(program);

    let snackBarRef = this.snackBar.open( 'New Programs: ' + program.code + ' has been saved', '', { duration: 3000 } );
    snackBarRef.afterDismissed().subscribe(() => {
       } );
  }
}
