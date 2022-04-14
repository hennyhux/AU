package ast;

public class QuandaryWrapper extends QVal{

    QVal leftSide; 
    QVal rightSide;

    public QuandaryWrapper(QVal leftSide, QVal rightSide){
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    @Override
    public String toString() {
        return "(" + this.leftSide.toString() + " . " + this.rightSide.toString() + ")";
    }
    
}
