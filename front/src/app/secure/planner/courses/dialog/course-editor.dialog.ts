import {Faculty} from '../../../../shared/model/planner/faculty.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Course} from '../../../../shared/model/planner/course.interface';
import {CourseActions} from '../course.action';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import {PlannerModuleState} from '../../index';
import {Store} from '@ngrx/store';
import {CourseStatus} from '../../../../shared/model/planner/course-status.enum';

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
              private snackBar: MdSnackBar,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CourseEditorDialog>) {
  }

  set course(value: Course) {
    this._course = value;
    this.edit = true;
  }

  set faculty(value: Faculty) {
    this._faculty = value;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Course>{
      id: null,
      code: '',
      titleMs: '',
      titleEn: '',
      status: CourseStatus.NEW,
      // faculty:<Faculty>{},
      // classification: CourseClassification.NEW,
    });

    if (this.edit) this.editForm.patchValue(this._course);
  }

  submit(course: Course, isValid: boolean) {

    console.log(JSON.stringify(course));
    if (!course.id) this.store.dispatch(this.actions.saveCourse(course));
    else  this.store.dispatch(this.actions.updateCourse(course));
    let snackBarRef = this.snackBar.open( 'New Course: ' + course.code + ' has been updated', '', { duration: 3000 } );
    snackBarRef.afterDismissed().subscribe(() => {
   } );
    this.dialog.close();

  }
}

