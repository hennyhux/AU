package ast;

import java.util.HashMap;

public class ReturnStmt extends Stmt{
    
    private final Expr expr;

    public ReturnStmt(Expr expr, Location loc) {
        super(loc);
        this.expr = expr;
    }

    @Override
    public QVal exec(HashMap<String, QVal> env)
    {
        return expr.eval(env);
    }

}
