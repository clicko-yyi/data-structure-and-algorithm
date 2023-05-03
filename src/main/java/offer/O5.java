package offer;

public class O5 {

    public static void main(String[] args) {
        String x = "We are happy.";


        O5 test = new O5();
        System.out.println(test.replaceSpace(x));
    }

    public String replaceSpace(String s) {
        final String replace = "%20";

        StringBuffer sb = new StringBuffer();

        for (char c : s.toCharArray()) {
            if(c == ' '){
                sb.append(replace);
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }


    public String replaceSpace_sulotion_2(String s) {
        int size = 0;
        char[] ret = new char[s.length() * 3];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                ret[size++] = '%';
                ret[size++] = '2';
                ret[size++] = '0';
            } else {
                ret[size++] = c;
            }
        }
        return new String(ret, 0, size);
    }
}
