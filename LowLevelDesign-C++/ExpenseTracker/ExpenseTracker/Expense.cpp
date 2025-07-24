#include "Expense.h"

Expense::Expense(int expenseId, std::string description, double amount, std::string date) {
	Expense::expenseId = expenseId;
	Expense::description = description;
	Expense::amount = amount;
	Expense::date = date;
}
