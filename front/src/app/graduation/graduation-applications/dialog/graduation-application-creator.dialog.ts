import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {GraduationModuleState} from "../../index";
import {GraduationApplicationActions} from "../graduation-application.action";
import {GraduationApplication} from "../../../shared/model/graduation/graduation-application.interface";
import {Student} from "../../../shared/model/identity/student.interface";
import {AcademicSession} from "../../../shared/model/planner/academic-session.interface";

@Component({
  selector: 'pams-graduation-application',
  templateUrl: './graduation-application-creator.dialog.html',
})

export class GraduationApplicationCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<GraduationModuleState>,
              private actions: GraduationApplicationActions,
              private dialog: MdDialogRef<GraduationApplicationCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<GraduationApplication>{
      referenceNo:'',
      sourceNo: '',
      description: '',
      memo: '',
      cgpa: 0.00,
      creditHour: 0,
      student:<Student>{},
      academicSession: <AcademicSession>{},
    });
  }

  save(graduationApplicationCreator: GraduationApplication, isValid: boolean) {
    this.store.dispatch(this.actions.startGraduationApplicationTask(graduationApplicationCreator));
    this.dialog.close();
  }

}
