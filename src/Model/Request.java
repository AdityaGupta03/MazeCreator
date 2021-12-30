package Model;

/**
 * Class that models requests sent from client to server
 */
public class Request {
    private String methodName;
    private Object[] parameters;

    public Request(String methodName, Object[] parameters) {
        this.methodName = methodName;
        this.parameters = parameters;
    }

    public Request(String methodName) {
        this.methodName = methodName;
        this.parameters = null;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
