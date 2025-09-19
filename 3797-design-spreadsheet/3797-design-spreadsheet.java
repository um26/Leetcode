import java.util.*;

class Spreadsheet {
    private Map<String, Integer> cells;

    public Spreadsheet(int rows) {
        // We don't need to store rows explicitly since cell references are strings like "A1"
        cells = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }

    public void resetCell(String cell) {
        cells.remove(cell); // Unset cells default to 0
    }

    public int getValue(String formula) {
        // Formula format: "=X+Y", where X and Y are either integers or cell references
        if (formula.charAt(0) != '=') return 0;

        String[] parts = formula.substring(1).split("\\+");
        int sum = 0;

        for (String part : parts) {
            part = part.trim();
            if (Character.isDigit(part.charAt(0))) {
                sum += Integer.parseInt(part);
            } else {
                sum += cells.getOrDefault(part, 0);
            }
        }

        return sum;
    }
}