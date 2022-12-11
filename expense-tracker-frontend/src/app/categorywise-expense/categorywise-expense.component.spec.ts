import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategorywiseExpenseComponent } from './categorywise-expense.component';

describe('CategorywiseExpenseComponent', () => {
  let component: CategorywiseExpenseComponent;
  let fixture: ComponentFixture<CategorywiseExpenseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategorywiseExpenseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategorywiseExpenseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
