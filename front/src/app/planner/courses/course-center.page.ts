import {CourseCreatorDialog} from './dialog/course-creator.dialog';
import { CourseActions } from './course.action';
import { Course } from '../../shared/model/planner/course.interface';
import {Router, ActivatedRoute} from '@angular/router';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {MdDialogRef} from '@angular/material';
import {MdDialogConfig} from '@angular/material';
import {MdDialog} from '@angular/material';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {PlannerModuleState} from '../index';

@Component({
  selector: 'pams-course-center',
  templateUrl: './course-center.page.html',
})

export class CourseCenterPage implements OnInit {

  private COURSES: string[] = 'plannerModuleState.courses'.split('.');
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
  viewCourse(course: Course) {
    console.log('course: ' + course.code);
    this.router.navigate(['./courses-detail', course.code]);
  }

  ngOnInit(): void {
    console.log('find courses');
    this.store.dispatch(this.actions.findCourses());
  }

  createDialog(): void {
    this.showDialog(null);
  }

  private showDialog(code: Course): void {
    console.log('save');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '70';
    config.position = {top: '1px'};
    this.creatorDialogRef = this.dialog.open(CourseCreatorDialog, config); if (code) this.creatorDialogRef.componentInstance.course = code; ;
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

   goBack(route: string): void {
    this.router.navigate(['/courses']);
   }

  filter(): void {
  }

}

