package nl.lengrand.patterns.command;

import nl.lengrand.patterns.command.commands.Command;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
    This class illustrates a simple usage of the Command Pattern for a processing queue.
     * Command generators create commands and add them to the queue for processing.
     * The Command Processor(s) take items from the queue to process them.

     Processors know nothing about the commands they have to run, making them totally agnostic.
 */
public class ProcessingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        Queue<Command> queue = new LinkedList<>();

        List<CommandGenerator> generators = IntStream.range(0, 5)
                .mapToObj(i -> new CommandGenerator(i + 1, queue, getRandomInterval()))
                .collect(Collectors.toList());

        generators.forEach(g -> g.generate());
        Thread.sleep(1000);

        CommandProcessor processor = new CommandProcessor(queue);
        Thread processorThread = new Thread(processor);
        System.out.println("Starting");
        processorThread.start();

        Thread.sleep(200);
        generators.forEach(g -> g.stop());
    }


    /*
    Returns a random integer between 1 and 1000 (representing between 1 and 1000 ms interval)
     */
    public static int getRandomInterval(){
        return ThreadLocalRandom.current().nextInt(1, 1001);
    }
}
