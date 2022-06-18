package graph;

import java.util.*;

//class untuk menyimpan graf dengan matriks ketetanggaan
class Graf {
  int nodes; // jumlah simpul
  String[] label;
  int[][] graf; // matriks ketentanggaan

  //Graph Constructor
  public Graf(int n, int[][] l )
  {
    this.nodes = n;
    this.graf = new int[n][n];
    this.label = new String[n];

    for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      graf[i][j]=l[i][j];
  }

  public Graf(int n)
  {
    this.nodes = n;
    graf=new int[n][n];
    this.label = new String[n];
    for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      graf[i][j]=0;
  }

  public void printMatriks()
  {
    if(this.nodes > 0){
      for(int i=0;i<this.nodes;i++){
        for(int j=0;j<this.nodes-1;j++){
          System.out.print(graf[i][j] + ", ");
        }
        System.out.println(graf[i][this.nodes-1]);
      }
    }
  }
  public int getNodes(){
    return this.nodes;
  }

  public void setLabel(String[] s){
    if(s.length >= this.nodes){
      for(int i=0;i<this.nodes;i++){
        this.label[i]=s[i];
      }
    }
  }

  public void setCost(int s, int d, int c){
    if(s < this.nodes && d < this.nodes){
      graf[s][d]=c;
      graf[d][s]=c;
    }
  }

  public int getCost(int s, int d)
  {
    if (s < this.nodes && d < this.nodes){
      return this.graf[s][d];
      } else {
      return 0;
    }
  }

  public int jmlTetangga(int v){
    int jml,d=0,n=0;
    n = getNodes();
    jml=0;
    if(v < n){
      for (int i=0; i<n;i++){
        if(this.graf[v][i] > 0) jml++;
      }
      return jml;
    }
    return 0;
  }

  public int[] getTetangga(int v){
    int jml=0,j=0;
    int[] tetangga;
    if(v < this.nodes){
      jml = this.jmlTetangga(v);
      if(jml > 0){
        tetangga = new int[jml];
        for (int i=0; i<this.nodes;i++){
          if(this.graf[v][i] != 0){
            tetangga[j] = i;
            j++;
          }
        }
        return tetangga;
      }
    }
    return null;
  }

  public String nodeLabel(int v) {
    String s;
    if(v < this.getNodes()) {
      s = new String(this.label[v]);
    } else s = new String("");
    return s;
  }

  Path algoDjikstra(int a, int z) {
    ArrayList<Path> jarak = new ArrayList<Path>();
    HashSet<Integer> unlabeled = new HashSet<Integer>();
    for(int i = 0; i < this.nodes; i++) {
      jarak.add(new Path(new ArrayList<Integer>(), Integer.MAX_VALUE));
      unlabeled.add(i);
    }
    jarak.get(a).setCost(0);
    jarak.get(a).addNode(a);
    HashSet<Integer> labeled = new HashSet<Integer>();
    while (!labeled.contains(z)) {
      int min = Integer.MAX_VALUE;
      int minNode = -1;
      for (int u : unlabeled) {
        if (jarak.get(u).getCost() <= min) {
          min = jarak.get(u).getCost();
          minNode = u;
        }
      }
      labeled.add(minNode);
      unlabeled.remove(minNode);
      for (int v : unlabeled) {
        if (getCost(minNode, v) > 0) {
          if (jarak.get(minNode).getCost() + getCost(minNode, v) < jarak.get(v).getCost()) {
            jarak.get(v).setCost(jarak.get(minNode).getCost() + getCost(minNode, v));
            jarak.get(v).setPath(jarak.get(minNode).getPath());
            jarak.get(v).addNode(v);
          }
        }
      }
    }
    return jarak.get(z);
  }
}
