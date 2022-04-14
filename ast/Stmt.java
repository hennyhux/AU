package ast;

import java.util.HashMap;

public abstract class Stmt extends ASTNode{

    Stmt(Location loc) {
        super(loc);
    }

    public abstract QVal exec(HashMap<String,QVal> env);

}
