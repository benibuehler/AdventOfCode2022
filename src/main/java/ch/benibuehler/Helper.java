package ch.benibuehler;

import ch.benibuehler.BaseClasses.SolutionBase;
import ch.benibuehler.day1.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    private final String Path;
    List<String> contentsLineByLine = new ArrayList<>();

    public Helper(int dayNumber) {
        this.Path = "C:\\Data\\Privat\\Programmierung\\2022 Java\\AdventOfCode\\AdventOfCode\\input\\Day"+dayNumber+"\\aoc.txt";
        ReadLineInputs();
    }

    private void ReadLineInputs() {
        try
        {
            File file = new File(this.Path);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            while((line = reader.readLine()) != null){
                contentsLineByLine.add(line);
            }
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void RunDay1()
    {
        Solution solution = new Solution(contentsLineByLine);
        solution.DoAOC();
    }
    public void RunDay4()
    {
        SolutionBase solution = new ch.benibuehler.day4.Solution(contentsLineByLine);
        solution.DoAOC();
    }
    public void RunDay5()
    {
        SolutionBase solution = new ch.benibuehler.day5.Solution(contentsLineByLine);
        solution.DoAOC();
        SolutionBase solution2 = new ch.benibuehler.day5.Solution2(contentsLineByLine);
        solution2.DoAOC();
    }

    public void RunDay6()
    {
        ch.benibuehler.day6.Solution solution6 = new ch.benibuehler.day6.Solution(contentsLineByLine);
        solution6.DoAOC();
        solution6.DoAOCPart2();
    }

    public void RunDay7()
    {
        ch.benibuehler.day7.Solution solution7 = new ch.benibuehler.day7.Solution(contentsLineByLine);
        solution7.DoAOC();
    }
}
