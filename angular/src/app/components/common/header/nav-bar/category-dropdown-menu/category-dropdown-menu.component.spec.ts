import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryDropdownMenuComponent } from './category-dropdown-menu.component';

describe('CategoryDropdownMenuComponent', () => {
  let component: CategoryDropdownMenuComponent;
  let fixture: ComponentFixture<CategoryDropdownMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategoryDropdownMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryDropdownMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
