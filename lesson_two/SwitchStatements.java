public class SwitchStatements {
    public static void main() {}

    public String convertToLabel(int quarter) {
        String quarterLabel = switch (quarter) {
            case 0 -> {
                System.out.println("Q1 - Winter");
                yield "Q1 - Winter";
            }
            default -> "Unknown quarter";
        };

        return quarterLabel;
    }

    public String switchColonExpressions(int quarter) {
        String quarterLabel = switch (quarter) {
            case 0: yield "Q1 - WInter";
            case 1: yield "Q2 - Spring";
            case 2: yield "Q3 - Summer";
            case 3: yield "Q4 - Summar";
            default: System.out.println("Unknown quarter");
                yield "Unknown quarter";
        };

        return quarterLabel;
    }
}
