package ReflectionAndAnnotations_07.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		Consumer<Field> printer = field -> System.out.println(String.format("%s %s %s",
				Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
		String command = scanner.nextLine();

		while (!"HARVEST".equals(command)) {
			if (command.equals("private")) {
				Arrays.stream(fields).filter(field -> Modifier.isPrivate(field.getModifiers()))
						.forEach(printer);
			} else if (command.equals("protected")) {
				Arrays.stream(fields).filter(field -> Modifier.isProtected(field.getModifiers()))
						.forEach(printer);
			} else if (command.equals("public")) {
				Arrays.stream(fields).filter(field -> Modifier.isPublic(field.getModifiers()))
						.forEach(printer);
			} else if (command.equals("all")) {
				Arrays.stream(fields)
						.forEach(printer);
			}
			command = scanner.nextLine();
		}

	}
}
