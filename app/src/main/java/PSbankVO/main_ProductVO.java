package PSbankVO;

public class main_ProductVO {

    private int machine_num;
    private int main_list_img;
    private String main_list_tlt;
    private String main_list_text1;
    private String main_list_text2;
    private String main_list_text3;
    private String main_list_text4;


    public main_ProductVO(int machine_num, int main_list_img, String main_list_tlt, String main_list_text1, String main_list_text2, String main_list_text3, String main_list_text4) {
        this.machine_num = machine_num;
        this.main_list_img = main_list_img;
        this.main_list_tlt = main_list_tlt;
        this.main_list_text1 = main_list_text1;
        this.main_list_text2 = main_list_text2;
        this.main_list_text3 = main_list_text3;
        this.main_list_text4 = main_list_text4;
    }

    public int getMachine_num() {
        return machine_num;
    }

    public int getMain_list_img() {
        return main_list_img;
    }

    public String getMain_list_tlt() {
        return main_list_tlt;
    }

    public String getMain_list_text1() {
        return main_list_text1;
    }

    public String getMain_list_text2() {
        return main_list_text2;
    }

    public String getMain_list_text3() {
        return main_list_text3;
    }

    public String getMain_list_text4() {
        return main_list_text4;
    }

    //==========================

    public void setMachine_num(int machine_num) {
        this.machine_num = machine_num;
    }

    public void setMain_list_img(int main_list_img) {
        this.main_list_img = main_list_img;
    }

    public void setMain_list_tlt(String main_list_tlt) {
        this.main_list_tlt = main_list_tlt;
    }

    public void setMain_list_text1(String main_list_text1) {
        this.main_list_text1 = main_list_text1;
    }

    public void setMain_list_text2(String main_list_text2) {
        this.main_list_text2 = main_list_text2;
    }

    public void setMain_list_text3(String main_list_text3) {
        this.main_list_text3 = main_list_text3;
    }

    public void setMain_list_text4(String main_list_text4) {
        this.main_list_text4 = main_list_text4;
    }
}
