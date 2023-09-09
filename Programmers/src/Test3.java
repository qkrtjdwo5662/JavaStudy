import java.util.*;

public class Test3 {
    public static void main(String[] args) {

        String s1 = "1234";
        String s2 = "1234";
        String s3 = "12345";


        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s3));

        StringBuilder sb = new StringBuilder();
        sb.append("1");
        sb.append("2");
        sb.append("3");
        System.out.println(sb.toString());

        int a = 7;
        System.out.println(String.valueOf(7));
        System.out.println(Integer.toString(a, 2));
        System.out.println(Integer.toString(a, 3));
        System.out.println(Integer.toString(a, 4));
        System.out.println(Integer.toString(a, 5));

        String binaryA = Integer.toString(a, 2);
        System.out.println(binaryA);
        System.out.println(Integer.parseInt(binaryA, 2));


        System.out.println(Integer.toString(a, 2)); // 2진수 표현
        System.out.println(Integer.parseInt(binaryA, 2)); // 2진수 -> 10진수


        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            deque.addLast(i);
        }
        while(!deque.isEmpty()){
            System.out.println(deque.pollFirst());
        }
        for (int i = 0; i < 4; i++) {
            deque.addLast(i);
        }
        while(!deque.isEmpty()){
            System.out.println(deque.pollLast());
        }

        // addLast() -> pollFirst() : Queue
        // addLast() -> pollLast() : Stack

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 4; i >=0; i--) {
            pq.add(i);
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 4; i++) {
            pq2.add(i);
        }
        while(!pq2.isEmpty()){
            System.out.println(pq2.poll());
        }

        // 크기가 가변적일때 sort정렬보다는 PriorityQueue를 쓰는것이 좋다.

        HashMap<String, Integer> hash = new HashMap<>();

        hash.put("a", 1);
        hash.put("b", 2);
        hash.put("c", 3);

        for (String key : hash.keySet()) {
            System.out.println(hash.get(key));
        }

        System.out.println(hash.containsKey("a"));
        System.out.println(hash.containsValue(1));

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.contains(2));

    }
}
