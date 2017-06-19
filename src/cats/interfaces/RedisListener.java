/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cats.interfaces;
import cats.json.JsonInterface;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 *
 * @author gvpm
 */
public class RedisListener {
    public static void main(String args[]) {
        Jedis jedis = new Jedis("localhost");
        
        
       
        String channel = "simular";
        System.out.println("Aguardando Configuração");
        
        ExecutorService es = Executors.newFixedThreadPool(10);

        while (true) {
            jedis.subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    super.onMessage(channel, message);
                    System.out.println("Received message:" + message);
                    String jsonAll1;
                    JsonInterface runner = new JsonInterface(message);
                    es.submit(runner);                    
                }

                @Override
                public void onSubscribe(String channel, int subscribedChannels) {
                }

                @Override
                public void onUnsubscribe(String channel, int subscribedChannels) {
                }

                @Override
                public void onPMessage(String pattern, String channel, String message) {
                }

                @Override
                public void onPUnsubscribe(String pattern, int subscribedChannels) {
                }
                
                @Override
                public void onPSubscribe(String pattern, int subscribedChannels) {
                }

            }, channel);
        }
    }
    
}
