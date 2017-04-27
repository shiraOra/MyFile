package com.company;

import java.security.InvalidParameterException;

/**
 * Created by hackeru on 2/20/2017.
 */
public class newNode implements Comparable {
    Comparable value;
    private int row;
    private int col;

    public newNode(Comparable value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }

    public Comparable getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof newNode) {
            if (this.value == ((newNode) o).value) {
                return 0;
            }
            if (this.value.compareTo(((newNode) o).value)<0)
                return -1;
            else
                return 1;
        }
        throw new InvalidParameterException();
    }
}
