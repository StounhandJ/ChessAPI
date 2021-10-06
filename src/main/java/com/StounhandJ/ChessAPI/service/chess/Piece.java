package com.StounhandJ.ChessAPI.service.chess;

public class Piece {

    private Integer x;

    private Integer y;

    public Piece(Integer x, Integer y) {
        this.x = x;
        this.y = y;
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

    //</editor-fold>

    //<editor-fold desc="Check">

    public boolean isCoordinates(Integer x, Integer y) {
        return this.getCoordinateX().equals(x) && this.getCoordinateY().equals(y);
    }

    //</editor-fold>

//    public Integer oldX;
//
//
//    public Integer oldY;
//
//
//    public Integer newX;
//
//
//    public Integer newY;
//
//
//    public Integer player;
//
//
//    public Area area;
//
//
//    ChessPiece(Integer x, Integer y, Integer player, Area area) {
//        this.oldX = x;
//        this.oldY = y;
//        this.newX = 0;
//        this.newY = 0;
//        this.player = player;
//        this.area = area;
////        this.area = new area(area);
//    }
//
//
//    public boolean move(Integer x, Integer y) {
//        if (x > 7 || x < 0 || y > 7 || y < 0) return false;
//        this.newX = x;
//        this.newY = y;
//        this.area.checkEnd(this.player, Checkmate = true);
//        if (!this.area.endGame && this.check()) {
//            if (this.checkEnemyFigure(x, y)) {
//                this.area.deletePiece(x, y);
//            }
//            this.area.movePiece(this.oldX, this.oldY, x, y);
//            this.area.checkEnd(this.player == 1 ? 2 : 1, Checkmate = true);
//            return true;
//        }
//        return false;
//    }
//
//
//    public boolean checkRoadTwo(Integer startX, Integer startY, Integer endX, Integer endY, Integer x, Integer y) {
//        if (x.equals(endX) && y.equals(endY)) return true;
//        int PX = (endX - startX);
//        int PY = (endY - startY);
//        int dotProduct = (x - startX) * (endX - startX) + (y - startY) * (endY - startY);
//        int squaredLength = (endX - startX) * (endX - startX) + (endY - startY) * (endY - startY);
//        return ((x - startX) / PX != (y - startY) / PY) || (dotProduct < 0 || dotProduct > squaredLength) || ((startX.equals(x)) || (startY.equals(y)));
//    }
//
//
//    public boolean checkRoad() {
//        foreach(this.area.area as mas)
//        {
//            Integer x = mas["coordinates"][0];
//            Integer y = mas["coordinates"][1];
//
//            int PX = (this.newX - this.oldX);
//            int PY = (this.newY - this.oldY);
//
//            if (this.checkFriendlyFigure(this.newX, this.newY)) {
//                return false;
//            } else if (PX == 0 || PY == 0) {
//                Integer[] interim = this.newX > this.oldX ?
//                        new Integer[]{this.newX, this.oldX} :
//                        new Integer[]{this.oldX, this.newX};
//                Integer maxX = interim[0];
//                Integer minX = interim[1];
//                interim = this.newY > this.oldY ?
//                        new Integer[]{this.newY, this.oldY} :
//                        new Integer[]{this.oldY, this.newY};
//                Integer maxY = interim[0];
//                Integer minY = interim[1];
//                if (((!maxX.equals(minX)) && (minX < x && x < maxX) && (y.equals(this.newY))) || ((!maxY.equals(minY)) && (minY < y && y < maxY) && (x.equals(this.newX)))) {
//                    return false;
//                }
//            } else {
//                if (this.checkEnemyFigure(this.newX, this.newY)) {
//                    for (Map<String, List<Integer>> varList : this.area.area) {
//                        if (!this.checkRoadTwo(this.oldX, this.oldY, this.newX, this.newY, varList["coordinates"][0], varList["coordinates"][1])) {
//                            return false;
//                        }
//                    }
//                }
//                int dotProduct = (x - this.oldX) * (this.newX - this.oldX) + (y - this.oldY) * (this.newY - this.oldY);
//                int squaredLength = (this.newX - this.oldX) * (this.newX - this.oldX) + (this.newY - this.oldY) * (this.newY - this.oldY);
//                if ((x - this.oldX) / PX == (y - this.oldY) / PY && !(dotProduct < 0 || dotProduct > squaredLength) && !this.checkEnemyFigure(this.newX, this.newY) && (!this.oldX.equals(x) && !this.oldY.equals(y))) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//
//    public boolean checkEnemyFigure(Integer x, Integer y) {
//        foreach(this.area.area as mas)
//        {
//            if (mas["coordinates"][0] == x && mas["coordinates"][1] == y && this.player != mas["player"]) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    public boolean checkFriendlyFigure(Integer x, Integer y) {
//        foreach(this.area.area as mas)
//        {
//            if (mas["coordinates"][0] == x && mas["coordinates"][1] == y && this.player == mas["player"]) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    public void getPossibleMoves() {
//        List<List<Integer>> mas;
//        newX = this.newX;
//        newY = this.newY;
//        for (x = 0; x < 8; x++) {
//            for (y = 0; y < 8; y++) {
//                this.newX = x;
//                this.newY = y;
//                if (this.check()) {
//                    mas[]=[x, y];
//                }
//            }
//        }
//        this.newX = newX;
//        this.newY = newY;
//        return mas;
//    }
//
//
//    public void checkShahGame() {
//        areaL = clone this.area;
//        if (this.checkEnemyFigure(this.newX, this.newY)) {
//            areaL.deletePiece(this.newX, this.newY);
//        }
//        areaL.movePiece(this.oldX, this.oldY, this.newX, this.newY);
//        areaL.checkEnd(this.player);
//        return areaL.event != "";
//    }
//
//    abstract public public void check(CheckShah =true);
}
