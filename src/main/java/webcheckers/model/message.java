package webcheckers.model;

public class message {
    public String getText() {
        return text;
    }

    private String text;

    public Type getType() {
        return type;
    }

    private Type type;


    public enum Type {
        info, error
    }
    public message(String text, Type type){
        this.text = text;
        this.type = type;
    }
}
