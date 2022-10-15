package Service;

import Model.Response;
import Model.Request;

import java.lang.reflect.Method;

public class Service {
    private Request request;

    public Service() {

    }

    public void execute(Request request) {
        this.setRequest(request);
        try {
            Method method = Service.class.getMethod(request.getMethodName(), null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request) {
        if (this.request.equals(request))
            return;
        this.request = request;
    }
}
