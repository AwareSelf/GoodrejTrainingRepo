package junit.nama.junitsuitetest.runner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
/**
 * @SelectPackages and @IncludePackages  demo
  */
@RunWith(JUnitPlatform.class)
@SelectPackages(value = { "junit.nama.junitsuitetest"})
@IncludePackages(value = {"junit.nama.junitsuitetest.packageA"})
public class TestSuiteWithIncludePackagesExample {
}