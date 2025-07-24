#include <iostream>
#include <set>
#include <map>
#include <string>
#include "Utilities.h"
#include "Expense.h"

Utilities::Utilities() {
	std::cout << "Entering the constructor for the add utilities class" << std::endl;
}

void Utilities::addExpense(std::set<int> expenseIds, std::map<int, Expense> expenseStorage) {
	std::cout << "Adding the expenses" << std::endl;
	int missedId = findMissedId(expenseIds);
	expenseIds.insert(missedId);
	Expense* expense = createExpense(missedId);
	expenseStorage.insert({missedId, expense});
}

void Utilities::deleteExpense(std::set<int> expenseIds, std::map<int, Expense> expenseStorage) {
	std::cout << "Deleting the expenses" << std::endl;
}

void Utilities::showExpense(std::set<int> expenseIds, std::map<int, Expense> expenseStorage) {
	std::cout << "Showing the expenses" << std::endl;
}

int Utilities::findMissedId(std::set<int> expenseIds) {
	int missedId = 0;
	if (expenseIds.find(missedId) != expenseIds.end()) {
		missedId++;
	}
	return missedId;
}

Expense* Utilities::createExpense(int expenseId) {
	std::string description, dateOfExpenditure;
	double amount;
	std::cout << "Enter the description of the expenditure" << std::endl;
	std::cin >> description;
	std::cout << "Enter the amount of the expenditure" << std::endl;
	std::cin >> amount;
	std::cout << "Enter the date of the expenditure" << std::endl;
	std::cin >> dateOfExpenditure;

	Expense* expense = new Expense(expenseId, description, amount, dateOfExpenditure);
	return expense;
}

Utilities::~Utilities() {
	std::cout << "Entering the destructor for the add utilities class" << std::endl;
}