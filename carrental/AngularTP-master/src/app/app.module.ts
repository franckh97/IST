import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CarDetailComponent } from './car-detail.component';
import { CarsComponent } from './cars.component';
import { CarService } from './car.service';
import {GetbackcarComponent} from './getbackcar/getbackcar.component';

  


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  declarations: [
    AppComponent,
    CarDetailComponent,
    CarsComponent,
    GetbackcarComponent,
  ],
  providers: [
    CarService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
