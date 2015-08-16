package tree;

import java.util.List;

public class ExpressionTreeBuild {
	public class ExpressionTreeNode {
		public String symbol;
		public ExpressionTreeNode left, right;
		public ExpressionTreeNode(String symbol) {
			this.symbol = symbol;
		}
	}
	
	private static class IntWrapper {
        int i;
        public IntWrapper(int i) {
            this.i = i;
        }
        public int get() {
            return this.i;
        }
        public void set(int i) {
            this.i = i;
        }
    }
    
    public ExpressionTreeNode build(String[] expression) {
        return build(ConvertExpressionToPolishNotation.convertToPN(expression), new IntWrapper(0));
    }
    
    public ExpressionTreeNode build(List<String> polishNotation, IntWrapper start) {
        int i = start.get();
        if (i == polishNotation.size()) return null;
        String expr = polishNotation.get(i);
        ExpressionTreeNode root = new ExpressionTreeNode(expr);
        start.set(i + 1);
        switch (expr) {
            case "+":
            case "-":
            case "*":
            case "/":
                root.left = build(polishNotation, start);
                root.right = build(polishNotation, start);
        }
        return root;
    }
}
