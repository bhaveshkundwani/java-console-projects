# Employee Data Analyzer (Java)

A Java project that manages and analyzes employee data — names, departments, and salaries — using multithreading to process employees concurrently and custom exception handling for missing records.

This is a project in my java-console-projects repository.

## Working of the System

- **`Employee`** holds an employee's ID, name, department, and salary
  (salary is wrapped in `Optional` to safely handle missing values).
- **`EmployeeManager`** stores all employees and can add, fetch by ID,
  filter by minimum salary, and sort by salary.
- **`EmployeeProcessor`** processes a single employee's data on its own
  thread, so multiple employees can be processed concurrently.
- **`EmployeeNotFoundException`** is a custom exception for gracefully
  handling employee lookups that come up empty.
- **`EmployeeDataAnalyzer`** is the entry point that wires everything
  together: adds employees, processes them in parallel threads, then
  filters and sorts the results.

## Project Structure

```
07-Employee-Data-Analyzer/
├── README.md
└── src/
    └── com/
        └── employee/
            ├── Employee.java                    # An employee: id, name, department, salary
            ├── EmployeeManager.java             # Add, fetch, filter, and sort employees
            ├── EmployeeProcessor.java           # Processes one employee on its own thread
            ├── EmployeeNotFoundException.java   # Custom exception for missing employees
            └── EmployeeDataAnalyzer.java        # Main class — ties everything together
```

## Key Concepts Used

- **Multithreading** – `EmployeeProcessor extends Thread`, so several
  employees can be processed at the same time; `join()` is used to wait
  for all threads to finish before continuing.
- **`Optional<T>`** – Used for both `Employee.getSalary()` and
  `EmployeeManager.getEmployeeById()` to avoid `null` checks and handle
  missing data safely.
- **Custom exceptions** – `EmployeeNotFoundException` models a
  domain-specific error case.
- **Streams & lambdas** – `filterEmployeesBySalary()` and
  `sortEmployeesBySalary()` use the Stream API with `Comparator` instead
  of manual loops.
- **Collections** – Employees are stored in a `HashMap<Integer, Employee>`
  keyed by ID for fast lookups.

## Sample Output

Because employees 1, 2, and the missing ID 5 are processed on separate
threads, the exact order of these three lines can vary between runs — but
the rest of the output is deterministic:

```
Processing employee: Employee{id=1, name='Mike', department='Engineering', salary=75000.0}
Processing employee: Employee{id=2, name='Lucas', department='Marketing', salary=68000.0}
Employee with ID 5 not found.

Employees with salary >= 70000:
Employee{id=1, name='Mike', department='Engineering', salary=75000.0}
Employee{id=3, name='Dustin', department='Engineering', salary=80000.0}

Employees sorted by salary:
Employee{id=4, name='Will', department='HR', salary=55000.0}
Employee{id=2, name='Lucas', department='Marketing', salary=68000.0}
Employee{id=1, name='Mike', department='Engineering', salary=75000.0}
Employee{id=3, name='Dustin', department='Engineering', salary=80000.0}
```

## Notes

- The order of "Employees with salary >= 70000" isn't guaranteed, since it
  comes from iterating a `HashMap`'s values.
- `EmployeeNotFoundException` is defined but not actually thrown anywhere
  in the current code — `EmployeeProcessor` and `EmployeeManager` instead
  handle a missing employee gracefully via `Optional` and
  `ifPresentOrElse()`. It's there as a starting point for stricter error
  handling if you want lookups to fail loudly instead.
- Since threads run concurrently, console output from `EmployeeProcessor`
  can interleave differently on each run.