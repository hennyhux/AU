package ast;

import java.util.HashMap;
import java.util.Random;


public class MutableCallStatement extends Stmt {

    final CallExpr callExpr;
    public MutableCallStatement(CallExpr callExpr, Location loc) {
        super(loc);
        this.callExpr = callExpr;

    }

    @Override
    public QVal exec(HashMap<String, QVal> env) {
        callExpr.eval(env);
        return null;
    }

}

