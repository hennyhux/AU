package ast;

import java.util.HashMap;

public class FuncDef extends ASTNode{

    final VarDecl name;
    final FormalDeclList params;
    final StmtList stmts;

    public FuncDef(VarDecl name, FormalDeclList params, StmtList stmts, Location loc) {
        super(loc);
        this.name = name;
        this.params = params;
        this.stmts = stmts;
    }

    public QVal execBody(HashMap<String, QVal> env){
        return (QVal)stmts.exec(env);
        
    }
}