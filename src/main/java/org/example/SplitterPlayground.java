package org.example;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;

public class SplitterPlayground {

    public static List<String> createList(final String input, final String delimiter) {
        return Splitter.on(delimiter)
                .trimResults()
                .splitToList(input);
    }

    public static Map<String, String> createMap(final String input, final String keyValueSeparator, final String entrySeparator) {
        return Splitter.on(entrySeparator).withKeyValueSeparator(keyValueSeparator).split(input);
    }

    public static List<String> splitFixedLength(final String input, final int length) {
        return Splitter.fixedLength(length).splitToList(input);
    }

    public static List<String> splitFixedLengthWithLimit(final String input, final String delimiter, final int limit) {
        return Splitter.on(delimiter).limit(limit).splitToList(input);
    }

    public static void main(String[] args) {
        System.out.println(createList("apple - banana - orange", "-"));
        System.out.println(createMap("John=first,Adam=second", "=", ","));
        System.out.println(splitFixedLength("Hello world", 3));
        System.out.println(splitFixedLengthWithLimit("a,b,c,d,e", ",",4));
    }
}
