import {MdSnackBar} from '@angular/material/snack-bar';
import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {EnrollmentApplicationActions} from '../enrollment-application.action';
import {EnrollmentApplication} from '../../../../shared/model/term/enrollment-application.interface';
import {TermModuleState} from '../../index';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {Admission} from '../../../../shared/model/term/admission.interface';
import {EnrollmentApplicationType} from '../../../../shared/model/term/enrollment-application-type.enum';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'pams-enrollment-application-task-creator',
  templateUrl: './enrollment-application-task-creator.dialog.html',
})

export class EnrollmentApplicationTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;
  private _academicSession: AcademicSession;
  private _admission: Admission;
  private minLength: number = 3;

  constructor(private router: Router,
              private formBuilder: FormBuilder,
              private snackBar: MdSnackBar,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private actions: EnrollmentApplicationActions,
              private dialog: MdDialogRef<EnrollmentApplicationTaskCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      id: [null],
      description: ['', Validators.required],
      applicationType: [EnrollmentApplicationType.PRA, Validators.required],
      admission: ['', Validators.required],
      academicSession: ['', Validators.required],
      //auditNo: ['N/A'],
      //sourceNo: ['N/A'],
      //admission: [<Admission>{}, Validators.required],
      //academicSession: [<AcademicSession>{}, Validators.required],
      //description: ['',Validators.required, Validators.minLength( this.minLength )],

    });
  }

  save(enrollmentApplication: EnrollmentApplication, isValid: boolean): void {

    this._academicSession = enrollmentApplication.academicSession;
    this._admission = enrollmentApplication.admission;

    console.log('description: ' + enrollmentApplication.description);
    console.log('admission: ' + enrollmentApplication.admission.id);
    console.log('academicSession: ' + enrollmentApplication.academicSession.id);
    console.log(JSON.stringify(enrollmentApplication));
    this.store.dispatch(this.actions.startAdminEnrollmentApplicationTask(enrollmentApplication));
    this.dialog.close();

     let snackBarRef = this.snackBar.open( 'New Enrollment Application : ' + enrollmentApplication.admission.student.name + ' has been inserted', '', { duration: 3000 } );
     snackBarRef.afterDismissed().subscribe(() => {
       } );
  }
}

