import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
  import { Observable } from 'rxjs/Observable';
  import 'rxjs/add/operator/map';
import "rxjs/Rx";

import { Car } from './car';
import { CARS } from './mock-cars';

@Injectable()
export class CarService {

  cars: Car[];

  constructor(private http: HttpClient) {}

  getCarsWithPromise(): Promise<Car[]> {
    return Promise.resolve(CARS);
  }

  public getCarsWithObservable(): Observable<Car[]> {
    return this.http.get("http://localhost:8080/samples").map((response: Response) => response || []);
  }

  getCar(plateNumber: string): Promise<Car> {
	return Promise.resolve(CARS.find(car => car.plateNumber === plateNumber));
  }

  getCarWithObservable(plateNumber): Observable<Car> {
  	return this.http.get("http://localhost:8080/samples/"+plateNumber);
  }

  rent(car): Observable<any> {
    car.rented = true;
    return this.http.put("http://localhost:8080/samples/"+car.plateNumber+"?numberOfDays="+car.numberOfDays, null);
  }

  getBack(car): Observable<any> {
    car.rented = false;
    car.numberOfDays = 0;
    return this.http.put("http://localhost:8080/samples/getback/"+car.plateNumber+"?louer="+car.rented, null);
  }

}
