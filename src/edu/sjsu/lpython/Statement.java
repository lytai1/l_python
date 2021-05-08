package edu.sjsu.lpython;

import java.util.List;

public interface Statement {
    /**
     * Evaluate the expression in the context of the specified environment.
     */
    public Value evaluate(Environment env);
}

/**
 * expression statement
 *
 */
class ExprStat implements Statement {
    private Expression expr;

    public ExprStat(Expression expr){
        this.expr = expr;
    }

    public Expression toExpression(){
        return expr;
    }

    public Value evaluate(Environment env) {

        return this.expr.evaluate(env);
    }
}

class IfStat implements Statement {
	private List<Expression> ifs;
	private List<Statement> blocks;
	private Statement elsestat;
	
	
	public IfStat(List<Expression> ifs, List<Statement> blocks, Statement elsestat) {
		super();
		this.ifs = ifs;
		this.blocks = blocks;
		this.elsestat = elsestat;
	}


	@Override
	public Value evaluate(Environment env) {
		// TODO Auto-generated method stub
		for(int i = 0; i<ifs.size(); i++) {
			BoolVal b = (BoolVal) ifs.get(i).evaluate(env);
			if (b.toBoolean()) {
				Statement s = blocks.get(i);
				return s.evaluate(env);	
			}
		}
		if (elsestat != null) {
			return elsestat.evaluate(env);
		}
		return null;
	}
	
}


/**
* While statements.
*/
class WhileStat implements Statement {
 private Expression cond;
 private Statement body;
 public WhileStat(Expression cond, Statement body) {
     this.cond = cond;
     this.body = body;
 }
 public Value evaluate(Environment env) {
 	BoolVal condition = (BoolVal) cond.evaluate(env);
 	Value result = new NoneVal();
 	while(condition.toBoolean()) {
 		result = body.evaluate(env);
 		condition = (BoolVal) cond.evaluate(env);
 	}
     return result;
    }
}

class SuitStat implements Statement {
    private List<Statement> stmts;

    public SuitStat(List<Statement> stmts){
        this.stmts = stmts;
    }

    public Value evaluate(Environment env) {
        for (Statement stmt: stmts){
            stmt.evaluate(env);
        }
        return new NoneVal();
    }

}


/**
* Updating an existing variable.
* If the variable is not set already, it is added
* to the global scope.
*/
class AssignStat implements Statement {
	 private String varName;
	 private Expression e;
	 public AssignStat(String varName, Expression e) {
	     this.varName = varName;
	     this.e = e;
	 }
	 public Value evaluate(Environment env) {
	   	Value val = e.evaluate(env);
	 	env.updateVar(varName, val);    	
	 	
	     return val;
     }
}

/**
* A print statement.
*/
class PrintStat implements Statement {
 private Statement s;
 public PrintStat(Statement s) {
     this.s = s;
 }

 public Value evaluate(Environment env) {
     Value v = s.evaluate(env);
     System.out.println(v.toString());
     return v;
 }
}

