import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component( {
    selector: 'pams-planner-page',
    templateUrl: './planner.page.html',
} )

export class PlannerPage implements OnInit {

    today: number = Date.now();

    constructor( private router: Router,
        private route: ActivatedRoute ) {
    }

    ngOnInit(): void {
    }
}
