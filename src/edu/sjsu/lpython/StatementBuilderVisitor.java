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
    public Statement visitTest(LightPythonParser.TestContext ctx) { 
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
    public Statement visitParen(LightPythonParser.ParenContext ctx) { 
        ExprStat es = (ExprStat) visit(ctx.expr());
        return es;
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
    public Statement visitVar(LightPythonParser.VarContext ctx) { 
        String varName = ctx.NAME().getText();
        return new ExprStat(new VarExpr(varName)); 
    }

	@Override 
    public Statement visitInt(LightPythonParser.IntContext ctx) { 
        int val = Integer.valueOf(ctx.NUMBER().getText());
        return new ExprStat(new ValueExpr(new IntVal(val)));
    }



}
