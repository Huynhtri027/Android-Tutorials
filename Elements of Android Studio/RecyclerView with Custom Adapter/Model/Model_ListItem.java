package recyclerview.recyclerview.Model;

public class Model_ListItem {

    private String head;
    private String desc;
    private String imageUrl;

    public Model_ListItem(String head, String desc, String imageUrl) {
        this.head = head;
        this.desc = desc;
        this.imageUrl = imageUrl;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageUrl(){
        return imageUrl;
    }

}
