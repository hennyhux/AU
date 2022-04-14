package ast;

import java.util.HashMap;

public class WhileStmt extends Stmt {

    private Cond c;
    private Stmt s;

    public WhileStmt(Cond c, Stmt s, Location loc) {
        super(loc);
        this.c = c;
        this.s = s;
    }

    @Override
    public QVal exec(HashMap<String, QVal> env) {
        while (c.eval(env)){
            QVal executedStatement = s.exec(env);
            if (executedStatement != null) {
                return executedStatement;
            }
        }
        return null;
    }
    
}
