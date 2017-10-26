import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InputCategoryComponent } from './input-category.component';

describe('InputCategoryComponent', () => {
  let component: InputCategoryComponent;
  let fixture: ComponentFixture<InputCategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputCategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
