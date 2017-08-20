import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthorizationService} from '../../services/authorization.service';

@Component({
  selector: 'pams-lecturer-dashboard-panel',
  templateUrl: './lecturer-dashboard.panel.html',
})

export class LecturerDashboardPanel implements OnInit {

  private items: Object[];

  constructor(private router: Router,
              private  route: ActivatedRoute,
              private authz: AuthorizationService) {
  }

  ngOnInit(): void {
    {
      this.items = [
        {
        title: 'Profile',
        route: '/secure/profile',
        icon: 'contacts',
        color: 'blue-700',
        description: '',
      },

      ];
    }
  }
}
