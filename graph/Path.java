package graph;

import java.util.ArrayList;

class Path implements Comparable<Path> {
    ArrayList<Integer> path;
    int cost;
    public Path(ArrayList<Integer> nodes, int w) {
        this.path = new ArrayList<Integer>(nodes);
        this.cost = w;
    }

    public int compareTo(Path p) {
        return this.cost - p.getCost();
    }

    public int getCost() {
        return this.cost;
    }

    public ArrayList<Integer> getPath() {
        ArrayList<Integer> p = new ArrayList<Integer>(this.path);
        return p;
    }

    public void setPath(ArrayList<Integer> p) {
        this.path.addAll(p);
    }

    public void setCost(int w) {
        this.cost = w;
    }

    public void addNode(int n) {
        this.path.add(n);
    }

    public String toString() {
        return new String("" + this.cost + " " + this.path + "");
    }
}
