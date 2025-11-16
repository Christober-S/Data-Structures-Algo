# Abstract Data Type (ADT)

Before we dive into **Abstract Data Types (ADTs)**, let’s revisit two important concepts: **Data Types** and **User-Defined Data Types**.

---

## 📌 Data Types

Data Types like `int`, `float`, and `string` define two main things:

1. **What kind of data a variable can store.**
2. **What operations can be performed on that data.**

### Examples:

- **int**  
  Supports arithmetic, relational, and bitwise operations.

- **float**  
  Supports arithmetic and relational operations but **not** bitwise operations.

- **string** (in many languages)  
  Supports concatenation and comparison but **not** subtraction or division.

👉 Data types determine what values a variable can hold and which operations are allowed.  
These are predefined by the programming language.

---

## 📌 User-Defined Data Types

User-Defined Data Types are custom types created by the programmer using structures (`struct`) or classes (`class`).

### Example in C (Structure):

```c
struct Student {
  char name[50];
  int age;
  float marks;
};
```

📌 Abstract Data Types (ADT)

Abstract Data Types go one step further.

An ADT specifies:

What data is stored

What operations are allowed

But NOT how these operations are implemented

In simple words:

ADT defines what to do, not how to do it.

🧱 Example: Stack (an ADT)

A Stack stores elements in Last-In, First-Out (LIFO) order.

Common Operations:

push() – Add an element

pop() – Remove the top element

peek() – View the top element

isEmpty() – Check if the stack is empty

isFull() – Check if the stack is full (in array-based stack)

Key idea:

Whether the stack uses:

an array, or

a linked list

…is hidden from the user.

Only the operations matter, not the internal structure.

🎯 Why Use ADTs?
✔ Abstraction

Hides implementation details from the user.

✔ Flexibility

You can change the internal structure (array → linked list) without affecting code that uses the ADT.

✔ Modularity

Each ADT can be built, tested, and maintained independently.

✔ Maintainability

The interface stays the same even if the implementation changes.