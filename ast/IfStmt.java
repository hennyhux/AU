package ast;

import java.io.PrintStream;
import java.util.HashMap;

public class IfStmt extends Stmt{

    private Cond c;
    private Stmt s;

    public IfStmt(Cond c, Stmt s, Location loc) {
        super(loc);
        this.c = c;
        this.s = s;   
    }



    @Override
    public QVal exec(HashMap<String, QVal> env) {
        if (c.eval(env)) {
            return s.exec(env);
        }

        return null;
    }
}