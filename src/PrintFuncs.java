import org.antlr.v4.runtime.misc.NotNull;

public class PrintFuncs extends ValgolBaseListener {
    @Override
    public void enterFunc(@NotNull ValgolParser.FuncContext ctx) {
        System.out.println("func "+ctx.ID());
    }
}
