package ch.joelhaeberli.tkpbackend;

public class SystemMessage {

    private String message;
    private String nextStep;

    public SystemMessage(String message) {
        this.message = message;
    }

    public SystemMessage(String message, String nextStep) {
        this.message = message;
        this.nextStep = nextStep;
    }
}
