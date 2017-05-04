import { Program } from './../planner/programs/program.interface';
import { Faculty } from './../planner/faculties/faculty.interface';
import { PlannerService } from './../../services/planner.service';
import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";

// import {ProfileModuleState} from "./index";
@Component({
  selector: 'pams-test1',
  templateUrl: 'test1.page.html',
})

export class test1Page implements OnInit {
 private programCode$:Observable<Program[]>;
 constructor(private plannerService: PlannerService,
  ) {
  }

private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'titleEn', label: 'Title'},
    {name: 'action', label: 'Action'}
  ];

 ngOnInit(): void   {
   this.programCode$ = this.plannerService.findPrograms();
   
  }
}