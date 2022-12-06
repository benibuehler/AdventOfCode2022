package ch.benibuehler.day4;

import ch.benibuehler.BaseClasses.SolutionBase;

import java.util.List;

public class Solution extends SolutionBase {
    private int counter = 0;
    public Solution(List<String> contentsLineByLine) {
        super(contentsLineByLine);
    }

    @Override
    public void DoAOC() {
        for (String line : super.ContentsLineByLine)
        {
            String[] splitted = line.split(",");
            Section section1 = new Section(splitted[0]);
            Section section2 = new Section(splitted[1]);

            if(section1.FullyContains(section2)) {
                addToCounter();
            }
        }
        System.out.println(counter);
        counter = 0;

        DoAOCPart2();
    }

    private void DoAOCPart2() {
        for (String line : super.ContentsLineByLine)
        {
            String[] splitted = line.split(",");
            Section section1 = new Section(splitted[0]);
            Section section2 = new Section(splitted[1]);

            if(section1.PartiallyContains(section2)) {
                addToCounter();
            }
        }
        System.out.println(counter);
    }

    public void addToCounter()
    {
        counter++;
    }
}
