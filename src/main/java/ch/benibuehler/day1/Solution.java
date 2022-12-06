package ch.benibuehler.day1;

import ch.benibuehler.BaseClasses.SolutionBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution extends SolutionBase {
    public Solution(List<String> contentsLineByLine) {
        super(contentsLineByLine);
    }

    // run the algorithm to find solution
    public void DoAOC() {
        int totalCalories = 0;
        ArrayList<Elve> elves = new ArrayList<>();

        for (String line: super.ContentsLineByLine) {
            if(line.isEmpty())
            {
                Elve elve = new Elve();
                elve.setCaloriesCarrying(totalCalories);
                elves.add(elve);
                totalCalories = 0;
            }
            else
            {
                totalCalories += Integer.parseInt(line);
            }
        }
        // Part 1 highes value
        int highestValue = GetHighestCarrier(elves);
        System.out.println("Highest: "+highestValue);

        //Part 2 top 3 values
        int totalTop3 = Get3HighesCarriersResult(elves);
        System.out.println("Top3 totals: "+totalTop3);
    }

    //Gets the result of the calories of the top3 carriers
    private int Get3HighesCarriersResult(List<Elve> allElves) {
        List<Elve> sortedElves = allElves.stream()
                .sorted(Comparator.comparing(Elve::getCaloriesCarrying).reversed())
                .toList();
        int totalTop3 = 0;
        for (int i = 0; i<3; i++){
            totalTop3 += sortedElves.get(i).getCaloriesCarrying();
        }
        return totalTop3;
    }

    // Gets the highest carrier elve
    private int GetHighestCarrier(List<Elve> elves) {
        List<Elve> sorted = elves.stream()
                .sorted(Comparator.comparing(Elve::getCaloriesCarrying).reversed())
                .toList();

        return sorted.get(0).getCaloriesCarrying();
    }
}
