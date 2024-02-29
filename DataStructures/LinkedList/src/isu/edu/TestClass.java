package isu.edu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestClass {

	@Test
	void test() {
		assertEquals(5,MainClass.sum(2,3));
		assertEquals(6,MainClass.sum(3,3));
	}
	@Test
	void test2() {
		assertEquals(7,MainClass.sum(2,3),"Check add statement");
	}
}
