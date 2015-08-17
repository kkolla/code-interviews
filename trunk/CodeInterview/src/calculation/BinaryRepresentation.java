package calculation;

public class BinaryRepresentation {
private static String ERROR = "ERROR";
    
    public String binaryRepresentation(String n) {
        String[] parts = n.split("\\.");
        if (parts.length > 2) return ERROR;

        int i = Integer.parseInt(parts[0]);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(i % 2);
            i /= 2;
        } while (i > 0);
        
        String binaryInteger = sb.reverse().toString();
        
        if (parts.length == 1) return binaryInteger;
        
        sb = new StringBuilder();
        double decimal = Double.parseDouble("." + parts[1]);
        do {
            if (sb.length() > 32) return ERROR;
            double d = decimal * 2;
            if (d >= 1.0) {
                sb.append(1);
                decimal = d - 1.0;
            } else {
                sb.append(0);
                decimal = d;
            }
        } while (decimal > 0.0);
        
        String binaryDecimal = sb.toString();
        return binaryInteger + (binaryDecimal.equals("0") ? "" : "." + binaryDecimal); 
    }
}
