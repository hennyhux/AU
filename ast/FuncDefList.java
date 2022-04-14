package ast;

public class FuncDefList extends ASTNode{

    private final FuncDef first;
    private final FuncDefList rest;

    public FuncDefList(FuncDef first, FuncDefList rest, Location loc) {
        super(loc);
        this.first = first;
        this.rest = rest; 
    }

    public FuncDef lookUp(String name){
        if (first.name.idString.equals(name)){
            return first;
        } else if (rest != null){
            return rest.lookUp(name);
        }
        
        return null;
    }
}
