package com.example.week11.container;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<T> {

    private List<T> items = new ArrayList<>();

    public List<T> getAll(){
        return this.items;
    }
    public void add(T item){
        items.add(item);
    }
    public List<T> filter(Predicate<T> predicate){

        return items.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
