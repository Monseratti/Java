package Classes;

public class Answer {
    private int id;
    private String content;
    private int question_id;
    private boolean is_correct;
    public Answer() {
        this.id = 0;
        this.content = "";
        this.question_id = 0;
        this.is_correct = false;
    }
    public Answer(int id, String content, int question_id, boolean is_correct) {
        this.id = id;
        this.content = content;
        this.question_id = question_id;
        this.is_correct = is_correct;
    }
    public int getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public int getQuestion_id() {
        return question_id;
    }
    public boolean getIs_correct() {
        return is_correct;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }
    public void setIs_correct(boolean is_correct) {
        this.is_correct = is_correct;
    }
}
