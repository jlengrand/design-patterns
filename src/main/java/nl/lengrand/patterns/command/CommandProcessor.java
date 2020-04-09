package nl.lengrand.patterns.command;

import nl.lengrand.patterns.command.commands.Command;

import java.util.*;

public class CommandProcessor implements Runnable {

    private Queue<Command> queue;
    private boolean running = false;

    public CommandProcessor(Queue queue){
        this.queue = queue;
    }

    public void start(){
        System.out.println("Starting processor");
        this.running = true;
        this.run();
    }

    public void stop(){
        this.running = false;
    }

    @Override
    public void run() {
        while(!queue.isEmpty()){
            // Command Processors process items in the queue as fast as possible
            var item = queue.poll();
            if(item != null) item.execute();
            System.out.println(queue.size() + " items left in queue");
        }

    }
}
