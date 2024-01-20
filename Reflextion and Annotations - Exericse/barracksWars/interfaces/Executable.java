package ReflectionAndAnnotations_07.barracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Executable {

	String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException;

}
