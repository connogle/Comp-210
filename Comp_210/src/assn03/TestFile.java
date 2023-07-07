package assn03;

public class TestFile {
    public static void main(String[] args) {
        LinkedList list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.toString();

        LinkedList list2 = new LinkedList<Integer>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        // System.out.println(list.isEqual(list2));
        System.out.println(list.isEqual(list));
        // list.removeAtIndex(3);
        System.out.println(list.toString());
        list.removeRepeats();
        // list2.reverse();
        // System.out.println(list2.toString());

        // list.merge(list2);
        System.out.println(list.toString());
    }
}
