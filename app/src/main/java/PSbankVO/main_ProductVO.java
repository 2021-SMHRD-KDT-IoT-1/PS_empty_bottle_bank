package PSbankVO;

public class main_ProductVO {

    private int machine_num;
    private int main_list_img;
    private String machine_name;
    private String storable_bottle;
    private String broken;


    public main_ProductVO(int machine_num, int main_list_img, String machine_name, String storable_bottle, String broken) {
        this.machine_num = machine_num;
        this.main_list_img = main_list_img;
        this.machine_name = machine_name;
        this.storable_bottle = storable_bottle;
        this.broken = broken;
    }

    public int getMachine_num() {
        return machine_num;
    }

    public void setMachine_num(int machine_num) {
        this.machine_num = machine_num;
    }

    public int getMain_list_img() {
        return main_list_img;
    }

    public void setMain_list_img(int main_list_img) {
        this.main_list_img = main_list_img;
    }

    public String getMachine_name() {
        return machine_name;
    }

    public void setMachine_name(String machine_name) {
        this.machine_name = machine_name;
    }

    public String getStorable_bottle() {
        return storable_bottle;
    }

    public void setStorable_bottle(String storable_bottle) {
        this.storable_bottle = storable_bottle;
    }

    public String getBroken() {
        return broken;
    }

    public void setBroken(String broken) {
        this.broken = broken;
    }


}
