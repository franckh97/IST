import 'rxjs/add/operator/switchMap';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

import { Car } from '../car';
import { CarService } from '../car.service';



@Component({
  selector: 'app-getbackcar',
  templateUrl: './getbackcar.component.html',
  styleUrls: ['./getbackcar.component.css']
})
export class GetbackcarComponent implements OnInit {


  cars: Car[];
  car : Car;
  selectedCar: Car;
  constructor(
    private carService: CarService,
    private route: ActivatedRoute,
    private location: Location
  ){ }


  getCars(): void {
    //this.carService.getCarsWithPromise().then(cars => this.cars =  cars); //with local database
    this.carService.getCarsWithObservable().subscribe(cars => this.cars = cars);

  }

  ngOnInit(): void{
      // this.route.paramMap
      //   .switchMap((params: ParamMap) => this.carService.getCar(params.get("plateNumber")))
      //   .subscribe(car => this.car = car);
        this.getCars();
  }

  onSelect(car: Car): void {
    this.selectedCar = car;
  }
  cancelRental(car): void {
    this.carService.getBack(car).subscribe(car => this.car = car);
  }
  goBack(): void {
    this.location.back();
  }

}
