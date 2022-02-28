package server;

/**
 * @Description: Servlet接口
 * @Author : Lemon-CS
 * @Date : 2022年02月27日 11:48 下午
 */
public interface Servlet {

    void init() throws Exception;

    void destory() throws Exception;

    void service(Request request,Response response) throws Exception;

}
