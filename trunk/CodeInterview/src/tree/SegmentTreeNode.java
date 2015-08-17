package tree;

public class SegmentTreeNode {
	public int start, end, max, count, sum, min;
	public SegmentTreeNode left, right;
	
	public SegmentTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public SegmentTreeNode(int start, int end, int count) {
		this(start, end);
		this.count = count;
	}
	
	public SegmentTreeNode(int start, int end, int count, int max) {
		this(start, end, count);
		this.max = max;
	}
}
