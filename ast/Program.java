package ast;

import java.util.HashMap;

public class Program extends ASTNode {

   
    final FuncDefList funcs;

    private static Program instance;

    public Program(FuncDefList funcs, Location loc) {
        super(loc);
        this.funcs = funcs;
        instance = this;

    }

    public Object exec(long argument) {
        FuncDef main = funcs.lookUp("main");
        HashMap<String, QVal> env = new HashMap<String, QVal>();
        env.put(main.params.vd.idString, new QIntVal(argument));
        //QIntVal copy = main.execBody(env).value; //quite an unsafe cast 
        return main.execBody(env);
    }

    static Program getProgram(){
        return instance;
    }
}
