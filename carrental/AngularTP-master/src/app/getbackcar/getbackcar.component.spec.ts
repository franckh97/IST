import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetbackcarComponent } from './getbackcar.component';

describe('GetbackcarComponent', () => {
  let component: GetbackcarComponent;
  let fixture: ComponentFixture<GetbackcarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetbackcarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetbackcarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
