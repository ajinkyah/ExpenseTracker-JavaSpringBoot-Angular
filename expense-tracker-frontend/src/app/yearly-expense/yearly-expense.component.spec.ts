import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YearlyExpenseComponent } from './yearly-expense.component';

describe('YearlyExpenseComponent', () => {
  let component: YearlyExpenseComponent;
  let fixture: ComponentFixture<YearlyExpenseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YearlyExpenseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YearlyExpenseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
