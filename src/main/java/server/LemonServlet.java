package server;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月27日 11:51 下午
 */
public class LemonServlet extends HttpServlet {

    @Override
    public void doGet(Request request, Response response) {

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String content = "<h1>LemonServlet get</h1>";
        try {
            response.output(HttpProtocolUtil.getHttpHeader200(
                    content.getBytes(StandardCharsets.UTF_8).length)
                    + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(Request request, Response response) {
        String content = "<h1>LemonServlet post</h1>";

        try {
            response.output(HttpProtocolUtil.getHttpHeader200(
                    content.getBytes(StandardCharsets.UTF_8).length)
                    + content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void destory() throws Exception {

    }
}
