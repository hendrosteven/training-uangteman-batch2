import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InputProductComponent } from './input-product.component';

describe('InputProductComponent', () => {
  let component: InputProductComponent;
  let fixture: ComponentFixture<InputProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
