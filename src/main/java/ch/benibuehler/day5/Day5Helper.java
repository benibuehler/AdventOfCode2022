package ch.benibuehler.day5;

import ch.benibuehler.day5.Models.Stack;

import java.util.ArrayList;
import java.util.List;

public class Day5Helper {

    public ArrayList<Stack> ReadStacks(List<String> contentsLineByLine)
    {
        ArrayList<Stack> allStacks = new ArrayList<>();
        for(String line : contentsLineByLine) {
            if(IsEndOfMatrix(line))
            {
                return allStacks;
            }

            BuildStacks(allStacks, line);
        }
        return allStacks;
    }

    private void BuildStacks(ArrayList<Stack> allStacks, String line) {
        int stackIndex = 0;
        for (int i = 0; i < line.length(); i += 4)
        {
            Stack stack;

            stack = GetOrCreateStack(allStacks, stackIndex);

            String element = line.substring(i, i+3);
            if(!element.trim().isEmpty()) {
                stack.Elements.add(element);
            }
            stackIndex++;
        }
    }

    private boolean IsEndOfMatrix(String line) {
        return line.startsWith(" 1");
    }

    private Stack GetOrCreateStack(ArrayList<Stack> allStacks, int stackIndex) {
        Stack existing;
        try{
            existing = allStacks.get(stackIndex);
        }
        catch(Exception e)
        {
            existing = new Stack();
            existing.setStackNumber(stackIndex +1);
            allStacks.add(existing);
        }
        return existing;
    }
}
