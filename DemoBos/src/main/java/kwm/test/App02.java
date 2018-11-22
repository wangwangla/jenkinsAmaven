package kwm.test;


import io.jboot.Jboot;
import io.jboot.core.mq.JbootmqMessageListener;

/**
 * auther   kangwang
 */
public class App02 {
    public static void main(String[]args){
        Jboot.setBootArg("jboot.server.port", "8088");

       Jboot.run(args);
        Jboot.me().getMq().addMessageListener(new JbootmqMessageListener(){
            @Override
            public void onMessage(String channel, Object obj) {
                System.out.println(obj);
            }
        });
    }
}
