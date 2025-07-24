#pragma once
#include <string>


#ifndef EXPENSE_H

class Expense
{
	int expenseId;
	std::string description, date;
	double amount;
public:
	Expense(int expenseId, std::string description, double amount, std::string date);
};

#endif // !EXPENSE_H


