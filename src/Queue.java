class Queue<T> extends List<T> implements ToArray {
    Queue() {
        this.initialCapacity = 10;
        this.size = 0;
        this.dataArray = (T[]) new Object[this.initialCapacity];
    }
    Queue(int capacity) {
        this.initialCapacity = capacity;
        this.size = 0;
        this.dataArray = (T[]) new Object[this.initialCapacity];
    }
    void enQueue(T value) {
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
    T deQueue() {
        if (this.isEmpty()) {
            return null;
        }
        this.size -= 1;
        T popVal = (T) this.dataArray[0];
        Object[] temp = this.dataArray;
        if (this.size <= this.capacity() / 2 & this.capacity() > this.initialCapacity) {
            this.dataArray = (T[]) new Object[this.capacity() / 2];
        } else {
            this.dataArray = (T[]) new Object[this.capacity()];
        }
        for (int i = 1; i <= this.size; i++) {
            this.dataArray[i - 1] = (T) temp[i];
        }
        return popVal;
    }
    T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return (T) this.dataArray[0];
    }
    void reset() {
        this.size = 0;
        this.dataArray = (T[]) new Object[this.initialCapacity];
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
        for (int i = 0; i < this.size; i++) {
            temp[i] = this.dataArray[i];
        }
        return temp;
    }
}
