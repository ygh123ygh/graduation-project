package com.example.login.Component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
/**
 * @Auther: morou
 * @Description: websocket的具体实现类
 * 使用springboot的唯一区别是要@Component声明下，而使用独立容器是由容器自己管理websocket的，
 * 但在springboot中连容器都是spring管理的。
虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，
所以可以用一个静态set保存起来。
 */

@ServerEndpoint(value = "/websocket/{nickname}")
@Component

public class WebSocket {
    //用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private String nickname;

    /**
     * 连接建立成功调用的方法
     */

    @OnOpen
    public void onOpen(Session session,@PathParam("nickname") String nickname) {
        this.session = session;
        this.nickname = nickname;

        webSocketSet.add(this);     //加入set中
        System.out.println("有新连接加入:"+nickname+",当前在线人数为" + webSocketSet.size());
      //  this.session.getAsyncRemote().sendText("恭喜您成功连接上WebSocket-->当前在线人数为："+webSocketSet.size());
    }

    /**
     *
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/

    @OnMessage
    public void onMessage(String message, Session session,@PathParam("nickname") Integer nickname) {
        System.out.println("来自客户端的消息-->"+nickname+": " + message);
      //群发消息

     if(nickname == 2){

         broadcast("<div class='chat_left_item_1 clearfix'>医师 </div>"+
                 "<div class='chat_left_item_2'>"+
                 "<div class=’chat_left_time clearfix‘></div>"+
                 "<div class='chat_left_content clearfix'>"+message+"</div>"
                 +"</div>");
     }else {
         broadcast("<div class='chat_right_item_1 clearfix'>用户</div>"+
                 "<div class='chat_right_item_2'>"+
                 "<div class=’chat_right_time clearfix‘></div>"+
                 "<div class='chat_right_content clearfix'>"+message+"</div>"
                 +"</div>");
     }










//    broadcast("<div class='chat_right_item_1 clearfix'>" +nickname+"</div>"+
//            "<div class='chat_right_item_2'>"+
//            "<div class=’chat_right_time clearfix‘></div>"+
//            "<div class='chat_right_content clearfix'>"+message+"</div>"
//            +"</div>");


    }

    /**
     * 发生错误时调用
     *
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }
    /**
     * 群发自定义消息
     * */
    public  void broadcast(String message){
        for (WebSocket item : webSocketSet) {
            //同步异步说明参考：http://blog.csdn.net/who_is_xiaoming/article/details/53287691
            //this.session.getBasicRemote().sendText(message);
            item.session.getAsyncRemote().sendText(message);//异步发送消息.
        }
    }
}
