package ast;

import java.util.HashMap;

public class CastingExpr extends Expr{
    
    final Type type;
    final Expr expr;

    public CastingExpr(Type type, Expr expr, Location loc){
        super(loc);
        this.type = type;
        this.expr = expr;
    }


    @Override
    QVal eval(HashMap<String, QVal> env) {
        
        QVal value = expr.eval(env);
        

        if (type == Type.INT && value instanceof QIntVal){ 
            
            return (QIntVal)value;
        }

        else if (type == Type.Q){
            return (QVal)value;
        }

        else if (type == Type.REF){
            return (QRefVal)value;
        }

        else {
            throw new RuntimeException("UGH! SOMETIME FAILED IN CASTING!!!");
        }
    }

}