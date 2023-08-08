package junit.nama.junit.interfacetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestInterfaceDemo implements TestLifecycleLogger,
 TestInterfaceDynamicTestsDemo {

@Test
void isEqualValue() {
	assertEquals(1, "a".length(), "is always equal");
}

}
