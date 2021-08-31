package com.example.pracjava;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class TestStream {
    @Test
    public void test1(){
        String [] arr = new String[]{"a","b","c"};
        Stream<String> stream1 = Arrays.stream(arr); //배열 스트림 생성
        Stream<String> stream2 = Arrays.stream(arr,0,1); //배열 스트림 생성 범위 지정
        List<String> list = Arrays.asList("d","e","f");
        Stream<String> stream3 = list.stream(); // 컬렉션 스트림
        Stream<String> stream4 = list.parallelStream(); // 컬렉션 스트림 , 병렬 처리 스트림
        Stream<String> stream5 = Stream.<String>builder().add("a").add("b").add("b").build(); // 배열이나 컬렉션 없이 직접 스트림 생성하기
        Stream<String> stream6 = Stream.generate(()->"create").limit(5); // 람다로 스트림 생성하기
        Stream<String> stream7 = Stream.iterate("a", n -> n + n).limit(5); // iterate는 출력된 요속가 다음 요소의 인풋으로 들어간다.

        // Stream 가공하기
    }
}
