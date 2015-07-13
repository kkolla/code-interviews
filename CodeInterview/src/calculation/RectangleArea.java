package calculation;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 */
public class RectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a1 = (C - A) * (D - B);
        int a2 = (G - E) * (H - F);
        
        int overlapped = 0;
        
        if (!(A == C && B == D || E == G && F == H) &&
            (A <= E && C > E || E <= A && G > A) && (B <= F && D > F || F <= B && H > B)) {
            int w = Math.min(C, G) - (A <= E && C > E ? E : A);
            int h = Math.min(D, H) - (B <= F && D > F ? F : B);
            overlapped = w * h;
        }
        
        return overlapped == 0 ? a1 + a2 : a1 + a2 - overlapped;
    }

}
