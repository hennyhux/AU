package ast;

import java.util.HashMap;

public class BinaryCondCompound extends Cond
{
    public static final int AND = 1;
    public static final int OR = 2;


    private Cond cond1;
    private Cond cond2;
    private int operator;

    public BinaryCondCompound(Cond cond1, int operator, Cond cond2, Location loc) {
        super(loc);
        this.cond1 = cond1;
        this.operator = operator;
        this.cond2 = cond2;
    }

    @Override
    public boolean eval(HashMap<String, QVal> env) {

        switch (operator) {
            case AND:  return cond1.eval(env) && cond2.eval(env); 
            case OR: return cond1.eval(env) || cond2.eval(env);
        }
        throw new RuntimeException("Unexpected in BinaryExpr.doOperation");
    }
}
