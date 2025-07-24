#pragma once
#include <set>
#include <map>
#include "Expense.h"
#ifndef UTILITIES_H
#define UTILITIES_H

class Utilities
{
public:
	Utilities();
	virtual void addExpense(std::set<int>&, std::map<int, Expense*>&);
	virtual void deleteExpense(std::set<int>&, std::map<int, Expense*>&);
	virtual void showExpense(std::set<int>&, std::map<int, Expense*>&);
	virtual int findMissedId(std::set<int>);
	virtual Expense* createExpense(int missedId);
	~Utilities();
};

#endif // !UTILITIES_H




