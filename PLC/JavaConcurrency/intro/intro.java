@NotThreadSafe
public class UnsafeSequence {
    private int value;

    public int getNext() {
        return this.value++;
    }

    public static void main(String[] args) {
        usSeq = new UnsafeSequence();
        String teste = usSeq.getNext();
        System.Out.println("Contador não-seguro: \n");
    }
}