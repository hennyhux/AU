package ast;

public class ExprList extends ASTNode {

    final Expr first; 
    final ExprList rest;

    public ExprList(Expr first, ExprList rest, Location loc) {
        super(loc);
        this.first = first;
        this.rest = rest;
    
    }
}
