package ast;

import java.util.HashMap;

public class IdentExpr extends Expr {

    private String identifier;

    public IdentExpr(String ideString, Location loc) {
        super(loc);
        this.identifier = ideString;
        
    }
    @Override
    QVal eval(HashMap<String, QVal> env) {
        
        return env.get(identifier);

    }
}
