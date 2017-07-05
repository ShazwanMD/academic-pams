import {Curriculum} from '../../curriculums/curriculum.interface';
import {CourseClassification} from '../course-classification.enum';
import { CourseClassificationComponent } from './../component/course-classification.component';
import {Course} from './../course.interface';
import {Faculty} from './../../faculties/faculty.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {CourseActions} from "../course.action";
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
  private create: boolean = false;
  private _course:Course;
  private faculty: Faculty;
  private _curriculum: Curriculum;


  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: CourseActions,
              private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CourseCreatorDialog>) {
  }


  set curriculum(value:Curriculum){
  this._curriculum= value;
}
   set course(value: Course) {
        this._course = value;
        this.create = true;
    }




  ngOnInit(): void {
    this.creatorForm = this.formBuilder.group(<Course>{
      id: null,
      code: '',
      titleMs: '',
      titleEn: '',
      classification: CourseClassification.LEVEL_100,
      status: CourseStatus.ACTIVE,
      faculty: <Faculty>{},
    });

    this.creatorForm.patchValue({'curriculum':this._curriculum});
   if (this.create) this.creatorForm.patchValue(this._course);
  }

  submit(course: Course, isValid: boolean) {
     console.log("adding course");
        if (!course.id) this.store.dispatch(this.actions.addCourse(course));
        else this.store.dispatch(this.actions.updateCourse(course));
        this.dialog.close();
        console.log(course);
  }

  
}
