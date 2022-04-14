package ast;
import java.io.PrintStream;
import java.util.HashMap;

public class UnaryExpr extends Expr {
    
    final Expr expr;

    public UnaryExpr(Expr expr, Location loc) {
        super(loc);
        this.expr = expr;
    }

    @Override
    QVal eval(HashMap<String, QVal> env) {
        QIntVal cast = (QIntVal)expr.eval(env);

        return new QIntVal(-cast.value);
    }

}
