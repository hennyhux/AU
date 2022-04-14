package ast;

import java.util.HashMap;
import java.util.Random;


public class CallExpr extends Expr {

    final String funcName;
    final ExprList args;
   

    public CallExpr(String funcName, ExprList args, Location loc) {
        super(loc);
        this.args = args;
        this.funcName = funcName;
    }


    static Random rand = new Random();

    @Override
    QVal eval(HashMap<String, QVal> callerEnv) {
        if (funcName.equals("randomInt")){
            return randomInt((QIntVal)args.first.eval(callerEnv)); //NOTE double check this works before turning it in; clean the method next time with switch statements
        }

        else if (funcName.equals("left")){
            return left((QRefVal)args.first.eval(callerEnv));
        }

        else if (funcName.equals("right")){
            return right((QRefVal)args.first.eval(callerEnv));
        }

        else if (funcName.equals("setLeft")){
            return setLeft((QRefVal)args.first.eval(callerEnv), args.rest.first.eval(callerEnv));
        }

        else if (funcName.equals("setRight")){
            return setRight((QRefVal)args.first.eval(callerEnv), args.rest.first.eval(callerEnv));
        }

        else if (funcName.equals("isAtom")){
            return isAtom((args.first.eval(callerEnv)));
        }

        else if (funcName.equals("isNil")){
            return isNil(args.first.eval(callerEnv));
        }

        FuncDef funcDef = Program.getProgram().funcs.lookUp(funcName);
        HashMap<String, QVal> calleeEnv = new HashMap<String, QVal>();
        FormalDeclList currParamList = funcDef.params;
        
        ExprList currExprList = args;

        while (currParamList != null){
            Object value = currExprList.first.eval(callerEnv);
            calleeEnv.put(currParamList.vd.idString, (QVal)value);
            
            currParamList = currParamList.rest;
            currExprList = currExprList.rest;
        } 

        return funcDef.execBody(calleeEnv);
    }

    private QIntVal randomInt(QIntVal intVal){
        
        return new QIntVal(Math.abs(rand.nextLong()) % intVal.value);
    }

    private QVal left(QRefVal refVal){
        return refVal.ref.leftSide;
    }

    private QIntVal setLeft(QRefVal refVal, QVal quandVal){
        refVal.ref.leftSide = quandVal;
        return new QIntVal(1l);
    }

    private QVal right(QRefVal refVal){
        return refVal.ref.rightSide;
    }

    private QIntVal setRight(QRefVal refVal, QVal quandVal){
        refVal.ref.rightSide = quandVal;
        return new QIntVal(1l);
    }

    /*Returns 1 if x’s value is nil or an int; returns 0 otherwise (if x’s value is a non-nil Ref)*/
    private QIntVal isAtom(QVal quandVal){

        if (quandVal instanceof QIntVal || quandVal == null || quandVal instanceof QRefVal && ((QRefVal)quandVal).ref == null){
            return new QIntVal(1l);
        }
        return new QIntVal(0l);
        
    }

    //WTF? why doesnt this work?
    //Returns 1 if x’s value is nil; returns 0 otherwise (if x’s value is an int or a non-nil Ref)
    private QIntVal isNil(QVal value){

        if (value == null || value instanceof QRefVal && ((QRefVal)value).ref == null){
           
            return new QIntVal(1l);
        }

        else {
            
            return new QIntVal(0l);
        }
    }
}



