package cn.com.collection;

public class TestMyLinkedList<T> {
    private Node first;
    private Node last;
    private int size;
    //增加节点
    public void add(int index,T obj) {
        if (index < 0 || index >size) {
            throw new RuntimeException("下标越界："+index);
        }
        Node newNode = new Node(obj);
        Node temp = getNode(index);
        if (temp != null) {
            if (index == 0 ) {
                //第一个节点
                newNode.next = temp;
                temp.previous = newNode;
                newNode.previous = null;
                first = newNode;
            }
            if (index == size  ) {
                //最后一个节点
                newNode.previous = temp;
                temp.next = newNode;
                newNode.next = null;
                last = newNode;
            }
            if (index> 0 && index < size) {
                Node up = temp.previous;
                Node down = temp.next;

                up.next = newNode;
                newNode.previous = up;


                newNode.next = temp;
                temp.previous = newNode;
            }

            size++;
        }
    }
    public void checkIndex(int index) {
        if (index <0 || index >= size) {
            throw new RuntimeException("删除位置不合法："+index);
        }
    }
    public void remove(int index) {
        checkIndex(index);
        Node  tmp = getNode(index);
        if (tmp != null) {
            Node up = tmp.previous;
            Node down = tmp.next;
            if (index == 0) {
                first = down;
            }
            if (index == size -1) {
                last = up;
            }
            if (up != null) {
                up.next = down;
            }
            if (down != null) {
                down.previous = up;
            }

            size--;
        }
    }

    public T get(int index) {

        //z,x,c
      Node tmp = getNode(index);

        return  tmp != null ? (T) tmp.element : null;
    }
    public Node getNode(int index) {

        Node tmp = null;
        if (index <= (size>>1)) {
            tmp = first;
            for (int i = 0; i <index ; i++) {
                tmp = tmp.next;
            }
        }else {
            tmp = last;
            for (int i = size -1; i >index ; i--) {
                tmp = tmp.previous;
            }
        }
        return tmp;
    }
    public void add(T object) {
        Node node = new Node(object);
        if (first == null) {
            first = node;
            last = node;
        }
        node.previous = last;
        last.next = node;
        node.next = null;
        last = node;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node tmp = first;
        while(tmp != null) {
            sb.append(tmp.element+",");
            tmp = tmp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        TestMyLinkedList<String> tl = new TestMyLinkedList<>();
        tl.add("z");
        tl.add("x");
        tl.add("c");
        tl.add("v");
        tl.add("b");
        tl.add("n");
        System.out.println(tl);
//        System.out.println(tl.get(2));
//        System.out.println(tl.get(0));
//        System.out.println(tl.get(3));
//        System.out.println(tl.get(4));
//        System.out.println(tl.get(4));
//        tl.add(0,"小军");
//        System.out.println(tl);
//        tl.add(0,"白");
//        System.out.println(tl);
//        tl.add(2,"红");
//        System.out.println(tl);
        tl.add(0,"名");
        System.out.println(tl);
        tl.add(7,"Hong");
        System.out.println(tl);
        tl.add(1,"小芳");
        System.out.println(tl);
        tl.add(9,"10");
        System.out.println(tl);
        System.out.println(tl.get(1));
    }
}
