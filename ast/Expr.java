package ast;

import java.util.HashMap;

public abstract class Expr extends ASTNode {

    Expr(Location loc) {
        super(loc);
    }

    abstract QVal eval(HashMap<String,QVal> env);
}
