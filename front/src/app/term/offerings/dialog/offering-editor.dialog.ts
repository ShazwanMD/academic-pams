import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {TermService} from "../../../../services/term.service";
import {Offering} from "../offering.interface";
//import {Course} from "../../planner/courses/course.interface";
import {OfferingActions} from "../offering.action";
import {MdDialog} from '@angular/material';
import {MdDialogRef} from "@angular/material";
import {Store} from "@ngrx/store";
import {AcademicSession} from "../../../planner/academic-sessions/academic-session.interface";
import {Course} from "../../../planner/courses/course.interface";
import {Program} from "../../../planner/programs/program.interface";
import {TermModuleState} from "../../index";

@Component({
  selector: 'pams-offering-editor',
  templateUrl: './offering-editor.dialog.html',
})

export class OfferingEditorDialog implements OnInit {

  //private offering: Offering;
  private createForm: FormGroup;
  

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: OfferingActions,
              public dialog: MdDialogRef<OfferingEditorDialog>) {
  }
  
 
  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Offering>{
      id: null,
      code: '',
      canonicalCode: '',
      capacity: 0,
      titleMs:'',
      titleEn:'',
      academicSession:<AcademicSession>{},
      course: <Course>{},
      program: <Program>{},
        
    });

   // this.editForm.patchValue(this.offering);
  }

  submit(offering: Offering, isValid: boolean) {
      console.log(JSON.stringify(offering));
      this.store.dispatch(this.actions.saveOffering(offering));
      this.dialog.close();
    }
}

