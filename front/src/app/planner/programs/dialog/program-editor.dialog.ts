import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {Program} from "../program.interface";
import {ProgramActions} from "../program.action";
import {MdDialog} from "@angular/material";



@Component({
  selector: 'pams-program-editor',
  templateUrl: './program-editor.dialog.html',
})

export class ProgramEditorDialog implements OnInit {

  private program: Program;
  private editForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private actions: ProgramActions,
              public dialog: MdDialog,
              private viewContainerRef: ViewContainerRef) {
  }

   openDialog(): void {

      this.dialog.open(ProgramEditorDialog, {
        height: '50%', // can be px or %
        width: '60%', // can be px or %
      });
    }
    
    // this.editForm = this.formBuilder.group(<Program>{
    //   id: null,
    //   code: '',
    //   title: '',
    //   titleMs: '',
    //   titleEn: '',
    // });

  //   this.editForm.patchValue(this.program);
  // }

    ngOnInit(): void {
    }

  save(program: Program, isValid: boolean) {
    // do something
  }
}
