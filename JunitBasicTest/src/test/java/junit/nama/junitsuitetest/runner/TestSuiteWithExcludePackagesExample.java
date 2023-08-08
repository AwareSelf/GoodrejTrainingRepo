package junit.nama.junitsuitetest.runner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
/**
 *@SelectPackages and @ExcludePackages demo
 *
 */
@RunWith(JUnitPlatform.class)
@SelectPackages(value = { "junit.nama.junitsuitetest"})
@ExcludePackages(value = {"junit.nama.junitsuitetest.packageA"})
public class TestSuiteWithExcludePackagesExample {
}