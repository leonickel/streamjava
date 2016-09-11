package com.leonickel;

import org.junit.Test;

/**
 * This test class is intended to illustrate possible real situations while running application.
 * This class cannot Assert any data because main method doesn't return anything. One possible way
 * would be create some response file, but for the sake of simplicity, I prefer not doing that.
 * @author lnicke2
 *
 */
public class BootstrapTest {

	@Test
	public void test_startup_valid_arguments() {
		Bootstrap.main(new String[]{"5", "ABCDE"});
	}
	
	@Test
	public void test_startup_no_arguments() {
		Bootstrap.main(new String[]{});
	}
	
	@Test
	public void test_startup_invalid_arguments() {
		Bootstrap.main(new String[]{"a"});
	}
	
	@Test
	public void test_startup_valid_one_argument() {
		Bootstrap.main(new String[]{"3"});
	}
}
