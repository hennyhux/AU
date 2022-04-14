package ast;

import java.util.HashMap;

public class ConstExpr extends Expr {

    final Object value;

    public ConstExpr(Object value, Location loc) {
        super(loc);
        if (value != null)this.value = (Long)value;

        else {
            this.value = null;
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    QVal eval(HashMap<String, QVal> env) {

        if (value != null && value instanceof Long){
            return new QIntVal((Long)value);
        }
        else if (value == null){
            return new QRefVal(null);
        }
        return null;
    }
}
