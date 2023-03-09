package facade;

import java.util.List;

/**
 * 
 * Compiler has subclasses like Tokenizer, Parser, Generator, etc. Client which
 * use a compiler do not deal with subclasses in order to compile. Compiler
 * class represents a facade. Facade hides low-level functionality from client.
 *
 */
public class Compiler {

	public static Integer compile(String input) throws Exception {

		Integer result = null;

		List<String> tokens = Tokenizer.tokenize(input);

		Parser parser = new Parser();
		Node astRoot = parser.parse(tokens);

		result = Generator.generate(astRoot);

		return result;
	}
}
