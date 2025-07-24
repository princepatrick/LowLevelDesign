#include <iostream>
#include <set>
#include <map>
#include "Expense.h"
#include "ExpenseTrackerApp.h"
#include "Utilities.h"

ExpenseTrackerApp::ExpenseTrackerApp() {
	std::cout << "The Expense Tracker Apps Constructor is called!!" << std::endl;
	ExpenseTrackerApp::utilitiesFromExpTracker = new Utilities();
}

ExpenseTrackerApp::~ExpenseTrackerApp() {
	std::cout << "The Expense Tracker Apps Destructor is called!!" << std::endl;
}

void ExpenseTrackerApp::performOperations(int option) {
	std::set<int> expenseIds = ExpenseTrackerApp::expenseIds;
	std::map<int, Expense*> expenseStorage = ExpenseTrackerApp::expenseStorage;
	
	switch (option) {
	case 1:
		std::cout<<"We are adding an expense!!" << std::endl;
		std::cout << "The size of expense ids are " << expenseIds.size() << " and the size of expense storage is " << expenseStorage.size() << std::endl;
		ExpenseTrackerApp::utilitiesFromExpTracker->addExpense(expenseIds, expenseStorage);
		std::cout << "The size of expense ids are " << expenseIds.size() << " and the size of expense storage is " << expenseStorage.size() << std::endl;
		ExpenseTrackerApp::expenseIds = expenseIds;
		ExpenseTrackerApp::expenseStorage = expenseStorage;
		break;
	case 2:
		std::cout << "We are deleting an expense!!" << std::endl;
		std::cout << "The size of expense ids are " << expenseIds.size() << " and the size of expense storage is " << expenseStorage.size() << std::endl;
		ExpenseTrackerApp::utilitiesFromExpTracker->deleteExpense(expenseIds, expenseStorage);
		std::cout << "The size of expense ids are " << expenseIds.size() << " and the size of expense storage is " << expenseStorage.size() << std::endl;
		ExpenseTrackerApp::expenseIds = expenseIds;
		ExpenseTrackerApp::expenseStorage = expenseStorage;
		break;
	case 3:
		std::cout << "We are displaying the expenses!!" << std::endl;
		ExpenseTrackerApp::utilitiesFromExpTracker->showExpense(expenseIds, expenseStorage);
		break;
	case 4:
		return;
	default:
		return;
	}
}


