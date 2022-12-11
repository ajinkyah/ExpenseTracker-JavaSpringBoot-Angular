import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { RouterModule, Routes } from "@angular/router";
import { FormsModule } from "@angular/forms";

import { AppComponent } from './app.component';
import { ListExpensesComponent } from './components/list-expenses/list-expenses.component';
import { AddExpenseComponent } from './components/add-expense/add-expense.component';
import { RegisterComponent } from './register/register.component';
import { MonthlyExpenseComponent } from './monthly-expense/monthly-expense.component';
import { YearlyExpenseComponent } from './yearly-expense/yearly-expense.component';
import { CategorywiseExpenseComponent } from './categorywise-expense/categorywise-expense.component';

const routers: Routes = [
  {path: 'expenses', component: ListExpensesComponent},
  {path: 'addexpense', component: AddExpenseComponent},
  {path: 'editexpense/:id', component: AddExpenseComponent},
  {path: '', redirectTo: '/expenses', pathMatch: 'full'},
  {path: 'monthlyexpense', component: MonthlyExpenseComponent},
  {path: 'yearlyexpense', component: YearlyExpenseComponent},
  {path: 'categorywiseexpense', component: CategorywiseExpenseComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ListExpensesComponent,
    AddExpenseComponent,
    RegisterComponent,
    MonthlyExpenseComponent,
    YearlyExpenseComponent,
    CategorywiseExpenseComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routers)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
