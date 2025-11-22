package com.javaworld.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P0341FlattenNestedListIterator implements Iterator<Integer> {
    private final List<Integer> values = new ArrayList<>();
    private int index;

    public P0341FlattenNestedListIterator(List<NestedInteger> nestedList) {
        flatten(nestedList);
    }

    @Override
    public Integer next() {
        return values.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < values.size();
    }

    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger value : nestedList) {
            if (value.isInteger()) values.add(value.getInteger());
            else flatten(value.getList());
        }
    }
}
