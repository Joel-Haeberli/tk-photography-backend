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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNextStep() {
        return nextStep;
    }

    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }
}
