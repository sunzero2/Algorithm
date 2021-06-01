package programmers_202010601.test_42576;

/*
* 42576 완주하지 못한 선수
* */
public class Main {
    public static void main(String[] args) {
//        String[] participant = {"leo", "kiki", "eden"};
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"eden", "kiki"};
        String[] completion = {"stanko", "ana", "mislav"};

        Solution solution = new Solution();
        String answer = solution.solution(participant, completion);

        System.out.println(answer);
    }
}
