package com.example.pracjava;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class TestOptional {
    @Test
    public void case1(){
        Optional<String> temp1 = Optional.ofNullable(null);
        assert(temp1.isPresent());
    }
    @Test
    public void case2_a(){ // Optional.ofNullalbe -> null이 될 수 있다.
        Optional<String> temp2 = Optional.ofNullable("test");
        temp2.ifPresent(name -> System.out.println(name)); // ifPresent는 값이 null이 아니라면의 조건문이다. null이 아니면 다음 문장을 실행시켜라 정도의 뜻이 된다.
    }
    @Test
    public void case2_b(){
        Optional<String> temp2 = Optional.ofNullable(null);
        temp2.ifPresent(name -> System.out.println(name));
    }

    @Test
    public void case3_a() {
        String test = null;
        Optional<String> temp3 = Optional.ofNullable(test);
        test = temp3.orElse(callTest()); // orElse는 값이 있다면 해당 값을 리턴하고 없다면 설정한 값을 리턴하게하는 용도로 사용됨
        System.out.println(test);


        String test2 = "test2";
        Optional<String> temp3_a = Optional.ofNullable(test2);
        test = temp3_a.orElse(callTest());
        System.out.println(test);
    }

    @Test
    public void case3_b(){
        String name = null;
        Optional<String> temp3 = Optional.ofNullable(name);
        name = temp3.orElseGet(()-> callTest()); // // orElseGet는 값이 있다면 해당 값을 리턴하고 없다면 설정한 값을 리턴하게하는 용도로 사용됨
        System.out.println(name);


        String test2 = "test2";
        Optional<String> temp3_a = Optional.ofNullable(test2);
        name = temp3_a.orElseGet(()->callTest());
        System.out.println(name); // orElse와 orElseGet의 차이는 orElse는 null값이 아니여도 일단 실행하지만 orElseGet은 null값이 아니면 안의 내용을 실행시키지 않는다.
    }

    @Test
    public void case4(){
        String test = null;
        String temp = Optional.ofNullable(test).orElse("변화된것");
        System.out.println(temp);
    }

    public String callTest(){
        System.out.println("테스트 함수 호출");
        return "함수가 실행됬다.";
    }
}
