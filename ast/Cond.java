package ast;

import java.util.HashMap;

public abstract class Cond extends ASTNode {

    Cond(Location loc) {
        super(loc);
    }

    public abstract boolean eval(HashMap<String, QVal> env);
    
}
