package ast;

import java.util.HashMap;

public class PrintStmt extends Stmt{


    private final Expr e;
    public PrintStmt(Expr e, Location loc) {
        super(loc);
        this.e = e;
    }

    @Override
    public QVal exec(HashMap<String, QVal> env) {
        System.out.println((e.eval(env).toString()));
        return null;
    }
}
