 import java.util.*;

// to keep the position of every player in the board
 public class Board {

    List<Integer> cells;
    public Board(List<Integer> cells) {
        this.cells = cells;
    }

    public List<Integer> getCells() {
        return this.cells;
    }

 }