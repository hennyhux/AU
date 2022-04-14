package ast;

public class VarDecl{

    public final String idString;
    public final Type type;
    final boolean isMutable;

    public VarDecl(String idString, Type type, boolean isMutable)
    {
        this.idString = idString;
        this.type = type;
        this.isMutable = isMutable;
    }

}
