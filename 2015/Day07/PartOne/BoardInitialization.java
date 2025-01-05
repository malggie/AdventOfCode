import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardInitialization {

    private Map<String, Integer> wires = new HashMap<>();
    private Map<String, String> connections = new HashMap<>();

    public BoardInitialization(List<String> input) {
        for (String expression : input) {
            String[] parts = expression.split(" -> ");
            String instruction = parts[0].trim();
            String targetWire = parts[1].trim();

            connections.put(targetWire, instruction);
            wires.put(targetWire, null);
        }
    }

    public int getSignal(String wire) {
        if (wires.containsKey(wire) && wires.get(wire) != null) {
            return wires.get(wire);
        }

        String instruction = connections.get(wire);
        int value;

        if (instruction == null) {
            value = Integer.parseInt(wire);
        } else if (instruction.contains("AND")) {
            String[] parts = instruction.split(" AND ");
            value = getSignal(parts[0].trim()) & getSignal(parts[1].trim());
        } else if (instruction.contains("OR")) {
            String[] parts = instruction.split(" OR ");
            value = getSignal(parts[0].trim()) | getSignal(parts[1].trim());
        } else if (instruction.contains("LSHIFT")) {
            String[] parts = instruction.split(" LSHIFT ");
            value = getSignal(parts[0].trim()) << Integer.parseInt(parts[1].trim());
        } else if (instruction.contains("RSHIFT")) {
            String[] parts = instruction.split(" RSHIFT ");
            value = getSignal(parts[0].trim()) >> Integer.parseInt(parts[1].trim());
        } else if (instruction.startsWith("NOT")) {
            String operand = instruction.substring(4).trim();
            value = ~getSignal(operand);
        } else {
            value = getSignal(instruction);
        }

        wires.put(wire, value);
        return value;
    }
}
