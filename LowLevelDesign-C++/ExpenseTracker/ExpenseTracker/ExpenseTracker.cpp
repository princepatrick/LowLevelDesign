// ExpenseTracker.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include "ExpenseTrackerApp.h"

int main()
{
    int currentChosenOption = -1;

    ExpenseTrackerApp* app = new ExpenseTrackerApp();

    while (currentChosenOption != 4) {
        std::cout << "Select one of the 4 options: \n 1. Add Expense \n 2. Delete Expense \n 3. View Expenses \n 4. Exit " << std::endl;
        std::cin >> currentChosenOption;
        std::cout << "Attempting the option: " << currentChosenOption << std::endl;
        app->performOperations(currentChosenOption);
    }

    std::cout << "Thanks for using the application!!" << std::endl;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
