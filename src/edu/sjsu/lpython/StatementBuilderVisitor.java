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
        List<Expression> ifs = new ArrayList<>();
        List<Statement> blocks = new ArrayList<>();
        Statement elsestat = new ExprStat(new ValueExpr(new NoneVal()));

        for(int i=0; i<ctx.test().size(); i++){
            Expression ife = ((ExprStat) visit(ctx.test(i))).toExpression();
            Statement block = visit(ctx.suite(i));
            ifs.add(ife);
            blocks.add(block);
        }
        if(ctx.suite().size()>ctx.test().size()){
            elsestat = visit(ctx.suite(ctx.suite().size()-1));
        }

        return new IfStat(ifs, blocks, elsestat); 
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
        return new PrintStat(visit(ctx.expr())); 
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
        if(ctx.trailer().size() == 0){
            return es1;
        }         
        List<Expression> le = new ArrayList<>();

        for(int i = 0; i< ctx.trailer().size(); i++){
            Expression e = ((ExprStat) visit(ctx.trailer(i))).toExpression();
            le.add(e);
        }
        return new ExprStat(new AtomTrailerExpr(es1.toExpression(), le));
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
        List<Expression> l = new ArrayList<>();
        for (int i=0; i<ctx.test().size(); i++) {
            ExprStat es = (ExprStat) visit(ctx.test(i));
            Expression v = es.toExpression();
            l.add(v);
        }
        return new ExprStat(new ListExpr(l)); 
    }


    @Override 
    public Statement visitParen(LightPythonParser.ParenContext ctx) { 
        ExprStat es = (ExprStat) visit(ctx.expr());
        return es;
    }
    @Override 
    public Statement visitListGet(LightPythonParser.ListGetContext ctx) { 
        ExprStat es = (ExprStat) visit(ctx.test());
        return new ExprStat(new ListGetExpr(es.toExpression())); 
    }

    @Override 
    public Statement visitListSlice(LightPythonParser.ListSliceContext ctx) { 
        ExprStat es1 = new ExprStat(new ValueExpr(new NoneVal()));
        ExprStat es2 = new ExprStat(new ValueExpr(new NoneVal()));
        ExprStat es3 = new ExprStat(new ValueExpr(new NoneVal()));
        if(ctx.start() != null)     es1 = (ExprStat) visit(ctx.start());
        if(ctx.end() != null)       es2 = (ExprStat) visit(ctx.end());
        if(ctx.slice() != null)     es3 = (ExprStat) visit(ctx.slice());

        return new ExprStat(new ListSliceExpr(es1.toExpression(),es2.toExpression(),es3.toExpression())); 
    }


}
