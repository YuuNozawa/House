package smartrc.presentation.framework;

public class Command {
    private Integer value;
    
    public Command(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Command)) return false;

        Command command = (Command)obj;
        return value != null ? value.equals(command.value) : command.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}