# Arrays
Arrays are one of the most fundamental data structures.

We’ll understand how arrays work internally, how to perform key operations like insert, delete, access, and search — and how this fits into the concept of Abstract Data Types (ADT).

---

## Let us look at this with an Analogy
Assume you are in a hostel:
- Each room has a unique number (index)
- All rooms will be next to each other (contiguous memory)
- You can easily find and navigate to room number 5 (constant time access)

---

# Operations on an Array

## Create an Array
```java
public class Array {
  private int[] arr;     // array
  private int size;      // Number of elements currently in array
  private int capacity;  // Total capacity of array

  // Constructor
  public Array(int capacity) {
      this.capacity = capacity;
      arr = new int[capacity];
      size = 0;
  }
}
```

---

## Access an Element using Index - get(i)
```java
// Get element at index
public int get(int index) {
    if (index < 0 || index >= size) {
        System.out.println("Get failed: Invalid index");
        return -1;
    }
    return arr[index];
}
```

---

## Update an Element using Index - set(i, x)
```java
// Set element at index
public boolean set(int index, int value) {
    if (index < 0 || index >= size) {
        System.out.println("Set failed: Invalid index");
        return false;
    }
    arr[index] = value;
    return true;
}
```

---

## Insert an Element at Index - insert(i, x)
```java
// Insert at index
public boolean insert(int index, int element) {
    if (size >= capacity || index < 0 || index > size) {
        System.out.println("Insert failed: Invalid index or array is full");
        return false;
    }
    for (int i = size; i > index; i--) {
        arr[i] = arr[i - 1];
    }
    arr[index] = element;
    size++;
    return true;
}
```

---

## Delete an Element at Index - delete(i)
```java
// Delete at index
public boolean delete(int index) {
    if (index < 0 || index >= size) {
        System.out.println("Delete failed: Invalid index");
        return false;
    }
    for (int i = index; i < size - 1; i++) {
        arr[i] = arr[i + 1];
    }
    size--;
    return true;
}
```

---

## Search an Element - search(x)
```java
// Search for element (returns index or -1)
public int search(int target) {
    for (int i = 0; i < size; i++) {
        if (arr[i] == target) return i;
    }
    return -1;
}
```

---

# Time Complexity of each Operation
| Operation | Time Complexity |
|----------|-----------------|
| Access   | O(1)            |
| Search   | O(n)            |
| Insert   | O(n)            |
| Delete   | O(n)            |

---

# Implementation of Array as an ADT
```java
public class Array {
  private int[] arr;     // Underlying array
  private int size;      // Number of elements currently in array
  private int capacity;  // Total capacity of array

  // Constructor
  public Array(int capacity) {
      this.capacity = capacity;
      arr = new int[capacity];
      size = 0;
  }

  // Insert at index
  public boolean insert(int index, int element) {
      if (size >= capacity || index < 0 || index > size) {
          System.out.println("Insert failed: Invalid index or array is full");
          return false;
      }
      for (int i = size; i > index; i--) {
          arr[i] = arr[i - 1];
      }
      arr[index] = element;
      size++;
      return true;
  }

  // Delete at index
  public boolean delete(int index) {
      if (index < 0 || index >= size) {
          System.out.println("Delete failed: Invalid index");
          return false;
      }
      for (int i = index; i < size - 1; i++) {
          arr[i] = arr[i + 1];
      }
      size--;
      return true;
  }

  // Get element at index
  public int get(int index) {
      if (index < 0 || index >= size) {
          System.out.println("Get failed: Invalid index");
          return -1;
      }
      return arr[index];
  }

  // Set element at index
  public boolean set(int index, int value) {
      if (index < 0 || index >= size) {
          System.out.println("Set failed: Invalid index");
          return false;
      }
      arr[index] = value;
      return true;
  }

  // Search for element (returns index or -1)
  public int search(int target) {
      for (int i = 0; i < size; i++) {
          if (arr[i] == target) return i;
      }
      return -1;
  }

  // Display array
  public void display() {
      System.out.print("Array: ");
      for (int i = 0; i < size; i++) {
          System.out.print(arr[i] + " ");
      }
      System.out.println();
  }

  // Get current size
  public int getSize() {
      return size;
  }

  // Get capacity
  public int getCapacity() {
      return capacity;
  }

  // Main method to test
  public static void main(String[] args) {
      Array array = new Array(10);

      array.insert(0, 10);
      array.insert(1, 20);
      array.insert(2, 30);
      array.insert(1, 15);  // Insert in between

      array.display();  // Expected: 10 15 20 30

      array.set(2, 25);
      System.out.println("Element at index 2: " + array.get(2));  // Expected: 25

      array.delete(1);
      array.display();  // Expected: 10 25 30

      System.out.println("Index of 30: " + array.search(30)); // Expected: 2
  }
}
```

---

# Common Mistakes
- Index out of bounds — make sure to handle it whenever you use arrays
- Mixing up size and length (capacity)

---

# Downsides of Arrays
- Fixed Size
- Costly Insertion & Deletion
- Memory Wastage
- Arrays need contiguous blocks of memory, which can be a problem for very large arrays.