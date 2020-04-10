package nl.lengrand.patterns.command.commands;

import java.util.List;

public class MetaCommand implements Command{

    final List<Command> commands;

    public MetaCommand(List<Command> commands){
        this.commands = commands;
    }

    @Override
    public void execute() {
        commands.forEach(Command::execute);
    }

    @Override
    public void undo() {
        commands.forEach(Command::undo);
    }
}
