package junit.nama.junitsuitetest.runner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
/**
 * @SelectPackages,@IncludeTags and @ExcludeTags demo
 *
 */
@RunWith(JUnitPlatform.class)
@SelectPackages(value = { "junit.nama.junitsuitetest"})
@IncludeTags("dev")
//@ExcludeTags("dev")
public class TestSuiteWithIncludeTagsExample {
}