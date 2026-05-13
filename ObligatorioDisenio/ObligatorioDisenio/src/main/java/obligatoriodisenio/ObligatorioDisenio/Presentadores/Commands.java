package obligatoriodisenio.ObligatorioDisenio.Presentadores;

import java.util.ArrayList;
import java.util.List;

public class Commands {
    private List<Command> commands;

    public Commands() {
        this.commands = new ArrayList<>();
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public static Commands create(Command... commands) {
        Commands result = new Commands();
        for (Command cmd : commands) {
            result.addCommand(cmd);
        }
        return result;
    }
}
