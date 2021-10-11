package com.StounhandJ.ChessAPI.service.chess;

public abstract class Piece {

    private Role role;

    private Integer x;

    private Integer y;

    public Piece(Integer x, Integer y, Role role) {
        this.x = x;
        this.y = y;
        this.role = role;
    }

    //<editor-fold desc="Get">

    public Integer[] getCoordinates() {
        return new Integer[]{this.x, this.y};
    }

    public Integer getCoordinateX() {
        return this.x;
    }

    public Integer getCoordinateY() {
        return this.y;
    }

    public Role getRole() {
        return role;
    }

    //</editor-fold>

    //<editor-fold desc="Set">

    public Piece setCoordinateX(Integer x) {
        this.x = x;
        return this;
    }

    public Piece setCoordinateY(Integer y) {
        this.y = y;
        return this;
    }

    public Piece setCoordinates(Integer x, Integer y) {
        this.setCoordinateX(x);
        this.setCoordinateY(y);
        return this;
    }

    public Piece setRole(Role role) {
        this.role = role;
        return this;
    }

    //</editor-fold>

    //<editor-fold desc="Check">

    public boolean isCoordinates(Integer x, Integer y) {
        return this.getCoordinateX().equals(x) && this.getCoordinateY().equals(y);
    }

    public abstract boolean isMoved(Integer x, Integer y);

    //</editor-fold>

    public abstract Piece clone();
}
