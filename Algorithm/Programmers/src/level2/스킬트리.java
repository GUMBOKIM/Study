package level2;

public class 스킬트리 {
//    public static int solution(String skill, String[] skill_trees) {
//        int answer = 0;
//        for (String skillTree:skill_trees) {
//            System.out.println(skillTree);
//
//            if(check(skill, skillTree)) answer ++;
//        }
//        return answer;
//    }
//
//    static boolean check(String skill, String skillTree) {
//        boolean result = false;
//        int before = -1;
//        for (char c : skill.toCharArray()) {
//            int now = skillTree.indexOf(c, before);
//            if (now == -1) break;
//            if(now == -1 && now < before) {
//                result = true;
//                break;
//            }
//            before = now;
//        }
//        return result;
//    }

        public static int solution(String skill, String[] skill_trees) {
            int answer = skill_trees.length;

            for (int i = 0; i < skill_trees.length; i++) {
                if (skill.indexOf(skill_trees[i].replaceAll("[^"+ skill + "]", "")) != 0) {
                    answer--;
                }
            }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"CBADF", "AECB", "BDA"}));
    }
}
