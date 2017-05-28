import {Guardian} from './../guardian.interface';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {Student} from "../../identity/student.interface";
import {ProfileModuleState} from "../index";
import {ProfileActions} from "../profile.action";
import {GuardianType} from "../guardian-type.enum";
import {AcademicSession} from "../../planner/academic-sessions/academic-session.interface";
import {StudyMode} from "../../common/study-modes/study-mode.interface";
import {SwitchStudyMode} from "../switch-study-mode.interface";

@Component({
  selector: 'pams-study-mode-switcher',
  templateUrl: './study-mode-switcher.dialog.html',
})

export class StudyModeSwitcherDialog implements OnInit {

  private switchForm: FormGroup;
  private _student: Student;

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
  }

  ngOnInit(): void {
    this.switchForm = this.formBuilder.group(<SwitchStudyMode>{
      from: <StudyMode>{},
      to: <StudyMode>{},
      academicSession: <AcademicSession>{}
    });

    console.log("patching values : " + JSON.stringify(this._student.studyMode));
    this.switchForm.patchValue({"from": this._student.studyMode});

  }

  switch(switcher: SwitchStudyMode): void {
    console.log(JSON.stringify(switcher));
    this.store.dispatch(this.actions.switchStudyMode(this._student, switcher));
    this.dialog.close();
  }
}
