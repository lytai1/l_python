package edu.sjsu.lpython;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.lpython.parser.LightPythonBaseVisitor;
import edu.sjsu.lpython.parser.LightPythonParser;

public class StatementBuilderVisitor extends LightPythonBaseVisitor<Statement>{
    private Environment env = new Environment();

	@Override 
    public Statement visitFile_input(LightPythonParser.File_inputContext ctx) {
        List<Statement> stmts = new ArrayList<Statement>();
        for (int i=0; i<ctx.stmt().size(); i++) {
            Statement s = visit(ctx.stmt(i));
            if (s != null) stmts.add(s);
        }
        return new SuitStat(stmts); 
    }

	@Override 
    public Statement visitSimple_stmt(LightPythonParser.Simple_stmtContext ctx) { 
        Statement s = visit(ctx.small_stmt());
        return s;     
    }

    @Override 
    public Statement visitAssignment_stmt(LightPythonParser.Assignment_stmtContext ctx) {
        String varName = ctx.NAME().getText();
        ExprStat e = (ExprStat) visit(ctx.expr());
        return new AssignStat(varName, e.toExpression()); 
    }

    @Override 
    public Statement visitIf_stmt(LightPythonParser.If_stmtContext ctx) { 
        return visitChildren(ctx); 
    }

    @Override 
    public Statement visitWhile_stmt(LightPythonParser.While_stmtContext ctx) { 
        ExprStat cond = (ExprStat) visit(ctx.test());
        Statement body = visit(ctx.suite());
        return new WhileStat(cond.toExpression(), body); 
    }

    @Override 
    public Statement visitSuite2(LightPythonParser.Suite2Context ctx) { 
        List<Statement> stmts = new ArrayList<Statement>();
        for (int i=0; i<ctx.stmt().size(); i++) {
            Statement s = visit(ctx.stmt(i));
            if (s != null) stmts.add(s);
        }
        return new SuitStat(stmts);
    }

    @Override 
    public Statement visitNot(LightPythonParser.NotContext ctx) { 
        ExprStat es = (ExprStat) visit(ctx.test());
        return new ExprStat(new NotOpExpr(es.toExpression())); 
    }

    @Override 
    public Statement visitBoolOp(LightPythonParser.BoolOpContext ctx) { 
        ExprStat es1 = (ExprStat) visit(ctx.test(0));
        ExprStat es2 = (ExprStat) visit(ctx.test(1));
        BoolOp bo = null;

        switch(ctx.aon_op().getText()){
            case "and":
                bo = BoolOp.AND;
            break;
            case "or":
                bo = BoolOp.OR;
            break;
        }
        return new ExprStat(new BoolOpExpr(bo, es1.toExpression(), es2.toExpression())); 
    }

    @Override 
    public Statement visitCompOp(LightPythonParser.CompOpContext ctx) { 
        ExprStat es1 = (ExprStat) visit(ctx.expr(0));
        ExprStat es2 = (ExprStat) visit(ctx.expr(1));
        Op o = null;

        switch(ctx.comp_op().getText()){
            case "<":
            o = Op.LT;
            break;
            case ">":
            o = Op.GT;
            break;
            case "==":
            o = Op.EQ;
            break;
            case ">=":
            o = Op.LE;
            break;
            case "<=":
            o = Op.GE;
            break;
            case "!=":
            o = Op.NE;
            break;
        }
        return new ExprStat(new BinOpExpr(o, es1.toExpression(), es2.toExpression())); 
    }

	@Override 
    public Statement visitPrint_stmt(LightPythonParser.Print_stmtContext ctx) {
        ExprStat es = (ExprStat) visit(ctx.expr());
        return new PrintStat(es.toExpression()); 
    }

	@Override 
    public Statement visitMulDivMod(LightPythonParser.MulDivModContext ctx) { 
        ExprStat es1 = (ExprStat) visit(ctx.expr(0));
        ExprStat es2 = (ExprStat) visit(ctx.expr(1));
        Op o = null;

        switch(ctx.op.getText()){
            case "*":
            o = Op.MULTIPLY;
            break;
            case "/":
            o = Op.DIVIDE;
            break;
            case "%":
            o = Op.MOD;
            break;

        }
        return new ExprStat(new BinOpExpr(o, es1.toExpression(), es2.toExpression()));
    }

    @Override 
    public Statement visitAddSub(LightPythonParser.AddSubContext ctx) { 
        ExprStat es1 = (ExprStat) visit(ctx.expr(0));
        ExprStat es2 = (ExprStat) visit(ctx.expr(1));
        Op o = null;

        if(es1.toExpression().evaluate(env) instanceof StringVal){
            switch(ctx.op.getText()){
                case "+":
                o = Op.ADD;
                break;
            }
            return new ExprStat (new StringOpExpr(o, es1.toExpression(), es2.toExpression()));
        }

        switch(ctx.op.getText()){
            case "+":
            o = Op.ADD;
            break;
            case "-":
            o = Op.SUBTRACT;
        }
        return new ExprStat(new BinOpExpr(o, es1.toExpression(), es2.toExpression()));
    }

    @Override 
    public Statement visitNegposNum(LightPythonParser.NegposNumContext ctx) { 
        ExprStat es1 = (ExprStat) visit(ctx.atom());
        switch(ctx.sign.getText()){
            case "+":
            return es1;
            case "-":
            return new ExprStat(new BinOpExpr(Op.SUBTRACT, new ValueExpr(new IntVal(0)) , es1.toExpression()));
        }
        return es1;
    }

    @Override 
    public Statement visitAtomTrailer(LightPythonParser.AtomTrailerContext ctx) { 
        ExprStat es1 = (ExprStat) visit(ctx.atom());

        return es1; 
    }


	@Override 
    public Statement visitVar(LightPythonParser.VarContext ctx) { 
        String varName = ctx.NAME().getText();
        return new ExprStat(new VarExpr(varName)); 
    }

	@Override 
    public Statement visitInt(LightPythonParser.IntContext ctx) { 
        int val = Integer.valueOf(ctx.NUMBER().getText());
        return new ExprStat(new ValueExpr(new IntVal(val)));
    }

    @Override 
    public Statement visitString(LightPythonParser.StringContext ctx) { 
        String str = ctx.STRING().getText();
        str = str.substring(1, str.length()-1);
        return new ExprStat(new ValueExpr(new StringVal(str))); 
    }

    @Override 
    public Statement visitBoolean(LightPythonParser.BooleanContext ctx) { 
        boolean bool = Boolean.parseBoolean(ctx.BOOLEAN().getText());
        return new ExprStat(new ValueExpr(new BoolVal(bool))); 
    }

    @Override 
    public Statement visitNone(LightPythonParser.NoneContext ctx) { 
        return new ExprStat(new ValueExpr(new NoneVal())); 
    }

    @Override 
    public Statement visitList(LightPythonParser.ListContext ctx) {
        List<Value> l = new ArrayList<>();
        for (int i=0; i<ctx.test().size(); i++) {
            ExprStat es = (ExprStat) visit(ctx.test(i));
            Value v = es.toExpression().evaluate(env);
            l.add(v);
        }
        return new ExprStat(new ValueExpr(new ListVal(l))); 
    }


    @Override 
    public Statement visitParen(LightPythonParser.ParenContext ctx) { 
        ExprStat es = (ExprStat) visit(ctx.expr());
        return es;
    }

}
