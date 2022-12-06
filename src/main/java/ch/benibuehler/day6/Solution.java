package ch.benibuehler.day6;

import ch.benibuehler.BaseClasses.SolutionBase;

import java.util.List;

public class Solution extends SolutionBase {
    String totalInput = "";
    public Solution(List<String> contentsLineByLine) {
        super(contentsLineByLine);
        totalInput += contentsLineByLine.get(0);
    }

    @Override
    public void DoAOC() {
        for (int i = 0; i<totalInput.length(); i++)
        {
            if(CheckFor4DistinctChars(i))
            {
                System.out.println(i+4);
                return;
            }
        }
    }
    public void DoAOCPart2() {
        for (int i = 0; i<totalInput.length(); i++)
        {
            if(Check14DistinctChars(i))
            {
                System.out.println(i+14);
                return;
            }
        }
    }

    private boolean CheckFor4DistinctChars(int index) {
        String substring = totalInput.substring(index, index+4);
        for (int i = 0; i < substring.length(); i++)
        {
            for (int j = i + 1; j < substring.length(); j++)
            {
                if (substring.charAt(i) == substring.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean Check14DistinctChars(int index) {
        String substring = totalInput.substring(index, index+14);
        for (int i = 0; i < substring.length(); i++)
        {
            for (int j = i + 1; j < substring.length(); j++)
            {
                if (substring.charAt(i) == substring.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
