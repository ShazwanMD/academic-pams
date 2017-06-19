import { Faculty } from '../../faculties/faculty.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Course} from "../course.interface";
import {CourseActions} from "../course.action";
import {MdDialogRef} from "@angular/material";
import {PlannerModuleState} from "../../index";
import {Store} from "@ngrx/store";
import {CourseStatus} from "../course-status.enum";

@Component({
  selector: 'pams-course-editor',
  templateUrl: './course-editor.dialog.html',
})

export class CourseEditorDialog implements OnInit {
  private _course: Course;
  private _faculty: Faculty;
  private editForm: FormGroup;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private actions: CourseActions,
              private store: Store<PlannerModuleState>,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CourseEditorDialog>) {
  }

  set course(value: Course) {
    this._course = value;
    this.edit = true;
  }
  
   set faculty (value: Faculty) {
    this._faculty = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Course>{
      id: null,
      code: '',
      titleMs: '',
      titleEn: '',
      status: CourseStatus.NEW,
     // classification: CourseClassification.NEW,
    });

    if (this.edit) this.editForm.patchValue(this._course);
  }

  submit(course: Course, isValid: boolean) {
    console.log(JSON.stringify(course));
    if (!course.id) this.store.dispatch(this.actions.saveCourse(course));
    else  this.store.dispatch(this.actions.updateCourse(course));
    this.dialog.close();

  }
}

