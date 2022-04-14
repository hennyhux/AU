package ast;

public class QIntVal extends QVal{

    final Long value;

    public QIntVal(Long value){
        this.value = value;
    }


    @Override
    public String toString() {
        return Long.toString(this.value);
    }
}