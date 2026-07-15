# Inventory Management System (Java Console App)

A console-based inventory management system built in Java. It lets a user
add, remove, and view items in an inventory, with the running list
displayed after every operation.

This is a project in my console-java-projects repository.

## Working of the System

- The user can add items by providing a name, quantity, and price.
- The user can remove an item from the inventory by its name.
- The user can view all items currently in the inventory.
- The system reports the outcome of each operation as it happens.

## Project Structure

```
05-Inventory-Management-System/
├── README.md
└── src/
    └── com/
        └── inventory/
            ├── Item.java              # A single inventory item: name, quantity, price
            ├── Inventory.java         # Generic collection: add, remove, view items
            └── InventorySystem.java   # Entry point — menu and user input
```

## Key Concepts Used

- **Classes & encapsulation** – `Item` keeps its fields private behind
  getters and setters.
- **Generics** – `Inventory<T>` isn't hardcoded to `Item`; it can hold any
  type, backed by a `List<T>`.
- **Exception handling** – `addItem`/`removeItem` wrap their logic in
  `try/catch`, and `removeItem` throws an `IllegalArgumentException` if the
  item isn't found.
- **`Scanner`** – reads all menu choices and item details from the console.

## How to Use

Run the app to see a simple numbered menu:

```
Inventory System
1. Add item
2. Remove item
3. View items
4. Exit
Enter your choice:
```

- **Add item** – prompts for name, quantity, and price, then adds it to the inventory.
- **Remove item** – prompts for a name and removes the first matching item (case-insensitive).
- **View items** – lists every item currently in the inventory.
- **Exit** – closes the program.

The menu reappears after every action until you choose to exit.


## Sample Output

```
Inventory System
1. Add item
2. Remove item
3. View items
4. Exit
Enter your choice: 1
Enter item name: Laptop
Enter item quantity: 5
Enter item price: 999.99
Item added successfully: Item{name='Laptop', quantity=5, price=999.99}

Inventory System
1. Add item
2. Remove item
3. View items
4. Exit
Enter your choice: 3
Inventory items:
Item{name='Laptop', quantity=5, price=999.99}

Inventory System
1. Add item
2. Remove item
3. View items
4. Exit
Enter your choice: 2
Enter item name to remove: Laptop
Item removed successfully: Item{name='Laptop', quantity=5, price=999.99}

Inventory System
1. Add item
2. Remove item
3. View items
4. Exit
Enter your choice: 3
Inventory is empty.

Inventory System
1. Add item
2. Remove item
3. View items
4. Exit
Enter your choice: 4
Exiting Inventory System.
```

### Handling a missing item

If you try to remove an item that isn't in the inventory, the app reports
it instead of crashing:

```
Enter item name to remove: Phone
Item not found in inventory.
```

## Notes

- Item name matching for removal is **case-insensitive** (`"laptop"` will
  match `"Laptop"`).
- If two items share the same name, removing by name only removes the
  first match found.
- Data isn't saved between runs — everything resets when the program exits.