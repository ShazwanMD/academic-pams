import { PlannerService } from './../../services/planner.service';
import { Program } from './../planner/programs/program.interface';
import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";


@Component({
  selector: 'pams-abc',
  templateUrl: 'abc.page.html',
})

export class AbcPage implements OnInit{

  private programCode$:Observable<Program[]>;
  constructor(private plannerService: PlannerService,){

  }


 ngOnInit(): void {
    // console.log("find programs");
    this.programCode$= this.plannerService.findPrograms();
  }
}
