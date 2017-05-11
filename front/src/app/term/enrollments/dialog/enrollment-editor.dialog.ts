import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {TermService} from "../../../../services/term.service";
import {Enrollment} from "../enrollment.interface";
import {EnrollmentActions} from "../enrollment.action";
import {MdDialog} from '@angular/material';


@Component({
  selector: 'pams-enrollment-editor',
  templateUrl: './enrollment-editor.dialog.html',
})

export class EnrollmentEditorDialog implements OnInit {

  private enrollment: Enrollment;
  private editForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private actions: EnrollmentActions,
              public dialog: MdDialog,
              private viewContainerRef: ViewContainerRef) {
  }
  
  openDialog(): void {
      this.dialog.open(EnrollmentEditorDialog, {
        height: '50%', // can be px or %
        width: '60%', // can be px or %
      });
    }

  ngOnInit(): void {
   /* this.editForm = this.formBuilder.group(<Offering>{
      id: null,
      code: '',
     });

    this.editForm.patchValue(this.offering);*/
  }

  save(enrollment: Enrollment, isValid: boolean) {
    // do something
  }
}
