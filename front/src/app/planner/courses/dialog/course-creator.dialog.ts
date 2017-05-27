import {Course} from './../course.interface';
import {Faculty} from './../../faculties/faculty.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {CourseActions} from "../course.action";
;
import {Store} from "@ngrx/store";
import {PlannerModuleState} from "../../index";
import {MdDialogRef} from "@angular/material";
import {CourseStatus} from "../course-status.enum";

@Component({
  selector: 'pams-course-creator',
  templateUrl: './course-creator.dialog.html',
})

export class CourseCreatorDialog implements OnInit {

  private creatorForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: CourseActions,
              private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CourseCreatorDialog>) {
  }

  ngOnInit(): void {
    this.creatorForm = this.formBuilder.group(<Course>{
      id: null,
      code: '',
      titleMs: '',
      titleEn: '',
      status: CourseStatus.INACTIVATED,
      faculty: <Faculty>{},
    });
  }

  submit(course: Course, isValid: boolean) {
    console.log(JSON.stringify(course));
    this.store.dispatch(this.actions.saveCourse(course));
    this.dialog.close();
  }
}
