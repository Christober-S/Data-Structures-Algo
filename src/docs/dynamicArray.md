# Dynamic Arrays
Dynamic Arrays solve a specific limitation of regular arrays — their fixed size. In regular arrays, once the array is full, no more elements can be inserted. However, with Dynamic Arrays, the array automatically grows in size when it reaches its limit.

The size of the array typically doubles when it becomes full to accommodate more elements.

---

## Array Resize
```java
void resize(){
  capacity = 2 * capacity;
  int[] newArr = new int[capacity];
  for (int i = 0; i < size; i++) {
      newArr[i] = arr[i];
  }
  arr = newArr;
}
```

---

# Implementation of Dynamic Array as an ADT
```java
class DynamicArray {
  int[] arr;
  int size;
  int capacity;
  
  DynamicArray(int capacity) {
      arr = new int[capacity];
      this.capacity = capacity;
      size = 0;
  }

  boolean insert(int index, int element) {
      if (index < 0 || index > size) {
          System.out.println("Can't insert: Invalid Index");
          return false;
      }
      if (size >= capacity) {
          resize();
      }
      for (int i = size; i > index; i--) {
          arr[i] = arr[i - 1];
      }
      arr[index] = element;
      size++;
      return true;
  } 

  int get(int index) {
      if (index < 0 || index >= size) {
          System.out.println("Invalid Index");
          return -9999;
      }
      return arr[index];
  }

  void set(int index, int element) {
      if (index < 0 || index >= size) {
          System.out.println("Invalid Index");
          return;
      }
      arr[index] = element;
  }

  void display() {
      for (int i = 0; i < size; i++) {
          System.out.print(arr[i] + " ");
      }
      System.out.println();
  }

  int search(int element) {
      for (int i = 0; i < size; i++) {
          if (arr[i] == element) {
              return i;
          }
      }
      return -1;
  }

  boolean delete(int index) {
      if (index < 0 || index >= size) {
          System.out.println("Can't delete: Invalid Index");
          return false;
      }
      for (int i = index; i < size - 1; i++) {
          arr[i] = arr[i + 1];
      }
      size--;
      return true;
  }

  void resize() {
      capacity = 2 * capacity;
      int[] newArr = new int[capacity];
      for (int i = 0; i < size; i++) {
          newArr[i] = arr[i];
      }
      arr = newArr;
  }

  public static void main(String[] args) {
      DynamicArray arr1 = new DynamicArray(5);

      arr1.insert(0, 5);
      arr1.insert(1, 4);
      arr1.insert(1, 67);
      arr1.insert(1, 7);
      arr1.insert(1, 87);
      arr1.insert(2, 45);  // Triggers resize

      System.out.println(arr1.capacity);

      arr1.display();

      System.out.println("get: " + arr1.get(0));
      arr1.set(1, 78);

      arr1.delete(1);

      arr1.display();

      System.out.println("search: " + arr1.search(78));
  }   
}