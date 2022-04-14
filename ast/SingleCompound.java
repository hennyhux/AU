package ast;

import java.util.HashMap;

public class SingleCompound extends Cond{

    public static final int NOT = 1;

    private final Cond c;
    private final int operator;

    public SingleCompound(Cond c, int operator, Location loc) {
        super(loc);
        this.operator = operator;
        this.c = c;
    }

    @Override
    public boolean eval(HashMap<String, QVal> env) {
        switch (operator) {
        case NOT:           return !c.eval(env);
        }
        throw new RuntimeException("Unexpected in BinaryExpr.doOperation");
    }

    
}
