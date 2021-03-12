package ch12.sample.s1.activeobject;

class DisplayStringRequest extends MethodRequest<Object> {
    private final String string;
    public DisplayStringRequest(Servant servant, String string) {
        super(servant, null);
        this.string = string;
    }
    public void execute() {
        servant.displayString(string);
    }
}
