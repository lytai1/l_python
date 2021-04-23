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
     IntVal num1 = (IntVal) e1.evaluate(env);
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

class StringOpExpr implements Expression {
	private Op op;
	private Expression e1;
	private Expression e2;
	
	public StringOpExpr(Op op, Expression e1, Expression e2) {
		super();
		this.op = op;
		this.e1 = e1;
		this.e2 = e2;
	}

	@Override
	public Value evaluate(Environment env) {
        StringVal v1 = (StringVal) e1.evaluate(env);
        Value v2 = e2.evaluate(env);
        if (op == Op.ADD) {
            return new StringVal(v1.toString() + v2.toString());
        }
       return null;
	}
	
}

/**
 * Get value from List.
 * 
*/
class ListGetExpr implements Expression {
	private Expression e1;
	private Expression e2;
	public ListGetExpr(Expression e1, Expression e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	@Override
	public Value evaluate(Environment env) {
		// TODO Auto-generated method stub
		ListVal l = (ListVal) e1.evaluate(env);
		IntVal i = (IntVal) e2.evaluate(env);
		
		return l.get(i.toInt());
	}
 }

class ListOpExpr implements Expression {
	private Op op;
	private Expression e1;
	private Expression e2;
	public ListOpExpr(Op op, Expression e1, Expression e2) {
		super();
		this.op = op;
		this.e1 = e1;
		this.e2 = e2;
	}
	@Override
	public Value evaluate(Environment env) {
		// TODO Auto-generated method stub
		ListVal lv1 = (ListVal) e1.evaluate(env);
		Value v2 = e2.evaluate(env);
		
		if (v2 instanceof ListVal) {
			if(this.op == Op.ADD) {
				ListVal lv2 = (ListVal) v2;
				List<Value> l1 = lv1.getList();
				List<Value> l2 = lv2.getList();
				List<Value> l3 = new ArrayList<>();
				l3.addAll(l1);
				l3.addAll(l2);
				return new ListVal(l3);
			}
		} else if(v2 instanceof IntVal) {
			IntVal i2 = (IntVal) v2;
			List<Value> l1 = lv1.getList();
			return new ListVal(opToList(l1, i2, op));
			
		}
		
	     
		return null;
     }
	private List<Value> opToList(List<Value> l, IntVal i1, Op op) {
		List<Value> result = new ArrayList<>();
		
		for (Value v : l) {
			IntVal i2 = (IntVal) v;
			Value v3 = null;
			if(this.op == Op.ADD) {
		         v3 = new IntVal(i1.toInt() + i2.toInt());
		     }else if (this.op == Op.SUBTRACT) {
		    	 v3 =  new IntVal(i1.toInt()-i2.toInt());
		     }else if (this.op == Op.MULTIPLY) {
		    	 v3 =  new IntVal(i1.toInt()*i2.toInt());
		     }else if (this.op == Op.DIVIDE) {
		    	 v3 =  new IntVal(i1.toInt()/i2.toInt());
		     }else if (this.op == Op.MOD) {
		    	 v3 =  new IntVal(i1.toInt()%i2.toInt());
		     }else if (this.op == Op.GE) {
		    	 v3 =  new BoolVal(i1.toInt() >= i2.toInt());
		     }else if (this.op == Op.GT) {
		    	 v3 =  new BoolVal(i1.toInt() > i2.toInt());
		     }else if (this.op == Op.LE) {
		    	 v3 =  new BoolVal(i1.toInt() <= i2.toInt());
		     }else if (this.op == Op.LT) {
		    	 v3 =  new BoolVal(i1.toInt() < i2.toInt());
		     }
			result.add(v3);
		}
		
		return result;
	}
}

class ListSpliceExpr implements Expression {
	private Expression l;
	private Expression e1;
	private Expression e2;
	private Expression e3;
	public ListSpliceExpr(Expression l, Expression e1, Expression e2, Expression e3) {
		super();
		this.l = l;
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
	}
	@Override
	public Value evaluate(Environment env) {
		// TODO Auto-generated method stub
		ListVal lv = (ListVal) l.evaluate(env);
		List<Value> list = lv.getList();

		Value v1 = e1.evaluate(env);
		Value v2 = e2.evaluate(env);
		Value v3 = e3.evaluate(env);
		
		int i1 = 0;
		int i2 = list.size();
		int i3 = 1;
		
		if(v1 instanceof IntVal) {
			IntVal iv1 = (IntVal) v1;
			i1 = iv1.toInt();
		}
		if(v2 instanceof IntVal) {
			IntVal iv2 = (IntVal) v2;
			i2 = iv2.toInt();
		}
		if(v3 instanceof IntVal) {
			IntVal iv3 = (IntVal) v3;
			i3 = iv3.toInt();
		}
		list = list.subList(i1, i2);
		if (i3 == -1) {
			Collections.reverse(list);
		}

		return new ListVal(list);
	}
	
	

}



