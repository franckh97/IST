import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  template: `
	<h1>{{title}}</h1>
	<nav>
   	<a routerLink="/cars">Rent a car</a>
   	<a routerLink="/getback">Get back a car</a>
	</nav>
	<a href="https://github.com/charroux/CarRental/blob/master/src/app/app.component.ts">Source code of the page</a>
	<a href="https://github.com/charroux/CarRental/blob/master/src/app/app-routing.module.ts">Related routing</a>
	<a href="https://github.com/charroux/CarRental/blob/master/src/app/app.module.ts">The main component with the declaration of the components</a>
   	<router-outlet></router-outlet><br>
   	<a href="https://github.com/charroux/CarRental/blob/master/src/app/car.service.ts">Service used in all components</a><br>
   	This service used:
   	<ul>
   		<li><a href="https://angular.io/guide/observables">An observable</a></li>
   		<li><a href="https://angular.io/guide/comparing-observables">A promise</a></li>
   	</ul>
	`
})

export class AppComponent {

  title = 'Car Rental Service';

}
