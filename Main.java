
class Main {
    public static void main(String[] args) {
        C1[] c1 = new C1[4];
       // c1[0] = new C2();
        c1[1] = new C2(5);
        c1[2] = new C1();
        c1[3] = new C1(4);
        for (int i=1; i<4; i++) {
            c1[i].print();
        }
    }
}
class C1 {
    C1() { System.out.println("C1"); }
    C1(int n) { System.out.println("C1 : " + n); }
    void print() { System.out.println("C1 print"); }
}
class C2 extends C1 {
    C2() { System.out.println("C2"); }
    C2(int n) { this(); System.out.println("C2 : " + n); }
    void print() { System.out.println("C2 print"); }
}