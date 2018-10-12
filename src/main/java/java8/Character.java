package java8;

import domain.User;
import ioc.DefaultA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Character extends DefaultA {

    static List<String> list = Arrays.asList("spring","node","mkyong");

    public static void main(String[] args) {
        User user1 = new User("gloula","13570901234","478741233@qq.com");
        User user2 = new User("mengtasha","13842267843","478741234@qq.com");
        User user3 = new User("qqw","15270895432","478741235@qq.com");

        List<String> list = Arrays.asList("spring","node","mkyong");
        System.out.println(list.size());
        List<String> resultList = list.stream()
                .filter(item -> item.equals("spring"))
                .collect(Collectors.toList());
        System.out.println(resultList.get(0));

        List<String> distinctList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctList.get(0));

    }

    void h() {
        Character s = new Character();
        System.out.println(s.hero);
    }

}
