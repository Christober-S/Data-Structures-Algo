# Linked List
A Linked List is a linear data structure where elements (nodes) are stored in non-contiguous memory and are connected using pointers.

---

## Analogy
Imagine a treasure hunt:
- Each clue has the information and the location of the next clue.
- You start from the first clue (head), then follow the path using the pointers (links).
- You cannot jump directly to the 5th clue without reading the previous 4.

---

# Types of Linked List
- **Singly Linked List** – Each node has a pointer to the next node.
- **Doubly Linked List** – Each node has pointers to both previous and next nodes.
- **Circular Linked List** – Last node links back to the head.

We'll focus on **Singly Linked List** here.

---

# Operations on a Singly Linked List

## Create a Linked List
```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }
}
```

---

## Insert at Beginning
```java
public void insertAtBeginning(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
}
```

---

## Insert at End
```java
public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if (head == null) {
        head = newNode;
        return;
    }
    Node temp = head;
    while (temp.next != null) {
        temp = temp.next;
    }
    temp.next = newNode;
}
```

---

## Insert at Index
```java
public void insertAtIndex(int index, int data) {
    if (index < 0) return;

    if (index == 0) {
        insertAtBeginning(data);
        return;
    }

    Node newNode = new Node(data);
    Node temp = head;

    for (int i = 0; temp != null && i < index - 1; i++) {
        temp = temp.next;
    }

    if (temp == null) return;

    newNode.next = temp.next;
    temp.next = newNode;
}
```

---

## Delete by Value
```java
public void deleteByValue(int key) {
    if (head == null) return;

    if (head.data == key) {
        head = head.next;
        return;
    }

    Node temp = head;
    while (temp.next != null && temp.next.data != key) {
        temp = temp.next;
    }

    if (temp.next != null) {
        temp.next = temp.next.next;
    }
}
```

---

## Delete by Index
```java
public void deleteAtIndex(int index) {
    if (index < 0 || head == null) return;

    if (index == 0) {
        head = head.next;
        return;
    }

    Node temp = head;
    for (int i = 0; temp != null && i < index - 1; i++) {
        temp = temp.next;
    }

    if (temp == null || temp.next == null) return;

    temp.next = temp.next.next;
}
```

---

## Search a Value
```java
public boolean search(int key) {
    Node temp = head;
    while (temp != null) {
        if (temp.data == key) return true;
        temp = temp.next;
    }
    return false;
}
```

---

## Display the Linked List
```java
public void display() {
    Node temp = head;
    while (temp != null) {
        System.out.print(temp.data + " -> ");
        temp = temp.next;
    }
    System.out.println("null");
}
```

---

# Time Complexity of each Operation
| Operation | Time Complexity |
|-----------|-----------------|
| Access    | O(n) |
| Search    | O(n) |
| Insert at Beginning | O(1) |
| Insert at End / Index | O(n) |
| Delete | O(n) |

---

# Common Mistakes
- Not updating the head pointer when modifying the first node.
- Not checking for null when accessing next nodes.
- Assuming contiguous memory like arrays (not true for Linked Lists).

---

# Downsides of Linked List
- No direct access using index.
- Extra memory needed to store next pointers.
- Slower traversal compared to arrays.

---

# Complete Implementation of Linked List as an ADT
```java
class Node {
  int data;
  Node next;

  Node(int data) {
      this.data = data;
      this.next = null;
  }
}

public class LinkedList {
  private Node head;

  public void insertAtBeginning(int data) {
      Node newNode = new Node(data);
      newNode.next = head;
      head = newNode;
  }

  public void insertAtEnd(int data) {
      Node newNode = new Node(data);
      if (head == null) {
          head = newNode;
          return;
      }
      Node temp = head;
      while (temp.next != null) {
          temp = temp.next;
      }
      temp.next = newNode;
  }

  public void insertAtIndex(int index, int data) {
      if (index < 0) return;

      if (index == 0) {
          insertAtBeginning(data);
          return;
      }

      Node newNode = new Node(data);
      Node temp = head;

      for (int i = 0; temp != null && i < index - 1; i++) {
          temp = temp.next;
      }

      if (temp == null) return;

      newNode.next = temp.next;
      temp.next = newNode;
  }

  public void deleteByValue(int key) {
      if (head == null) return;

      if (head.data == key) {
          head = head.next;
          return;
      }

      Node temp = head;
      while (temp.next != null && temp.next.data != key) {
          temp = temp.next;
      }

      if (temp.next != null) {
          temp.next = temp.next.next;
      }
  }

  public void deleteAtIndex(int index) {
      if (index < 0 || head == null) return;

      if (index == 0) {
          head = head.next;
          return;
      }

      Node temp = head;
      for (int i = 0; temp != null && i < index - 1; i++) {
          temp = temp.next;
      }

      if (temp == null || temp.next == null) return;

      temp.next = temp.next.next;
  }

  public boolean search(int key) {
      Node temp = head;
      while (temp != null) {
          if (temp.data == key) return true;
          temp = temp.next;
      }
      return false;
  }

  public void display() {
      Node temp = head;
      while (temp != null) {
          System.out.print(temp.data + " -> ");
          temp = temp.next;
      }
      System.out.println("null");
  }

  public static void main(String[] args) {
      LinkedList list = new LinkedList();
      list.insertAtBeginning(10);
      list.insertAtEnd(20);
      list.insertAtIndex(1, 15);
      list.display(); // 10 -> 15 -> 20 -> null

      list.deleteByValue(15);
      list.display(); // 10 -> 20 -> null

      list.deleteAtIndex(0);
      list.display(); // 20 -> null

      System.out.println("Search 20: " + list.search(20)); // true
      System.out.println("Search 10: " + list.search(10)); // false
  }
}