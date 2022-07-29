package practicetest;


public class test1_1 {

    public String solution(String X, String Y) {
        int[] check = new int[10];
        for (int i = 0; i <= 9; i++) {
            int cntX = count(X, i + "");
            int cntY = count(Y, i + "");
            check[i] = Math.min(cntX, cntY);
        }

        StringBuilder sb = new StringBuilder();
        boolean isEmpty = true;
        boolean hasOnlyZero = true;
        for (int i = 9; i >= 0; i--) {
            int cnt = check[i];
            if(cnt != 0){
                if(hasOnlyZero && i > 0) hasOnlyZero = false;
                if(isEmpty) isEmpty = false;
            }
            for (int j = 0; j < cnt; j++) sb.append(i);
        }
        if(isEmpty) return "-1";
        if(hasOnlyZero) return "0";
        return sb.toString();
    }

    static int count(String str, String target) {
        return str.length() - str.replace(target, "").length();
    }
}
