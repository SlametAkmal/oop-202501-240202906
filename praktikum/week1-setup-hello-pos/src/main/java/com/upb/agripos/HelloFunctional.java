package com.upb.agripos;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class HelloFunctional {
    public static void main(String[] args) {
        BiConsumer<String, String> introduce =
                (nim, name) -> System.out.println("Hello Word, I am " + name + " - " + nim);

        introduce.accept("240202906", "Slamet Akmal");
    }
}
