import { StaffAcademicEditorDialog } from './dialog/staff-academic-editor.dialog';
import { Router, ActivatedRoute } from '@angular/router';
import { ViewContainerRef } from '@angular/core';
import { SetupActions } from './../setup.action';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs/Observable';
import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { Staff } from '../../../shared/model/identity/staff.interface';
import { SetupModuleState } from '../index';
import { StaffActions } from '../../identity/staffs/staff.action';
import { MdDialog, MdDialogRef, MdDialogConfig } from '@angular/material';


@Component({
    selector: 'pams-staff-list-page',
    templateUrl: './staff-list.page.html',
})

export class StaffListPage implements OnInit {

    private STAFFS: string[] = "setupModuleState.staffs".split(".");
    private staffs$: Observable<Staff>;
    private creatorDialogRef: MdDialogRef<StaffAcademicEditorDialog>;

    private columns: any[] = [
        {name:'identityNo', label:'Staff No'},
        {name:'title', label:'Title'},
        {name:'name', label:'Name'},
        {name:'email', label:'Email'},
        { name: 'action', label: '' },
    ]

    constructor(private store: Store<SetupModuleState>,
        private actions: StaffActions,
        private setupactions: SetupActions,
        private vcf: ViewContainerRef,
        private router: Router,
        private route: ActivatedRoute,
        private dialog : MdDialog
    ) {
        this.staffs$ = this.store.select(...this.STAFFS);
    }

    ngOnInit() {
        this.store.dispatch(this.actions.findAcademicStaffs());
        this.store.dispatch(this.setupactions.changeTitle("Staffs"))
    }

    createDialog(): void {
        this.showDialog( null );
    }

    editDialog( staff: Staff ): void {
        this.showDialog( staff );
    }

    delete( staff: Staff ): void {
        var txt;
        var r = confirm( "Are you sure to deactive this staff?" );
        if ( r == true ) {
            txt = "Staff has been deactived!";
            this.store.dispatch( this.actions.deactiveStaffAcademic( staff ) )
        } else {
            txt = "Cancel deactive!";
        }
    }

    filter(): void {
    }

    goBack( route: string ): void {
        this.router.navigate( ['/secure/setup'] );
    }

    private showDialog( staff: Staff ): void {
        console.log( "create" );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '65%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open( StaffAcademicEditorDialog, config );
        if ( staff ) this.creatorDialogRef.componentInstance.staff = staff; // set
        this.creatorDialogRef.afterClosed().subscribe( res => {
            console.log( "close dialog" );
        } );
    }

}