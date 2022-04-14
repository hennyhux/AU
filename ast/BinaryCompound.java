package ast;
import java.util.HashMap;

public class BinaryCompound extends Cond
{
    public static final int GREATER = 1;
    public static final int LESS = 2;
    public static final int EQUAL = 3;
    public static final int LESSEQUAL = 4;
    public static final int GREATEREQUAL = 5;
    public static final int NOT = 6;


    private final Expr expr1;
    private final Expr expr2;
    private final int operator;

    public BinaryCompound(Expr expr1, int operator, Expr expr2, Location loc) {
        super(loc);
        this.expr1 = expr1;
        this.operator = operator;
        this.expr2 = expr2;
    }

    @Override
    public boolean eval(HashMap<String, QVal> env) {
        
        
        QIntVal cast1 = (QIntVal)expr1.eval(env);    
 
        QIntVal cast2 = (QIntVal)expr2.eval(env);
      
        //System.out.println(cast1.value);
        //System.out.println(cast2.value);

        int cast1Primtive = cast1.value.intValue();
        int cast2Primtive = cast2.value.intValue();

        //System.out.println(cast1.value != cast2.value); //WTF. why is 0 != 0 evaluting to be true?
 
        switch (operator) {
            
            case GREATER:  return cast1Primtive > cast2Primtive;
            case LESS:     return cast1Primtive < cast2Primtive;
            case EQUAL:     return cast1Primtive == cast2Primtive;
            case LESSEQUAL: return cast1Primtive <= cast2Primtive;
            case GREATEREQUAL: return cast1Primtive >= cast2Primtive;
            case NOT:            return cast1Primtive != cast2Primtive; 
        }
        throw new RuntimeException("Unexpected in BinaryExpr.doOperation");
    }

}