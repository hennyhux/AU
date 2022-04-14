package ast;

import java.util.HashMap;

public class ChangeValStmt extends Stmt {

    private final String identString;
    private final Expr expr;

    public ChangeValStmt(String identString, Expr expr, Location loc){
        super(loc);
        this.identString = identString;
        this.expr = expr;
    }

    @Override
    public QVal exec(HashMap<String, QVal> env) {
        
        QVal retVal = expr.eval(env);
        env.put(identString, retVal); 
        return null; //dont think null would do much of anything here 
    }

    

}
