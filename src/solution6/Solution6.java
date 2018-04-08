package solution6;

/**
 * @author LinChangyi
 * @date 2018/4/8
 **/
public class Solution6 {
    public String convert(String s, int r) {
        if (s.length() == 0) {
            return "";
        }
        if(r<=1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int unit = 2 * r - 2;
        int rest = n % (2 * r - 2);
        for (int i = 0; i < r; ++i) {
            int k = 0;
            for (; k < n / unit; ++k) {
                sb.append(s.charAt(k * unit + i));
                if (i != 0 && i != r - 1) {
                    sb.append(s.charAt(k * unit + unit - i));
                }
            }
            if (rest > i) {
                sb.append(s.charAt(k * unit + i));
                if (i != 0 && i != r - 1 && rest > unit - i) {
                    sb.append(s.charAt(k * unit + unit - i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.convert("PAYPALISHIRING", 3));
    }
}
