import {ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {ProfileModuleState} from './../index';
import {ProfileActions} from './../profile.action';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {StudentInfoEditorDialog} from './../dialog/student-info-editor.dialog';
import {Enrollment} from './../../term/enrollments/enrollment.interface';
import {Contact} from './../contact.interface';
import {Guardian} from './../guardian.interface';
import {Guarantor} from './../guarantor.interface';
import {Address} from './../address.interface';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';
import {Student} from "../../identity/student.interface";

@Component({
  selector: 'pams-profile',
  templateUrl: 'profile.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ProfileComponent implements OnInit {
  @Input() profile: Student;
  @Input() addressess: Address[];
  @Input() guarantors: Guarantor[];
  @Input() guardians: Guardian[];
  @Input() contacts: Contact[];
  @Input() enrollments: Enrollment[];

  private creatorDialogRef: MdDialogRef<StudentInfoEditorDialog>;
  private columns: any[] = [
    {name: 'name', label: 'NAME'},
    {name: 'phone', label: 'PHONE'},
    {name: 'mobile', label: 'MOBILE'},
    {name: 'action', label: ''}
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProfileActions,
              private vcf: ViewContainerRef,
              private store: Store<ProfileModuleState>,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { identityNo: string }) => {
      let identityNo: string = params.identityNo;
      this.store.dispatch(this.actions.findStudentByMatricNo(identityNo));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/profiles']);
  }

  editStudent() {
    this.showDialog(this.profile)
  }

  private showDialog(student: Student): void {
    console.log("edit");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(StudentInfoEditorDialog, config);
    if (student) this.creatorDialogRef.componentInstance.student = this.profile; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}
