import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductFacetsComponent } from './product-facets.component';

describe('ProductFacetsComponent', () => {
  let component: ProductFacetsComponent;
  let fixture: ComponentFixture<ProductFacetsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductFacetsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductFacetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
