public class cracklePop() {
  
  public static void main(String[] args) {
    cracklePop();
  }

  public static void cracklePop() {
    for(int i=0; i<=100; i++) {
      if (i%5 == 0 && i%3 == 0) {
        System.out.println("CracklePop");
      } else if (i%5 == 0) {
        System.out.println("Pop");
      } else if (i%3 == 0) {
        System.out.println("Crackle");
      } else {
        System.out.println(i);
      }
    }
  }
}