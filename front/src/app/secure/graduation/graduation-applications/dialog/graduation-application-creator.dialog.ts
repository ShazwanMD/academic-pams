import {MdSnackBar} from '@angular/material/snack-bar';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {Validators, FormBuilder,  FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {GraduationModuleState} from '../../index';
import {GraduationApplicationActions} from '../graduation-application.action';
import {GraduationApplication} from '../../../../shared/model/graduation/graduation-application.interface';
import {Student} from '../../../../shared/model/identity/student.interface';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';

@Component({
  selector: 'pams-graduation-application-creator',
  templateUrl: './graduation-application-creator.dialog.html',
})

export class GraduationApplicationCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private snackBar: MdSnackBar,
              private store: Store<GraduationModuleState>,
              private actions: GraduationApplicationActions,
              private dialog: MdDialogRef<GraduationApplicationCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      referenceNo:  [''],
      sourceNo: [''],
      description: ['', Validators.required],
      memo:  ['', Validators.required],
      cgpa: [0.00],
      creditHour: [0],
      student:  ['', Validators.required],
      academicSession: ['', Validators.required],
    });
  }

  save(graduationApplicationCreator: GraduationApplication, isValid: boolean) {
    this.store.dispatch(this.actions.startGraduationApplicationTask(graduationApplicationCreator));
    this.dialog.close();
    this.router.navigate(['/secure/graduation/graduation-applications']);
    let snackBarRef = this.snackBar.open( 'New graduation has been saved','',{ duration: 2000 } );
    snackBarRef.afterDismissed().subscribe(() => {
       } );
  }
    
  }

