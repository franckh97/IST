import 'rxjs/add/operator/switchMap';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

import { Car } from './car';
import { CarService } from './car.service';

@Component({
  selector: 'car-detail',
  templateUrl: './car-detail.component.html'
})
export class CarDetailComponent implements OnInit {

  car: Car;

  constructor(
    private carService: CarService,
    private route: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit(): void {
   // this.route.paramMap
   //    .switchMap((params: ParamMap) => this.carService.getCar(params.get('plateNumber')))
   //    .subscribe(car => this.car = car);
   //
      this.route.paramMap
      .switchMap((params: ParamMap) => this.carService.getCarWithObservable(params.get('plateNumber')))
      .subscribe(car => this.car = car);
  }

  rent(car): void {
    this.carService.rent(car).subscribe(car => this.car = car);
  }

  cancelRental(car): void {
    this.carService.getBack(car).subscribe(car => this.car = car);
  }

  goBack(): void {
    this.location.back();
  }
}
