public class ContactList {

    private String author_id;
    private String display_name;
    private String phone_number;
    private float create_date;

    public ContactList(){}

    public ContactList(String author_id, String display_name, String phone_number, long create_date) {
        this.author_id = author_id;
        this.display_name = display_name;
        this.phone_number = phone_number;
        this.create_date = create_date;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public float getCreate_date() {
        return create_date;
    }

    public void setCreate_date(float create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "ContactList{" +
                "author_id='" + author_id + '\'' +
                ", display_name='" + display_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", create_date=" + create_date +
                '}';
    }
}
