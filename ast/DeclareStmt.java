package ast;

import java.util.HashMap;

public class DeclareStmt extends Stmt{

    private final VarDecl vd;
    private final Expr e;

    public DeclareStmt(VarDecl vd, Expr e, Location loc) {
        super(loc);
        this.vd = vd;
        this.e = e;
    }

    @Override
    public QVal exec(HashMap<String,QVal> env) {
       
        env.put(vd.idString, (QVal)e.eval(env));
        return null;
    }
    
}
