import java.util.ArrayList;

public class Ka2023_4 {
    public static int coin = 4;
    public static int[] cards = {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};

    public static int answer;
    public static int n;
    public static void main(String[] args) {
        System.out.println(solution(coin, cards));
    }

    public static int solution(int coin, int[] cards){
        answer = 0;
        ArrayList<Integer> userCard = new ArrayList<>();

        n = cards.length;
        // 첫 시작 n/3 개 카드 분배
        for (int i = 0; i < n/3; i++) {
            userCard.add(cards[i]);
        }
        int target = n+1;
        int nowIndex = n/3;

        game(cards, target, 1, coin, nowIndex, n, userCard);

        return answer;
    }

    public static void game(int[] cards, int target, int round, int coin, int now, int count, ArrayList<Integer> userCard){
        if(now == n-1 || count == 0){ // 남은 카드 수 없으면
            answer = Math.max(answer, round);
            return;
        }
        // 받을 두장
        answer = Math.max(answer, round);
        int firstCard = cards[now];
        int secondCard = cards[now+1];


        for (int i = 0; i < userCard.size()-1; i++) {
            int first = userCard.get(i);
            for (int j = i; j < userCard.size(); j++) {
                int second = userCard.get(j);

                if(first + second == target && now + 2 <= n-1){
                    // target 달성되고, now index가 배열의 길이보다 작다면
                    ArrayList<Integer> user = new ArrayList<>();

                    for (int k = 0; k < userCard.size(); k++) {
                        if(userCard.get(k) != first && userCard.get(k) != second){
                            user.add(userCard.get(k));
                        }

                    }
                    System.out.println(user);
                    game(cards, target, round+1, coin, now+2, user.size(), user);

                }

            }
        }

        if(coin == 1){
            userCard.add(firstCard);

            for (int i = 0; i < userCard.size()-1; i++) {
                int first = userCard.get(i);
                for (int j = i; j < userCard.size(); j++) {
                    int second = userCard.get(j);

                    if(first + second == target && now + 2 <= n-1){
                        // target 달성되고, now index가 배열의 길이보다 작다면
                        ArrayList<Integer> user = new ArrayList<>();

                        for (int k = 0; k < userCard.size(); k++) {
                            if(userCard.get(k) != first && userCard.get(k) != second){
                                user.add(userCard.get(k));
                            }
                        }
                        game(cards, target, round+1, coin, now+2, user.size(), user);
                    }

                }
            }

            userCard.add(secondCard);
            userCard.remove(Integer.valueOf(firstCard));
            for (int i = 0; i < userCard.size()-1; i++) {
                int first = userCard.get(i);
                for (int j = i; j < userCard.size(); j++) {
                    int second = userCard.get(j);

                    if(first + second == target && now + 2 <= n-1){
                        // target 달성되고, now index가 배열의 길이보다 작다면
                        ArrayList<Integer> user = new ArrayList<>();

                        for (int k = 0; k < userCard.size(); k++) {
                            if(userCard.get(k) != first && userCard.get(k) != second){
                                user.add(userCard.get(k));
                            }
                        }
                        game(cards, target, round+1, coin, now+2, user.size(), user);

                    }

                }
            }

            userCard.remove(Integer.valueOf(secondCard));
        }else if(coin >= 2){
            userCard.add(firstCard);
            for (int i = 0; i < userCard.size()-1; i++) {
                int first = userCard.get(i);
                for (int j = i; j < userCard.size(); j++) {
                    int second = userCard.get(j);

                    if(first + second == target && now + 2 <= n-1){
                        // target 달성되고, now index가 배열의 길이보다 작다면
                        ArrayList<Integer> user = new ArrayList<>();

                        for (int k = 0; k < userCard.size(); k++) {
                            if(userCard.get(k) != first && userCard.get(k) != second){
                                user.add(userCard.get(k));
                            }
                        }
                        game(cards, target, round+1, coin, now+2, user.size(), user);
                    }

                }
            }

            userCard.add(secondCard);
            userCard.remove(Integer.valueOf(firstCard));
            for (int i = 0; i < userCard.size()-1; i++) {
                int first = userCard.get(i);
                for (int j = i; j < userCard.size(); j++) {
                    int second = userCard.get(j);

                    if(first + second == target && now + 2 <= n-1){
                        // target 달성되고, now index가 배열의 길이보다 작다면
                        ArrayList<Integer> user = new ArrayList<>();

                        for (int k = 0; k < userCard.size(); k++) {
                            if(userCard.get(k) != first && userCard.get(k) != second){
                                user.add(userCard.get(k));
                            }
                        }
                        game(cards, target, round+1, coin, now+2, user.size(), user);

                    }

                }
            }

            userCard.add(firstCard);
            for (int i = 0; i < userCard.size()-1; i++) {
                int first = userCard.get(i);
                for (int j = i; j < userCard.size(); j++) {
                    int second = userCard.get(j);

                    if(first + second == target && now + 2 <= n-1){
                        // target 달성되고, now index가 배열의 길이보다 작다면
                        ArrayList<Integer> user = new ArrayList<>();

                        for (int k = 0; k < userCard.size(); k++) {
                            if(userCard.get(k) != first && userCard.get(k) != second){
                                user.add(userCard.get(k));
                            }
                        }
                        game(cards, target, round+1, coin, now+2, user.size(), user);
                    }

                }
            }

        }


    }
}
