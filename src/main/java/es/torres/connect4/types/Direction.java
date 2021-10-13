package es.torres.connect4.types;

public enum Direction {

        HORIZONTAL(0, 1), VERTICAL(1, 0), DIAGONAL_UP(1, 1), DIAGONAL_DOWN(-1, 1);

        public int row;
        public int col;

        Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
