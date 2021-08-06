package PSbankVO;

public class bottle_kongVO {

    private int bottle_king_img;
    private String bottle_king_round;
    private String bottle_king_id;
    private String bottle_king_score;


    public bottle_kongVO(int bottle_king_img, String bottle_king_round, String bottle_king_id, String bottle_king_score) {
        this.bottle_king_img = bottle_king_img;
        this.bottle_king_round = bottle_king_round;
        this.bottle_king_id = bottle_king_id;
        this.bottle_king_score = bottle_king_score;

    }

    public int getBottle_king_img() {
        return bottle_king_img;
    }

    public void setBottle_king_img(int bottle_king_img) {
        this.bottle_king_img = bottle_king_img;
    }


    public String getBottle_king_round() {
        return bottle_king_round;
    }

    public void setBottle_king_round(String bottle_king_round) { this.bottle_king_round = bottle_king_round; }


    public String getBottle_king_id() {
        return bottle_king_id;
    }

    public void setBottle_king_id(String bottle_king_id) {
        this.bottle_king_id = bottle_king_id;
    }


    public String getBottle_king_score() {
        return bottle_king_score;
    }

    public void setBottle_king_score(String bottle_king_score) { this.bottle_king_score = bottle_king_score; }


}
