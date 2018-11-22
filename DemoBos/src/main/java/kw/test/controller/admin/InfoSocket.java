package kw.test.controller.admin;

import io.jboot.Jboot;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * auther   kangwang
 */
@ServerEndpoint("/websocket/test")
public class InfoSocket {

    @OnOpen
        public void onOpen(){
            System.out.println("onOpen");
        }
        @OnClose
        public void onClose(){
            System.out.println("onClose");
        }
        @OnMessage
        public void onMessage(Session session, String msg){
            System.out.println("receive message : "+msg);
            if(session.isOpen()){
                try {
                    //发送消息的html页面
                    session.getBasicRemote().sendText(msg+"=================");
                    Jboot.me().getMq().publish(msg,"myChannel1");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
