import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CarsComponent } from './cars.component';
import { CarDetailComponent } from './car-detail.component';
import {GetbackcarComponent} from './getbackcar/getbackcar.component';

const routes: Routes = [
  { path: '', redirectTo: '/cars', pathMatch: 'full' },
  { path: 'getback',component:GetbackcarComponent},
  { path: 'detail/:plateNumber', component: CarDetailComponent },
  { path: 'cars',     component: CarsComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}