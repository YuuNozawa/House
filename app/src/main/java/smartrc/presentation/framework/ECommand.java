package smartrc.presentation.framework;

public enum ECommand {
    HOME_LANGUAGE(new Command(0)),
    LIGHT_SAVE(new Command(0)),
    ERROR(new Command(999));

    private Command command;

    private ECommand(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return this.command;
    }

    public Boolean equals(Command command) {
        return this.command.equals(command);
    }
}