package nl.lengrand.patterns.command;

import nl.lengrand.patterns.command.commands.Command;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CommandProcessor implements Runnable {

    private final Queue<Command> queue;
    private final AtomicBoolean running = new AtomicBoolean(true);

    public CommandProcessor(Queue queue){
        this.queue = queue;
    }

    public void stop(){
        System.out.println("Stopping CommandProcessor");
        this.running.set(false);
    }

    @Override
    public void run() {
        while(this.running.get()){
            // Command Processors process items in the queue as fast as possible
            var item = queue.poll();
            if(item != null) {
                item.execute();
            }
            else{
                System.out.println("Empty queue. Stopping Processor");
                this.stop();
            }
        }
        return;
    }
}
