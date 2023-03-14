abstract class List<T> {
    protected T[] dataArray;
    protected int initialCapacity;
    protected int size;
    int capacity() {
        return this.dataArray.length;
    }
    int size() {
        return this.size;
    }
    abstract void reset();
}
