package ch.benibuehler.day5.Models;

import java.util.Arrays;
import java.util.List;

public class Command {
    public int amount = 0;
    public int from = 0;
    public int to = 0;
    String Input;
    public Command(String input) {
        Input = input;
        InterpretInput();
    }

    private void InterpretInput() {
        String values = Input.replaceAll("[^0-9]+", " ");
        List<String> myInterpretedValues = Arrays.asList(values.trim().split(" "));
        this.amount = Integer.parseInt(myInterpretedValues.get(0));
        this.from = Integer.parseInt(myInterpretedValues.get(1));
        this.to = Integer.parseInt(myInterpretedValues.get(2));
    }
}
