package junit.nama.junit.interfacetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
 
@TestInstance(value = Lifecycle.PER_CLASS)
public interface TestLifecycleLogger {
 
    static final Logger LOG = Logger.getLogger(TestLifecycleLogger.class.getName());
 
    @BeforeAll
    default void beforeAll() {
        LOG.info("This Method runs before all tests");
    }
 
    @AfterAll
    default void afterAll() {
        LOG.info("This Method runs after all tests");
    }
 
    @BeforeEach
    default void beforeEach(TestInfo testInfo) {
        LOG.info(() -> String.format("About to execute [%s]",
            testInfo.getDisplayName()));
    }
 
    @AfterEach
    default void afterEach(TestInfo testInfo) {
        LOG.info(() -> String.format("Finished executing [%s]",
            testInfo.getDisplayName()));
    }
}
