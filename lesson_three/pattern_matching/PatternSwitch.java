package lesson_three.pattern_matching;

import lesson_three.pattern_matching.Position;


public class PatternSwitch {
    Object o = 34;

    public void check(Object o) {
        String formatted = null;

        if (o instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (o instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (o instanceof Double d) {
            formatted = String.format("double %f", d);
        } else {
            formatted = String.format("Object %s", o.toString());
        }
    }


    public void checkValues(Object o) {
        String formatter = switch(o) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case Object ob -> String.format("Object %s", ob.toString());
        };
    }

    public void sampleSwitchRecord(Object o) {
         if (o instanceof Position(int x, int y)) {
             System.out.print("Found x: " + x + "\n y: " + y);
         }
    }
}
