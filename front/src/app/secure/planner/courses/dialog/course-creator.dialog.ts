import {MdSnackBar} from '@angular/material/snack-bar';
import { Curriculum } from '../../../../shared/model/planner/curriculum.interface';
import { CourseClassification } from '../../../../shared/model/planner/course-classification.enum';
import { Course } from '../../../../shared/model/planner/course.interface';
import { Faculty } from '../../../../shared/model/planner/faculty.interface';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CourseActions } from '../course.action';
import { Store } from '@ngrx/store';
import { PlannerModuleState } from '../../index';
import { MdDialogRef } from '@angular/material';

@Component( {
    selector: 'pams-course-creator',
    templateUrl: './course-creator.dialog.html',
} )

export class CourseCreatorDialog implements OnInit {

    private createForm: FormGroup;
    private create: boolean = false;
    private _course: Course;
    private faculty: Faculty;
    private _curriculum: Curriculum;
    private minLength: number = 1;

    constructor( private formBuilder: FormBuilder,
        private store: Store<PlannerModuleState>,
        private actions: CourseActions,
        private snackBar: MdSnackBar,
        /*private router: Router,
         private route: ActivatedRoute,
         private viewContainerRef: ViewContainerRef,*/
        private dialog: MdDialogRef<CourseCreatorDialog> ) {
    }

    set curriculum( value: Curriculum ) {
        this._curriculum = value;
    }

    set course( value: Course ) {
        this._course = value;
        this.create = true;
    }

    ngOnInit(): void {
        this.createForm = this.formBuilder.group( {
            id: [undefined],
            code: ['', Validators.required],
            titleMs: ['', Validators.required],
            titleEn: ['', Validators.required],
            credit:[0,Validators.required],
            classification: CourseClassification.LEVEL_100,
            status: ['', Validators.required],
            faculty: ['', Validators.required],
        } );

        this.createForm.patchValue( { 'curriculum': this._curriculum } );
        if ( this.create ) this.createForm.patchValue( this._course );
    }

    save( course: Course, isValid: boolean ) {
        console.log("save course");
        if ( !course.id ) this.store.dispatch( this.actions.saveCourse( course ) );
        else this.store.dispatch( this.actions.updateCourse( course ) );
        this.dialog.close();
        console.log( course );

       let snackBarRef = this.snackBar.open( 'New Courses: ' + course.code + ' has been saved', '', { duration: 3000 } );
       snackBarRef.afterDismissed().subscribe(() => {
       } );
    }

}
