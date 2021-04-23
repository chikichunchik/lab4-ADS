import BinaryHeap.BinaryHeap;

public class Main {
    public static void main(String[] args){
        BinaryHeap<Integer> test = new BinaryHeap<Integer>();
        long startTime;

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            test.add(i);
        }
        System.out.println("Time to add 100000 elements: " + (System.currentTimeMillis() - startTime) + " ms" );

        startTime = System.currentTimeMillis();
        test.add(-1);
        System.out.println("Time to add element to the bottom of tree: "
                + (System.currentTimeMillis() - startTime) + " ms" );

        startTime = System.currentTimeMillis();
        test.add(100000);
        System.out.println("Time to add element to the top of tree: "
                + (System.currentTimeMillis() - startTime) + " ms" );

        startTime = System.currentTimeMillis();
        test.remove(-1);
        System.out.println("Time to delete element from the bottom of tree: "
                + (System.currentTimeMillis() - startTime) + " ms" );

        startTime = System.currentTimeMillis();
        test.remove(100000);
        System.out.println("Time to delete element from the top of tree: "
                + (System.currentTimeMillis() - startTime) + " ms" );

        startTime = System.currentTimeMillis();
        test.find(99999);
        System.out.println("Time to find element in the top of tree: "
                + (System.currentTimeMillis() - startTime) + " ms" );

        startTime = System.currentTimeMillis();
        test.find(0);
        System.out.println("Time to find element in the bottom of tree: "
                + (System.currentTimeMillis() - startTime) + " ms" );

        startTime = System.currentTimeMillis();
        test.getSortedList();
        System.out.println("Time to sort: " + (System.currentTimeMillis() - startTime) + " ms" );
    }
}
