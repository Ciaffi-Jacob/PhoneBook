package com.zipcodewilmington.phonebook;

import javax.swing.*;
import java.util.*;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;


    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>(); //creating new hashmap for phonebook
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (String number : phonebook.keySet()){
            if(phonebook.get(number).contains(phoneNumber)){
                return number;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        //return phonebook.get();
        List<String> list = new ArrayList<String>();
        this.phonebook.keySet().forEach(key -> list.add(key));
        return list;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
