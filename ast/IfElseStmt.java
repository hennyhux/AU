package ast;
import java.util.HashMap;

public class IfElseStmt extends Stmt{

    private Cond c;
    private Stmt stmtB;
    private Stmt elseB;


    public IfElseStmt(Cond c, Stmt s1, Stmt s2, Location loc){
        super(loc);
        this.c = c;
        this.stmtB = s1;   
        this.elseB = s2;
    }

    @Override
    public QVal exec(HashMap<String, QVal> env) {
        if (c.eval(env)) {
            return stmtB.exec(env);
        } else if (elseB != null) {    
            return elseB.exec(env);
        }

        return null;
    }
}
    