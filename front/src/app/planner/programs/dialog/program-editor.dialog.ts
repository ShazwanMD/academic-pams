
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {Program} from "../program.interface";


@Component({
  selector: 'pams-program-editor',
  templateUrl: './program-editor.dialog.html',
})

export class ProgramEditorDialog implements OnInit {

  private _router: Router;
  private _route: ActivatedRoute;
  private _identityService: IdentityService;
  private _commonService: CommonService;
  private _plannerService: PlannerService;
  private _formBuilder: FormBuilder;
  private program: Program;
  private editForm: FormGroup;

  constructor(router: Router,
              route: ActivatedRoute,
              formBuilder: FormBuilder,
              identityService: IdentityService,
              commonService: CommonService,
              plannerService: PlannerService,
              viewContainerRef: ViewContainerRef) {
    this._router = router;
    this._route = route;
    this._formBuilder = formBuilder;
    this._identityService = identityService;
    this._commonService = commonService;
    this._plannerService = plannerService;
  }

  ngOnInit(): void {
    this.editForm = this._formBuilder.group(<Program>{
      id: null,
      code:'',
      title: '',
      titleMs:'',
      titleEn: '',
    });

    this.editForm.patchValue(this.program);
  }

  // save(invoice: Invoice, isValid: boolean) {
  //   this.submitted = true; // set form submit to true
  //   this._invoiceService.startInvoiceTask(invoice).subscribe(res => {
  //     let snackBarRef = this._snackBar.open("Invoice started", "OK");
  //     snackBarRef.afterDismissed().subscribe(() => {
  //       this.goBack();
  //     });
  //   });
  // }
}
