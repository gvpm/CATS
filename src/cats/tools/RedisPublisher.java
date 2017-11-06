/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cats.tools;

import java.util.Scanner;
import redis.clients.jedis.Jedis;

public class RedisPublisher {

    public static void main(String args[]) {
        Jedis jedis = new Jedis("localhost");

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter the channel name:");
        String channel = scanner.nextLine();
        System.out.println("Starting publisher for channel " + channel);

        while (true) {
            System.out.println("Enter the string to Publish:");
            String msg = scanner.nextLine();
            jedis.publish(channel, msg);

        }
    }
}
