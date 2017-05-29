import { CourseCreatorDialog } from './dialog/course-creator.dialog';
import { Component, OnInit, ChangeDetectionStrategy, ViewContainerRef } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {CourseEditorDialog} from './dialog/course-editor.dialog';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Course} from "./course.interface";
import {CourseActions} from "./course.action";
import {PlannerModuleState} from "../index";
import {CommonService} from '../../../services';
import {PlannerService} from './../../../services/planner.service';
import {MdDialogRef} from '@angular/material';
import {MdDialogConfig} from '@angular/material';
import {MdDialog} from '@angular/material';


@Component({
  selector: 'pams-course-center',
  templateUrl: './course-center.page.html',
})

export class CourseCenterPage implements OnInit {

  private COURSES: string[] = "plannerModuleState.courses".split(".");
  private courses$: Observable<Course[]>;
      private creatorDialogRef: MdDialogRef<CourseCreatorDialog>;
    

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CourseActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
            
        
    this.courses$ = this.store.select(...this.COURSES);
  }

  goBack(route: string): void {
    this.router.navigate(['/courses']);
  }

  viewCourse(course: Course) {
    console.log("course: " + course.id);
    this.router.navigate(['/courses-detail', course.id]); 
  }

   ngOnInit(): void {
    console.log("find course");
    this.store.dispatch(this.actions.findCourses());
   }

   createDialog(): void {
    this.showDialog(null);
   }

 filter(): void {
  }

    private showDialog(code: Course): void {
    console.log("save");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '70';
    config.position = {top: '1px'};
    this.creatorDialogRef = this.dialog.open(CourseCreatorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");

    });
  }
}

