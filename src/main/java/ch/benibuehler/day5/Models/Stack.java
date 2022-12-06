package ch.benibuehler.day5.Models;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    public int getStackNumber() {
        return StackNumber;
    }
    public List<String> Elements = new ArrayList<>();
    public void setStackNumber(int stackNumber) {
        StackNumber = stackNumber;
    }
    public int StackNumber;
}
