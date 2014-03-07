// import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Test {
    public static void main(String[] args) throws Exception {
		String valgol =
			"def f(x,y) {\n" +
			"  var x = grody^max\n" +
			"  gag me with a spoon\n" +
			"  for i = like 1 to maybe 10 totally do\n" +
			"  \tx = fersure tubular\n" +
			"}\n";
        ANTLRInputStream input = new ANTLRInputStream(valgol);

        // create a lexer that feeds off of input CharStream
        ValgolLexer lexer = new ValgolLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        ValgolParser parser = new ValgolParser(tokens);

        ParseTree tree = parser.file(); // begin parsing at init rule
		ParserRuleContext t = (ParserRuleContext)tree;
		t.inspect(parser);

        ParseTreeWalker.DEFAULT.walk(new PrintFuncs(), tree);
    }
}
