class MyCircularDeque {
    private int[] values;
    private int capacity;
    private int modify;
    private int size;
    private int begin;
    private int end;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if (k < 0) {
            throw new IllegalArgumentException();
        }
        values = new int[k + 1];
        capacity = k;
        size = 0;
        begin = 0;
        end = 1;
        modify = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } 
        values[begin] = value;
        if (--begin < 0) {
            begin = capacity - 1;
        } 
        size++;
        modify++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } 
        values[end] = value;
        if (++end == capacity) {
            end = 0;
        } 
        size++;
        modify++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (++begin == capacity) {
            begin = 0;
        }
        modify++;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (--end < 0) {
            end = capacity - 1;
        }
        modify++;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        int index = (begin+1 == capacity ? 0 : begin+1);
        return values[index];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int index = (end-1 < 0 ? capacity - 1 : end - 1);
        return values[index];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return 0 == size;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return capacity == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */