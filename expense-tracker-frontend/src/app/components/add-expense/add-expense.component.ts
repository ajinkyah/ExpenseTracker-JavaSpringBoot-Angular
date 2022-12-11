import { Component, OnInit } from '@angular/core';
import { Expense } from 'src/app/models/expense';
import { ExpenseService } from 'src/app/services/expense.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-expense',
  templateUrl: './add-expense.component.html',
  styleUrls: ['./add-expense.component.css']
})
export class AddExpenseComponent implements OnInit {

  expense: Expense = new Expense();

  constructor(private _expenseService: ExpenseService,
              private _router: Router,
              private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const isIdPresent = this._activatedRoute.snapshot.paramMap.has('id');
    if (isIdPresent) {
        const id = +this._activatedRoute.snapshot.paramMap.get('id');
        this._expenseService.getExpense(id).subscribe(
          data => this.expense = data 
        )
    }
    this.futureDateDisable();
  }

  maxDate:any;

  futureDateDisable() {
    var date: any = new Date();
    var todayDate:any = date.getDate();
    var month:any = date.getMonth() +1;
    var year:any = date.getFullYear();
    if(todayDate < 10){
      todayDate = '0' + todayDate;
    }
    if(month < 10){
      month = '0' + month;
    }
    this.maxDate = year + "-" +month + "-" + todayDate;
  }
  

  saveExpense() {
    this._expenseService.saveExpense(this.expense).subscribe(
      data => {
        console.log('response', data);
        this._router.navigateByUrl("/expenses");
      }
    )
  }

  deleteExpense(id: number) {
    this._expenseService.deleteExpense(id).subscribe(
      data => {
        console.log('deleted response', data);
        this._router.navigateByUrl('/expenses');
      }
    )
  }

}
