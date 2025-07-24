#include "Utilities.h"
#include "Expense.h"
#include <set>
#include <map>
#ifndef EXPENSETRACKERAPP_H
#define EXPENSETRACKERAPP_H

class ExpenseTrackerApp
{	
public:
	std::set<int> expenseIds;
	std::map<int, Expense> expenseStorage;
	Utilities* utilitiesFromExpTracker;
	ExpenseTrackerApp();
	virtual void performOperations(int option);
	~ExpenseTrackerApp();
};

#endif // !EXPENSETRACKERAPP_H




