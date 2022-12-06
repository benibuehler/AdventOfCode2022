package ch.benibuehler.day3;

import ch.benibuehler.BaseClasses.SolutionBase;

import java.util.ArrayList;
import java.util.List;

public class Solution extends SolutionBase {

    int totalValue = 0;
    public Solution(List<String> contentsLineByLine) {
        super(contentsLineByLine);
    }

    @Override
    public void DoAOC() {
        for (String line : super.ContentsLineByLine) {
            List<Character> charactersSolved = new ArrayList<>();
            int middleIndex = line.length()/2;

            for(int i = 0; i < middleIndex; i++) {
                for(int j = 0; j<line.length(); i++) {
                    if(line.charAt(i) == line.charAt(j)) {
                        AddToTotal(line.charAt(i), charactersSolved);
                    }
                }
            }
        }
        System.out.println(totalValue);
        totalValue = 0;
        DoPart2();
    }

    private void DoPart2() {
        for(int i = 0; i < super.ContentsLineByLine.size(); i += 3) {
            List<Character> charactersSolved = new ArrayList<>();
            String line1 = super.ContentsLineByLine.get(i);
            String line2 = super.ContentsLineByLine.get(i+1);
            String line3 = super.ContentsLineByLine.get(i+2);

            for(Character c : line1.toCharArray()) {
                if(line2.contains(c.toString()) && line3.contains(c.toString())) {
                    AddToTotal(c, charactersSolved);
                }
            }
        }
        System.out.println(totalValue);
    }

    private void AddToTotal(Character character, List<Character> charactersSolved) {
        if(!charactersSolved.contains(character)) {
            int value = GetCharValue(character);
            totalValue += value;
            charactersSolved.add(character);
        }
    }

    private int GetCharValue(Character character) {
        int value = (int)character % 32;
        if(Character.isUpperCase(character)) {
            value += 26;
        }
        return value;
    }
}
