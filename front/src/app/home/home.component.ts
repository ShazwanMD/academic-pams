import {Component, Output, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'pams-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})

export class HomeComponent implements OnInit {

  private items: Object[];

  constructor(private router: Router,
              private  route: ActivatedRoute) {
  }

  ngOnInit(): void {
    {
      this.items = [{
        title: 'Profile',
        route: '/profile',
        icon: 'contacts',
        color: 'blue-700',
        description: '',
      },
        {
          title: 'Planner',
          route: '/planner',
          icon: 'assignment',
          color: 'blue-700',
          description: '',
        }
        ,
        {
          title: 'Term',
          route: '/term',
          icon: 'description',
          color: 'blue-700',
          description: '',
        },
        /*{
          title: 'Graduation',
          route: '/graduation',
          icon: 'assignment',
          color: 'blue-700',
          description: '',
        },*/
       /* {
          title: 'Identities',
          route: '/identity',
          icon: 'assignment',
          color: 'blue-700',
          description: ' ',
        },*/
       /* {
          title: 'System',
          route: '/system',
          icon: 'assignment',
          color: 'blue-700',
          description: ' ',
        },*/
        {
          title: 'Setup',
          route: '/setup',
          icon: 'assignment',
          color: 'blue-700',
          description: ' ',
        },
        
      ];
    }
    ;
  }
}
