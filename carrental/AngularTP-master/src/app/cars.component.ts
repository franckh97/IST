import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


import { Car } from './car';
import { CarService } from './car.service';

@Component({
  selector: 'my-cars',
  templateUrl: './cars.component.html'
})

export class CarsComponent implements OnInit {

  title = 'Car Rental';
  cars: Car[];
  selectedCar: Car;

  constructor(
    private carService: CarService,
    private router: Router) { }

  getCars(): void {
    this.carService.getCarsWithObservable().subscribe(cars => this.cars = cars);
    //this.carService.getCarsWithPromise().then(cars => this.cars = cars); //with local db
  }

  ngOnInit(): void {
    this.getCars();
  }

  onSelect(car: Car): void {
    this.selectedCar = car;
  }

  gotoDetail(): void {
    this.router.navigate(['/detail', this.selectedCar.plateNumber]);
  }
}
