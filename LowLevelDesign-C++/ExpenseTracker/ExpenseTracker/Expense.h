#pragma once
#include <string>


#ifndef EXPENSE_H

class Expense
{
public:
	int expenseId;
	std::string description, date;
	double amount;
	Expense(int expenseId, std::string description, double amount, std::string date);
};

#endif // !EXPENSE_H


