public class LeaderBoardRow {
    int pos;
    String name;
    String score;

    public LeaderBoardRow(int pos, String name, String score) {
        this.pos = pos;
        this.name = name;
        this.score = score;
    }

    public int getPos() {
        return pos;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }
}
