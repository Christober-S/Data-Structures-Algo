# Time and Space Complexity

Time and space complexity are crucial concepts in computer science, especially when analyzing the performance of algorithms.

## Why is Time Complexity Necessary?
Time complexity helps us estimate how long an algorithm will take to run as the size of input increases. It gives a mathematical approximation of the worst-case scenario and helps compare algorithms for efficiency.

---

# Big O Notation – Worst Case
Big O notation describes the upper bound of an algorithm's running time.

Let’s look at a few examples:

---

## O(1) – Constant Time
An operation that takes the same amount of time regardless of input size.

### Example:
```java
int a = 5 + 3;
```

---

## O(n) – Linear Time
Time increases linearly with the number of inputs.

### Example: Linear Search
```java
int linearSearch (arr, target) {
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === target) return i;
    }
    return -1;
}
```

---

## O(n²) – Quadratic Time
Usually comes from nested loops.

### Example: Two Sum using Brute Force
```java
int[] twoSum(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] + arr[j] == target) {
                return new int[] {i, j};
            }
        }
    }
    return new int[] {-1, -1};
}
```

### Note:
- 2N is not equal to N²
- N² / 2 is still **O(N²)** in Big O notation

---

## O(n * m)
Occurs when processing a matrix or when two inputs of different sizes are involved.

### Example:
```java
for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
        // some operation
    }
}
```

---

## O(n³) – Cubic Time
Nested loops three levels deep.
Common in brute-force matrix algorithms.

---

## O(log N) – Logarithmic Time
### Example: Binary Search
```java
public static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1;
}
```

---

## O(N log N)
Common in efficient sorting algorithms like Merge Sort and Quick Sort.

---

# Other Time Complexities
- **O(N + N²):** Additive complexities — depends on the structure.
- **O(2ⁿ):** Exponential time — common in brute-force recursive problems.
- **O(√N):** Appears in some optimized algorithms like checking prime numbers.
- **O(N!):** Factorial time — very slow, often in permutation problems.

---

# Space Complexity
Space complexity is the amount of memory used by an algorithm relative to the input size.