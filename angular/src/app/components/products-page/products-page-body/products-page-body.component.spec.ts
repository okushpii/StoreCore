import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductsPageBodyComponent } from './products-page-body.component';

describe('ProductsPageBodyComponent', () => {
  let component: ProductsPageBodyComponent;
  let fixture: ComponentFixture<ProductsPageBodyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductsPageBodyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductsPageBodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
