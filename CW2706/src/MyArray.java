public class MyArray implements IShow{
    int size;
    int[]elements;
    public MyArray(){
        this(1,1);
    }
    public MyArray(int size, int...elements){
        this.size = size;
        this.elements = new int[size];
        System.arraycopy(elements, 0, this.elements, 0, size);
    }
    @Override
    public void Print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int el : this.elements) {
            sb.append(el).append(',');
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        System.out.println(sb.toString());
    }
    @Override
    public void Print(String info) {
        System.out.println("Info: " + info);
        this.Print();
    }
}
