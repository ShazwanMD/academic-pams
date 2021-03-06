import {Cohort} from '../../../shared/model/planner/cohort.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {Student} from '../../../shared/model/identity/student.interface';
import {ProfileModuleState} from '../index';
import {ProfileActions} from '../profile.action';
import {StudyMode} from '../../../shared/model/common/study-mode.interface';
import {StudentStatus} from '../../../shared/model/profile/student-status.enum';

@Component({
  selector: 'pams-study-mode-switcher',
  templateUrl: './study-mode-switcher.dialog.html',
})

export class StudyModeSwitcherDialog implements OnInit {

  private switchForm: FormGroup;
  private _student: Student;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<StudyModeSwitcherDialog>,
              private store: Store<ProfileModuleState>,
              private actions: ProfileActions) {
  }

  set student(value: Student) {
    this._student = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.switchForm = this.formBuilder.group(<Student>{
      id: null,
      identityNo: '',
      name: '',
      email: '',
      phone: '',
      mobile: '',
      fax: '',
      studyMode: <StudyMode>{},
      cohort: <Cohort>{},
      studentStatus: <StudentStatus>{},
      memo: '',
    });

    console.log('patching values : ' + JSON.stringify(this._student.studyMode));
    this.switchForm.patchValue({'from': this._student.studyMode});
    if (this.edit) this.switchForm.patchValue(this._student);

  }

  switch(student: Student, isValid: boolean) {
    console.log(student);
    console.log('StudyMode:{}' + student.studyMode);
    this.store.dispatch(this.actions.updateStudent(student));
    this.dialog.close();
  }
}
