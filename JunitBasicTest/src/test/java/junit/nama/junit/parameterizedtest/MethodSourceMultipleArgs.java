package junit.nama.junit.parameterizedtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class MethodSourceMultipleArgs {

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int length, List<String> list) {
        assertTrue(str.length() > 0);
        assertEquals(length, list.size());
    }

    static Stream<Arguments> stringIntAndListProvider() {
    	
    	//some code to call functions or database to get/fetch the test data arguments at runtime
    	//fetching test-data at runtime using function or db calls can't be done using csv-source or csv-file-source
    	//but can be done using method-source
    	
        return Stream.of(
                arguments("abc", 3, Arrays.asList("a", "b", "c")),
                arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }

}
