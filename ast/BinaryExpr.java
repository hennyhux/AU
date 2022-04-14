package ast;
import java.util.HashMap;

public class BinaryExpr extends Expr {

    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int MULTIPLY = 3;
    public static final int DOTOPERATOR = 4;

    final Expr expr1;
    final int operator;
    final Expr expr2;

    public BinaryExpr(Expr expr1, int operator, Expr expr2, Location loc) {
        super(loc);
        this.expr1 = expr1;
        this.operator = operator;
        this.expr2 = expr2;
    }

    @Override
    public String toString() {
        return "(" + simpleString() + ")";
    }

    public String simpleString() {
        String s = null;
        switch (operator) {
            case PLUS:  s = "+"; break;
            case MINUS: s = "-"; break;
            case MULTIPLY: s = "*"; break;
            case DOTOPERATOR: s = "."; break;
        }
        return expr1 + " " + s + " " + expr2;
    }

    @Override
    QVal eval(HashMap<String, QVal> env) {
        switch (operator) {
            case PLUS:  return new QIntVal(((QIntVal)expr1.eval(env)).value + ((QIntVal)expr2.eval(env)).value);
            case MINUS: return new QIntVal(((QIntVal)expr1.eval(env)).value - ((QIntVal)expr2.eval(env)).value);
            case MULTIPLY: return new QIntVal(((QIntVal)expr1.eval(env)).value * ((QIntVal)expr2.eval(env)).value);

            case DOTOPERATOR: return new QRefVal(new QuandaryWrapper(expr1.eval(env), expr2.eval(env))); //the ref strucutre now holds two references left and right respectively 
        }
        throw new RuntimeException("Unexpected in BinaryExpr.doOperation");
    }
}
