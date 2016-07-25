package homeWork4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Master on 19.06.2016.
 */
public class test {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        System.out.println(list);
        list.add(6,"a");
        System.out.println(list);
        System.out.println(list.get(list.size() - 1));
        list.add(list.size() - 1, "22");
        System.out.println(list);
        System.out.println("---REMOVE---");
        list.remove(list.size() - 1);
        System.out.println("Size: " + list.size());
        System.out.println(list);
        for (int i = 0; i < list.size();) {
            list.remove(0);
            System.out.println(list);
            System.out.println("Size: " + list.size());
        }
        System.out.println("---ADD_ALL---");
        List<String> listForAdd = new ArrayList<>();
        listForAdd.add("A");
        listForAdd.add("B");
        list.addAll(listForAdd);
        System.out.println(list);
        System.out.println("---FOREACH---");
        for (String str : list) {
            System.out.println(str);
            list.add("C");
        }
    }

}


