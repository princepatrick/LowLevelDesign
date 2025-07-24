#include <iostream>
#include <set>
#include <map>
#include <string>
#include "Utilities.h"
#include "Expense.h"

Utilities::Utilities() {
	std::cout << "Entering the constructor for the add utilities class" << std::endl;
}

void Utilities::addExpense(std::set<int>& expenseIds, std::map<int, Expense*>& expenseStorage) {
	std::cout << "Adding the expenses" << std::endl;
	int missedId = findMissedId(expenseIds);
	expenseIds.insert(missedId);
	Expense* expense = createExpense(missedId);
	expenseStorage.insert({missedId, expense});
	std::cout << "The expense storage after insertion is " << expenseStorage.size() << std::endl;
}

void Utilities::deleteExpense(std::set<int>& expenseIds, std::map<int, Expense*>& expenseStorage) {
	int deleteId;
	std::cout << "Deleting the expenses" << std::endl;
	Utilities::showExpense(expenseIds, expenseStorage);
	std::cout << "Please find the expenses above and choose the id to remove" << std::endl;
	std::cin >> deleteId;
	expenseIds.erase(deleteId);
	expenseStorage.erase(deleteId);
}

void Utilities::showExpense(std::set<int>& expenseIds, std::map<int, Expense*>& expenseStorage) {
	std::cout << "Showing the expenses below: " << std::endl;

	std::cout << "------------------------------------------------" << std::endl;

	std::cout << "------------------------------------------------" << std::endl;

	for (auto itr = expenseStorage.begin(); itr != expenseStorage.end(); itr++) {
		Expense* expense = itr->second;
		std::cout << " " << expense->expenseId << " " << expense->description << " " << expense->amount << " " << expense->date << std::endl;
	}

	std::cout << "------------------------------------------------" << std::endl;

	std::cout << "------------------------------------------------" << std::endl;
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