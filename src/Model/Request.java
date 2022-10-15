package Model;

import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Request request = (Request) o;
        return Objects.equals(methodName, request.methodName) && Arrays.equals(parameters, request.parameters);
    }
}
