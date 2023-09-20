package org.example;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JoinerPlayground {
    public static String joinListToString(final List<String> strings, final String separator) {
        return Joiner.on(separator).skipNulls().join(strings);
    }

    public static String joinMapToString(final Map<String, Integer> map, String keyValueSeparator, String entrySeparator) {
        return Joiner.on(entrySeparator)
                .withKeyValueSeparator(keyValueSeparator)
                .join(map);
    }

    public static String joinNestedStructuresToString(final List<List<String>> nested) {
        return Joiner.on(";").join(nested.stream().map(strings -> Joiner.on("-").join(strings)).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        System.out.println(joinListToString(Lists.newArrayList("strings", "that", "should", "be", "joined"),  ", "));
        System.out.println(joinMapToString(
                Map.of("Mary", 1000,
                        "Anna", 1800), " = ", ", "));

        System.out.println(joinNestedStructuresToString(Lists.newArrayList(
                Lists.newArrayList("apple", "banana", "orange"),
                Lists.newArrayList("cat", "dog", "bird"),
                Lists.newArrayList("John", "Jane", "Adam"))));


    }
}
