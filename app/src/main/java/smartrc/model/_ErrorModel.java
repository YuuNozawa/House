package smartrc.model;

public class _ErrorModel implements Model {
    private String head;
    private String body;

    public _ErrorModel(String head, String body) {
        this.head = head;
        this.body = body;
    }

    public String getHead() {
        return this.head;
    }
    
    public String getBody() {
        return this.body;
    }
}
