package PSbankVO;

public class Store_productVO {


    private int item_code;      // 상품코드
    private int product_img;   // 상품이미지
    private String item_name ; //상품이름
    private String item_price; //가격
    private String item_count; //수량

    public int getItem_code() {
        return item_code;
    }

    public void setItem_code(int item_code) {
        this.item_code = item_code;
    }

    public int getProduct_img() {
        return product_img;
    }

    public void setProduct_img(int product_img) {
        this.product_img = product_img;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getItem_count() {
        return item_count;
    }

    public void setItem_count(String item_count) {
        this.item_count = item_count;
    }

    public Store_productVO(int item_code, int product_img, String item_name, String item_price, String item_count) {
        this.item_code = item_code;
        this.product_img = product_img;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_count = item_count;


    }

}
