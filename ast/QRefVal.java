package ast;

public class QRefVal extends QVal{

    public QuandaryWrapper ref;

    public QRefVal(QuandaryWrapper ref){
        this.ref = ref;
    }

    @Override
    public String toString() {
        if (this.ref == null) {
            return "nil";
        }
        else {
            return ref.toString();
        }
    }
    
}
