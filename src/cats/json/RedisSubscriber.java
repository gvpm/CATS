/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cats.json;

import cats.json.JsonInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 *
 * @author gvpm
 */
public class RedisSubscriber {

    String server;
    String channelIn;

    public RedisSubscriber(String server, String channel) {
        this.channelIn = channel;
        this.server = server;

    }

    public void waitingMessage() {

        System.out.println("\nWaiting for a Publish in Redis with Configuration");
        System.out.println("Server: " + server);
        System.out.println("Channel: " + channelIn);

    }

    public void run() {
        Jedis jedis = new Jedis(server);

        String channel = channelIn;
        System.out.println("Waiting for a Publish in Redis with Configuration");
        System.out.println("Server: " + server);
        System.out.println("Channel: " + channelIn);

        while (true) {
            jedis.subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    super.onMessage(channel, message);
                    System.out.println("Received message:\n\n" + message);
                    Process p;
                    String s;
                    try {
                        //executar shell command
                        UUID guid = java.util.UUID.randomUUID();

                        File file = new File("run.sh");
                        System.out.println("\n\nFolder to be created: " + guid);
                        System.out.println("\n-- Attempt to run simulation script --\n");
                        Runtime.getRuntime().exec("chmod +x" + file.getAbsolutePath());

                        p = Runtime.getRuntime().exec(new String[]{file.getAbsolutePath(), message, guid.toString()});

                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(p.getInputStream()));
                        while ((s = br.readLine()) != null) {
                            System.out.println(s);
                        }
                        p.waitFor();
                        System.out.println("Script exit value: "+p.exitValue());
                        p.destroy();

                        System.out.println("\n-- Succes on running simulation script --\n");
                        waitingMessage();
                    } catch (IOException ex) {
                        Logger.getLogger(RedisSubscriber.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Error on executing script");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RedisSubscriber.class.getName()).log(Level.SEVERE, null, ex);
                    }

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
