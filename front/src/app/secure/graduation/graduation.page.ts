import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component( {
    selector: 'pams-graduation-page',
    templateUrl: './graduation.page.html',
} )

export class GraduationPage implements OnInit {

    today: number = Date.now();

    constructor( private router: Router,
        private route: ActivatedRoute ) {
    }

    ngOnInit(): void {
        this.route.params.subscribe(() => {
        } );
    }
}
