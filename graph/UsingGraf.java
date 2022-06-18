package graph;

public class UsingGraf {
  
  
  public static void main(String[] args) {
    //
    Graf g,t;
    int[][] mt = 
     {{0,1,3,0,0,3},
      {1,0,5,1,0,0},
      {3,5,0,2,1,0},
      {0,1,2,0,4,0},
      {0,0,1,4,0,5},
      {3,0,0,0,5,0}};
    String[] labels = {"A","B","C","D","E","F"};
    g = new Graf(6,mt);
    t = new Graf(6);
    g.setLabel(labels);
    g.printMatriks();
    t.printMatriks();
    System.out.println("jarak terpendek dari a ke l adalah " + g.algoDjikstra(0, 11));
  }
}
