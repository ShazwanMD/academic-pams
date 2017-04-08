import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {TermService} from "../../../../services/term.service";
import {Section} from "../../sections/section.interface";
import {EnrollmentApplicationItem} from "../enrollment-application-item.interface";
import {EnrollmentApplicationAction} from "../enrollment-application-action.enum";


@Component({
  selector: 'pams-enrollment-item-editor',
  templateUrl: './enrollment-item-editor.dialog.html',
})

export class EnrollmentApplicationItemEditorDialog implements OnInit {

  private _router: Router;
  private _route: ActivatedRoute;
  private _identityService: IdentityService;
  private _commonService: CommonService;
  private _termService: TermService;
  private _formBuilder: FormBuilder;
  private _item: EnrollmentApplicationItem;
  private editForm: FormGroup;

  private selectedSection: Section;
  private sections: Section[] = <Section[]> [];

  constructor(router: Router,
              route: ActivatedRoute,
              formBuilder: FormBuilder,
              identityService: IdentityService,
              commonService: CommonService,
              termService: TermService,
              viewContainerRef: ViewContainerRef) {
    this._router = router;
    this._route = route;
    this._formBuilder = formBuilder;
    this._identityService = identityService;
    this._commonService = commonService;
    this._termService = termService;
  }

  set item(value: EnrollmentApplicationItem) {
    this._item = value;
  }

  ngOnInit(): void {
    this.editForm = this._formBuilder.group(<EnrollmentApplicationItem>{
      id: null,
      description: '',
      enrollmentNo:'',
      enrollmentDate:null,
      amount: 0,
      action:EnrollmentApplicationAction.ADD,
      section:null
    });

    this.editForm.patchValue(this._item);
  }

  // save(enrollment: Enrollment, isValid: boolean) {
  //   this.submitted = true; // set form submit to true
  //   this._enrollmentService.startEnrollmentTask(enrollment).subscribe(res => {
  //     let snackBarRef = this._snackBar.open("Enrollment started", "OK");
  //     snackBarRef.afterDismissed().subscribe(() => {
  //       this.goBack();
  //     });
  //   });
  // }

}
