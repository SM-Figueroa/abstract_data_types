class Stack<T> extends List<T> implements ToArray {
    Stack() {
        this.initialCapacity = 10;
        this.size = 0;
        this.dataArray = (T[]) new Object[this.initialCapacity];
    }
    Stack(int capacity) {
        this.initialCapacity = capacity;
        this.size = 0;
        this.dataArray = (T[]) new Object[this.initialCapacity];
    }
    void reset() {
        this.size = 0;
        this.dataArray = (T[]) new Object[this.initialCapacity];
    }
    void push(T value) {
        if (this.size == this.capacity()) {
            Object[] temp = this.dataArray;
            this.dataArray = (T[]) new Object[this.capacity() * 2];
            for (int i = 0; i < temp.length; i++) {
                this.dataArray[i] = (T) temp[i];
            }
        }
        this.dataArray[this.size] = value;
        this.size += 1;
    }
    T peek() {
        if (this.isEmpty()) {
            return null;
        } else {
            return (T) this.dataArray[this.size - 1];
        }
    }
    T pop() {
        if (this.isEmpty()) {
            return null;
        }
        this.size -= 1;
        T popVal = (T) this.dataArray[this.size()];
        this.dataArray[this.size] = null;
        if (this.size <= this.capacity() / 2 & this.capacity() > this.initialCapacity) {
            Object[] temp = this.dataArray;
            this.dataArray = (T[]) new Object[this.capacity() / 2];
            for (int i = 0; i < this.size; i++) {
                this.dataArray[i] = (T) temp[i];
            }
        }
        return popVal;
    }
    boolean isEmpty() {
        return this.size == 0;
    }
    public String toString() {
        String output = "";
        for (int i = 0; i < this.size; i++) {
            if (i > 0) {
                output += ",";
            }
            output += this.dataArray[i].toString();
        }
        return output;
    }
    public Object[] toArray() {
        Object[] temp =  new Object[this.size];
        for (int i = this.size; i > 0; i--) {
            temp[this.size - i] = this.dataArray[i - 1];
        }
        return temp;
    }
}
