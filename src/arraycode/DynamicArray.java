package arraycode;

public class DynamicArray {
    int [] arr;
    int capacity;
    int size;

    DynamicArray(int capacity){
        arr = new int [capacity];
        this.capacity = capacity;
        size = 0;
    }

    boolean insert(int index, int element){
        if (index < 0 || index > size){
            return false;
        }
        else if(size>=capacity){
            resize();
        }
        for(int i = size; i>index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;
        return true;
    }

    boolean delete(int index){
        if(index < 0 || index >= size ){
            System.out.println("Can't Delete : Invalid Index");
            return false;
        }
        for(int i = index; i<size-1; i++){
            arr[i] = arr[i+1];
        }
        size--;
        return true;
    }

    void resize(){
        capacity = 2 * capacity;
        int [] newArray = new int[capacity];
        for(int i = 0; i<size; i++){
            newArray[i] = arr[i];
        }
        arr = newArray;
    }

    int get(int index){
        if (index < 0 || index >= size){
            System.out.println("Can't Get: Invalid Index");
            return -999;
        }
        return arr[index];
    }

    void set(int index, int element){
        if (index < 0 || index >= size){
            System.out.println("Can't Set: Invalid Index");
        }
        arr[index] = element;
    }

    int search(int element){
        for (int i = 0; i < size; i++) {
            if(arr[i] == element)
                return i;
        }
        return -1;
    }

    void display(){
        for(int i = 0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static void main() {
        DynamicArray array = new DynamicArray(5);
        array.insert(0, 1);
        array.insert(1, 2);
        array.insert(2, 3);
        array.insert(3, 4);
        array.insert(4, 5);
        System.out.println("Array Capacity: "+array.capacity);
        array.insert(5, 6);
        array.insert(6, 7);
        System.out.println("Array Capacity: "+array.capacity);
        array.display();

        System.out.println("Get: "+array.get(3));
        array.set(1, 8);
        array.display();

        System.out.println("Search: "+array.search(8));
        array.display();
    }
}
