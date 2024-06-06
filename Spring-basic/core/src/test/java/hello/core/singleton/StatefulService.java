package hello.core.singleton;

import java.sql.SQLOutput;

public class StatefulService {
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }
}