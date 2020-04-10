package nl.lengrand.patterns.command;

import nl.lengrand.patterns.command.commands.Command;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/*
    Command Generators are unit that generate commands. Imagine anything requesting work to be done like sending emails, creating files, ....
 */
public class CommandGenerator {

    private Queue queue;
    private int id;
    private int intervalMs;
    private Timer timer;

    public CommandGenerator(int id, Queue queue, int intervalMs){
        this.queue = queue;
        this.id = id;
        this.intervalMs = intervalMs;

        this.timer = new Timer();
    }

    public void generate(){
        timer.schedule(new CommandTimerTask(id, queue), 0, intervalMs);
    }

    public void stop(){
        timer.cancel();
    }

    private class CommandTimerTask extends TimerTask{

        private int generatorId;
        private volatile Queue queue;

        public CommandTimerTask(int id, Queue queue){
            this.queue = queue;
            this.generatorId = id;
        }

        @Override
        public void run() {
            var uuid = UUID.randomUUID().toString().substring(0, 8);

            Command command = new Command() {

                @Override
                public void execute() {
                    try {
                        // Requests take a certain amount of time to be completed
                        Thread.sleep(intervalMs);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Processing request " + uuid + " from " + generatorId);
                }

                @Override
                public void undo() {}
            };

            queue.add(command);
        }
    }
}
