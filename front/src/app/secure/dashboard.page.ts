import { FacultyDashboardPanel } from './faculty-dashboard.panel';
import { LecturerProfileCenterPage } from './lecturerPanel/lecturer-profile-center.page';
import { LecturerDashboardPanel } from './lecturer-dashboard.panel';
import { StudentProfileCenterPage } from './studentProfile/student-profile-center.page';
import { ProfileCenterPage } from './profile/profile-center.page';
import { ProfileDetailPage } from './profile/profile-detail.page';
import {
  Component,
  ComponentFactory,
  ComponentFactoryResolver,
  ComponentRef,
  OnDestroy,
  OnInit,
  ViewChild,
  ViewContainerRef
} from '@angular/core';
import { Router } from '@angular/router';
import { AuthorizationService } from '../../services/authorization.service';
import { AdministratorDashboardPanel } from './administrator-dashboard.panel';
import { StudentDashboardPanel } from './student-dashboard.panel';


@Component({
  selector: 'pams-dashboard',
  templateUrl: './dashboard.page.html',
})
export class DashboardPage implements OnInit, OnDestroy {

  private componentRef: ComponentRef<any>;
  @ViewChild('dashboardPanel', { read: ViewContainerRef }) dashboardPanel: ViewContainerRef;

  constructor(private authzService: AuthorizationService,
    private viewContainerRef: ViewContainerRef,
    private cfr: ComponentFactoryResolver,
    private router: Router) {
  }

  ngOnInit(): void {
    let componentFactory: ComponentFactory<any>;

    if (this.authzService.hasRole('ROLE_ADMINISTRATOR') && this.authzService.hasRole('ROLE_USER')) {
      componentFactory = this.cfr.resolveComponentFactory(AdministratorDashboardPanel);
    } else if (this.authzService.hasRole('ROLE_FACULTY') && this.authzService.hasRole('ROLE_USER')) {
      componentFactory = this.cfr.resolveComponentFactory(FacultyDashboardPanel);
    }

    else if (this.authzService.hasRole('ROLE_LECTURER') && this.authzService.hasRole('ROLE_USER')) {
      componentFactory = this.cfr.resolveComponentFactory(LecturerProfileCenterPage);
    }

    else if (this.authzService.hasRole('ROLE_USER')) {
      componentFactory = this.cfr.resolveComponentFactory(StudentProfileCenterPage);
    }


    // handle null factory
    if (componentFactory) {
      this.componentRef = this.dashboardPanel.createComponent(componentFactory);
    } else {
      this.router.navigate(['/login']);
    }
  }

  ngOnDestroy(): void {
    if (this.componentRef) {
      this.componentRef.destroy();
    }
  }
}
