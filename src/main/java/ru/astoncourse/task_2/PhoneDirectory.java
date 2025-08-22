package ru.astoncourse.task_2;

import java.util.*;

public class PhoneDirectory {
    private final Map<String, List<String>> secondNameAndPhone;

    public PhoneDirectory() {
        secondNameAndPhone = new HashMap<>();
    }

    public void add(String secondName, String phone) {
        if (!secondNameAndPhone.containsKey(secondName)) {
            secondNameAndPhone.put(secondName, new ArrayList<>(Arrays.asList(phone)));
        } else {
            secondNameAndPhone.get(secondName).add(phone);
        }
    }

    public String get(String secondName) {
        String line = secondName + " : ";
        if (!secondNameAndPhone.containsKey(secondName)) {
            return line + "У данной фамилии нет номера в справочнике";
        } else {
            List<String> list = secondNameAndPhone.get(secondName);
            for (int i = 0; i < list.size(); i++) {
                line += list.get(i) + "   ";
            }
        }
        return line;
    }
}
