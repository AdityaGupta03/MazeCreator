package Model;

/**
 * Class that models responses sent from server to client
 */
public class Response {
    private boolean error;
    private Object[] responseValue;
    private String errorMessage;

    public Response(boolean error, Object[] responseValue) {
        this.error = error;
        this.responseValue = responseValue;
    }

    public Response(boolean error, String errorMessage) {
        this.error = error;

        if (errorMessage == null)
            this.errorMessage = "Sorry, an error occurred. Please try again!";
        else
            this.errorMessage = errorMessage;
    }

    public Response(boolean error) {
        this.error = error;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object[] getResponseValue() {
        return responseValue;
    }

    public void setResponseValue(Object[] responseValue) {
        this.responseValue = responseValue;
    }
}
