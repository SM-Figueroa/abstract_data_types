/*
 * Name: Sawyer Figueroa
 * PID: A16335277
 */

import java.util.Arrays;

import static java.lang.Math.abs;

public class HashTable implements IHashTable {

    /* the bridge for lazy deletion */
    private static final String BRIDGE = new String("[BRIDGE]".toCharArray());

    /* instance variables */
    private int size; // number of elements stored
    private String[] table; // data table
    private int capacity;
    private int rehashes = 1;
    private int logCap = 10;
    private float[] loadFactor = new float[this.logCap];
    private int[] collisions = new int[this.logCap];

    public HashTable() {
        this(15);
    }

    public HashTable(int capacity) {
        if (capacity < 5) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.size = 0;
        this.table = new String[this.capacity];
    }

    @Override
    public boolean insert(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        if (this.lookup(value)) {
            return false;
        }
        this.loadFactor[this.rehashes - 1] = (float) this.size / this.capacity;
        if (this.loadFactor[this.rehashes - 1] > 0.55) {
            this.rehash();
        }
        int index = hashString(value);
        int i = index;
        while (this.table[i] != null) {
            if (i == this.capacity - 1) {
                i = 0;
            } else {
                i++;
            }
            this.collisions[this.rehashes - 1]++;
        }
        this.table[i] = value;
        this.size++;
        return true;
    }

    @Override
    public boolean delete(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        if (!this.lookup(value)) {
            return false;
        }
        int index = hashString(value);
        int i = index;
        while (this.table[i] != null) {
            if (this.table[i].equals(value)) {
                replace(i);
                break;
            }
            if (i + 1 == this.capacity) {
                i = 0;
            } else {
                i++;
            }
        }
        this.size--;
        return true;
    }

    private void replace(int i) {
        if (i + 1 == this.capacity) {
            if (this.table[0] == null) {
                this.table[i] = null;
            } else {
                this.table[i] = BRIDGE;
            }
        } else {
            if (this.table[i + 1] == null) {
                this.table[i] = null;
            } else {
                this.table[i] = BRIDGE;
            }
        }
    }

    @Override
    public boolean lookup(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        int index = hashString(value);
        int i = index;
        while (this.table[i] != null) {
            if (this.table[i].equals(value)) {
                return true;
            }
            if (i == index - 1) {
                break;
            }
            if (i == this.capacity - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    public String getStatsLog() {
        String output = "";
        for (int i = 1; i < this.rehashes; i++) {
            output += String.format("Before rehash # %d: load factor %.2f, %d collision(s).\n",
                    i, this.loadFactor[i - 1], this.collisions[i - 1]);
        }
        return output;
    }

    private void rehash() {
        if (this.rehashes == this.logCap) {
            float[] newLoad = new float[this.logCap * 2];
            int[] newCollisions = new int[this.logCap * 2];
            for (int i = 0; i < this.loadFactor.length; i++) {
                newLoad[i] = this.loadFactor[i];
                newCollisions[i] = this.collisions[i];
            }
            this.loadFactor = newLoad;
            this.collisions = newCollisions;
            this.logCap *= 2;
        }
        this.capacity *= 2;
        this.size = 0;
        this.rehashes++;
        String[] oldTable = this.table;
        this.table = new String[this.capacity];
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null & oldTable[i] != BRIDGE) {
                this.insert(oldTable[i]);
            }
        }
    }

    private int hashString(String value) {
        int hashValue = 0;
        for (int i = 0; i < value.length(); i++) {
            int leftShiftedValue = hashValue << 5;
            int rightShiftedValue = hashValue >>> 27;

            hashValue = (leftShiftedValue | rightShiftedValue) ^ value.charAt(i);
        }
        return abs(hashValue) % this.capacity;
    }


    /**
     * Returns the string representation of the hash table.
     * This method internally uses the string representation of the table array.
     * DO NOT MODIFY. You can use it to test your code.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        return Arrays.toString(table);
    }
}
