import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators, FormControl} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Offering} from '../../../../shared/model/term/offering.interface';
import {OfferingActions} from '../offering.action';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {Store} from '@ngrx/store';
import {Course} from '../../../../shared/model/planner/course.interface';
import {Program} from '../../../../shared/model/planner/program.interface';
import {TermModuleState} from '../../index';
import {Observable} from 'rxjs/Observable';
import { PlannerModuleState } from "../../../planner/index";
import { CourseActions } from "../../../planner/courses/course.action";
import { PlannerService } from "../../../../../services/planner.service";

@Component({
  selector: 'pams-offering-editor',
  templateUrl: './offering-editor.dialog.html',
  styleUrls: ['./autocomplete.css']
  
})

export class OfferingEditorDialog implements OnInit {
    
  courseCtrl: FormControl;
  filteredCourses: any;
    
  private COURSES: string[] = 'plannerModuleState.courses'.split('.');
  private courses$: Observable<Course[]>;

  //@Input() placeholder: string;
  //@Input() innerFormControl: FormControl;

  private createForm: FormGroup;
  private _program: Program;
  private _course: Course;
  private _offering: Offering;
  private str: string;
  private OFFERINGS: string[] = 'termModuleState.offerings'.split('.');
  private OFFERING: string[] = 'termModuleState.offering'.split('.');
  private offerings$: Observable<Offering[]>;
  private offering$: Observable<Offering[]>;
  private strListCourse: Course[];
           
  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private snackBar: MdSnackBar,
              private plannerService: PlannerService,
              private actions: OfferingActions,
              private store2: Store<PlannerModuleState>,
              private actions2: CourseActions,
              public dialog: MdDialogRef<OfferingEditorDialog>) {
      
    this.offerings$ = this.store.select(...this.OFFERINGS);
    this.offering$ = this.store.select(...this.OFFERING);
    this.courses$ = this.store.select(...this.COURSES);
  
    this.courseCtrl = new FormControl();
    this.filteredCourses = this.courseCtrl.valueChanges
        .startWith(null)
        .map(name => this.filterCourses(name));

  }
  
  filterCourses(val: string) {
      this.courses$.subscribe(data => {
          this.strListCourse = data;
         });
      console.log("data account ", this.strListCourse.filter(s => s.titleEn.toLowerCase().indexOf(val.toLowerCase()) != -1));
      return val ? this.strListCourse.filter(s => (s.code + " " + s.titleEn).toLowerCase().indexOf(val.toLowerCase()) != -1) : this.strListCourse;
      
  }
     
  ngOnInit(): void {
    
    this.store.dispatch(this.actions2.findCourses());
      
    this.createForm = this.formBuilder.group({
      id: [undefined],
      code: [''],
      canonicalCode: [''],
      capacity: ['', Validators.required],
      titleMs: [''],
      titleEn: [''],
      academicSession: [undefined, Validators.required],
      course: [undefined, Validators.required],
      program: [undefined, Validators.required],
      courseCtrl: '',
    });
    
  }

  submit(offering: Offering, isValid: boolean): void {
    // workaround
    this._program = offering.program;
    this._course = offering.course;

    offering.canonicalCode = this._program.code + '-' + this._course.code;
    offering.code = this._course.code;
    offering.titleMs = this._course.titleMs;
    offering.titleEn = this._course.titleEn;

    this.store.dispatch(this.actions.saveOffering(this._program, this._course, offering));      
    this.dialog.close();
    
    console.log( "Test subscribe:", this.offering$.subscribe(val => {val ['status']}));
    this.offering$.subscribe( val => console.log( 'Accumulated object display:', val['status'] ) );
    
    this.offering$.subscribe(val => {
        if(val['status']== 'Duplicate'){
            
            let snackBarRef = this.snackBar.open('Duplicate data: ' + offering.code + ' Please insert new data', '', {duration:3000});
            snackBarRef.afterDismissed().subscribe(() => {
            console.log('The snack-bar was dismissed');
            console.log('Accumulated object:', val)
            val['status'] = '';
           }); 
            
        } else {
            if(val['status']== 'success'){
            window.alert('Success insert new data:');
            console.log('Accumulated object:', val)
            val['status'] = '';
            }
        }
    } 
  );
  
   }
}
