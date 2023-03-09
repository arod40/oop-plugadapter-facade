package facade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CompilerTest {

	@Test
	void test() throws Exception {
		assertEquals(7, Compiler.compile("( 3 + 4 )"));
		assertEquals(15, Compiler.compile("5 + 10"));
	}

}
