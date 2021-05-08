package edu.sjsu.lpython;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ipython expressions.
 */

public interface Expression {
    /**
     * Evaluate the expression in the context of the specified environment.
     */
    public Value evaluate(Environment env);
}

//NOTE: Using package access so that all implementations of Expression
//can be included in the same file.

/**
* ipython constants.
*/
class ValueExpr implements Expression {
 private Value val;
 public ValueExpr(Value v) {
     this.val = v;
 }
 public Value evaluate(Environment env) {
     return this.val;
 }
}

/**
* Expressions that are a ipython variable.
*/
class VarExpr implements Expression {
 private String varName;
 public VarExpr(String varName) {
     this.varName = varName;
 }
 public Value evaluate(Environment env) {
     return env.resolveVar(varName);
 }
}


/**
* Binary operators (+, -, *, etc).
* Currently only numbers are supported.
*/
class BinOpExpr implements Expression {
	 private Op op;
	 private Expression e1;
	 private Expression e2;
	 public BinOpExpr(Op op, Expression e1, Expression e2) {
	     this.op = op;
	     this.e1 = e1;
	     this.e2 = e2;
	 }

	 @SuppressWarnings("incomplete-switch")
	 public Value evaluate(Environment env) {
	     // YOUR CODE HERE
	     if(this.op == Op.EQ) {
	         Value v1 = e1.evaluate(env);
	         Value v2 = e2.evaluate(env);
	         return new BoolVal(v1.equals(v2));
	     }else if(this.op == Op.NE) {
	        Value v1 = e1.evaluate(env);
	        Value v2 = e2.evaluate(env);
	        return new BoolVal(!v1.equals(v2));
	    }
		
	    Value v1 = e1.evaluate(env);
	    if(v1 instanceof IntVal) {
	    	return intEvaluate((IntVal) v1, env);
	    }else if (v1 instanceof StringVal) {
	    	return stringEvaluate((StringVal) v1, env);
	    }else if (v1 instanceof ListVal) {
    		return listEvaluate((ListVal) v1, env);
	    }
	     
	 	
	     return null;
	 }
 
 
	 private Value intEvaluate(IntVal num1, Environment env) {
//	     IntVal num1 = (IntVal) e1.evaluate(env);
	     IntVal num2 = (IntVal) e2.evaluate(env);
	     if(this.op == Op.ADD) {
	         return new IntVal(num1.toInt() + num2.toInt());
	     }else if (this.op == Op.SUBTRACT) {
	         return new IntVal(num1.toInt()-num2.toInt());
	     }else if (this.op == Op.MULTIPLY) {
	         return new IntVal(num1.toInt()*num2.toInt());
	     }else if (this.op == Op.DIVIDE) {
	         return new IntVal(num1.toInt()/num2.toInt());
	     }else if (this.op == Op.MOD) {
	         return new IntVal(num1.toInt()%num2.toInt());
	     }else if (this.op == Op.GE) {
	         return new BoolVal(num1.toInt() >= num2.toInt());
	     }else if (this.op == Op.GT) {
	         return new BoolVal(num1.toInt() > num2.toInt());
	     }else if (this.op == Op.LE) {
	         return new BoolVal(num1.toInt() <= num2.toInt());
	     }else if (this.op == Op.LT) {
	         return new BoolVal(num1.toInt() < num2.toInt());
	     }   
	     return null;
	 }
	 
	 private Value stringEvaluate(StringVal v1, Environment env) {
		 Value v2 = e2.evaluate(env);
		 if (this.op == Op.ADD) {
			 return new StringVal(v1.toString() + v2.toString());
		 }
		 else if(this.op == Op.MULTIPLY) {
			 IntVal i2 = (IntVal) v2;
			 String str = "";
			 for(int i=0; i<i2.toInt(); i++) {
				 str += v1.toString();
			 }
			 return new StringVal(str);
		 }
		 return null;
	 }
	 
	 private Value listEvaluate(ListVal lv1, Environment env) {
		 if(this.op == Op.ADD) {
			ListVal lv2 = (ListVal) e2.evaluate(env);
			List<Value> l1 = lv1.getList();
			List<Value> l2 = lv2.getList();
			List<Value> l3 = new ArrayList<>();
			l3.addAll(l1);
			l3.addAll(l2);
			return new ListVal(l3);
		 }else if(this.op == Op.MULTIPLY) {
			 IntVal i2 = (IntVal) e2.evaluate(env);
			 List<Value> l1 = lv1.getList();
			 List<Value> l3 = new ArrayList<>();
			 for(int i=0; i<i2.toInt(); i++) {
				 l3.addAll(l1);
			 }
			 return new ListVal(l3);
		 }
		 return null;
	 }
 
}

class BoolOpExpr implements Expression {
	private BoolOp bop;
	private Expression e1;
	private Expression e2;	

	public BoolOpExpr(BoolOp bop, Expression e1, Expression e2) {
		super();
		this.e1 = e1;
		this.e2 = e2;
		this.bop = bop;
	}

	@Override
	public Value evaluate(Environment env) {
		// TODO Auto-generated method stub
	     BoolVal b1 = (BoolVal) e1.evaluate(env);
	     BoolVal b2 = (BoolVal) e2.evaluate(env);
	     if (this.bop == BoolOp.AND) {
	    	return new BoolVal(b1.toBoolean() && b2.toBoolean());
	     }else if (this.bop == BoolOp.OR) {
	    	 return new BoolVal(b1.toBoolean() || b2.toBoolean());
	     }		
		
		return null;
	}

}

class NotOpExpr implements Expression {
	private Expression e;

	public NotOpExpr(Expression e) {
		super();
		this.e = e;
	}

	@Override
	public Value evaluate(Environment env) {
	     BoolVal b = (BoolVal) e.evaluate(env);
	     return new BoolVal(!b.toBoolean());

	}
}

/**
 * Get value from List.
 * 
*/
class ListGetExpr implements Expression {
	private Expression e;
	public ListGetExpr(Expression e) {
		this.e = e;
	}
	@Override
	public Value evaluate(Environment env) {
		// TODO Auto-generated method stub
		IntVal i = (IntVal) e.evaluate(env);
		return i;
	}
 }


class ListSliceExpr implements Expression {
	private Expression e1;
	private Expression e2;
	private Expression e3;
	public ListSliceExpr(Expression e1, Expression e2, Expression e3) {
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
	}
	@Override
	public Value evaluate(Environment env) {
		// TODO Auto-generated method stub
		List<Value> list = new ArrayList<>();

		Value v1 = e1.evaluate(env);
		Value v2 = e2.evaluate(env);
		Value v3 = e3.evaluate(env);
		
		list.add(v1);
		list.add(v2);
		list.add(v3);

		return new ListVal(list);
	}
	
	

}
class ListExpr implements Expression {
	private Expression e1;
	private List<Expression> expList;
	
	public ListExpr(Expression e1, List<Expression> expList) {
		this.e1 = e1;
		this.expList = expList;
	}

	@Override
	public Value evaluate(Environment env) {
		// TODO Auto-generated method stub
		Value v1 = e1.evaluate(env);
		for(Expression exp: expList) {
			ListVal lv1 = (ListVal) v1;
			if(exp instanceof ListGetExpr) {
				IntVal index = (IntVal) exp.evaluate(env);
				v1 = lv1.get(index.toInt());
			}else if (exp instanceof ListSliceExpr) {
				ListVal lv2 = (ListVal) exp.evaluate(env);
				Value start = lv2.get(0);
				Value end 	= lv2.get(1);
				Value slice = lv2.get(2);
				v1 = lv1.getSlice(start, end, slice);
			}
			
			
		}
		return v1;
	}
	
}


