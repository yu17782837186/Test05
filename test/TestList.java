package cn.com.collection;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collection;
        import java.util.List;

public class TestList {
    public static void main(String[] args) {
        test3();
    }
    public static void test1() {
        //测试容器
        Collection<String> m = new ArrayList<>();
        System.out.println(m.size());
        System.out.println(m.isEmpty());
        m.add("小红");
        m.add("小明");
        System.out.println(m.size());
        System.out.println(m.isEmpty());
        System.out.println(m.contains("小红"));
        System.out.println(m.contains("小白"));
        Object[] objects = m.toArray();
        System.out.println(Arrays.toString(objects));
        System.out.println(objects);
        m.remove("小红"); //这里的remove是移除  并没有删除对象
        System.out.println(m);
        m.clear();
        System.out.println(m);
    }
    public static void test2() {

        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        List<String > list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("dd");
        System.out.println("List1:"+list1);

        //把list1 放到list 中
        //list.addAll(list1);
        //移除交集

        //list.removeAll(list1);
        //取交集
        //list.retainAll(list1);
        System.out.println("List:"+list);
        //System.out.println(list.containsAll(list1));
        System.out.println(list.contains("bb"));
    }
    public static void test3() {
        List<String> list = new ArrayList<>();
        list.add("z");
        list.add("x");
        list.add("c");
        list.add("v");
        System.out.println(list);
        //可以在指定索引的位置上插入元素
        list.add(1,"小白");
        list.add(3,"小明");
        //可以删除指定位置的元素
        list.remove(1);
        list.remove(2);
        System.out.println(list);
        //set修改指定位置的元素
        list.set(1,"小军");
        list.set(2,"小丽");
        list.set(3,"小小");
        list.set(0,"天天");
        System.out.println(list);
        //得到指定位置的元素
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
