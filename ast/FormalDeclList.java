package ast;

public class FormalDeclList extends ASTNode{

    final VarDecl vd; 
    final FormalDeclList rest;

    public FormalDeclList(VarDecl vd, FormalDeclList rest, Location loc) {
        super(loc);
        this.vd = vd;
        this.rest = rest;
    
    }

    
    
}
