package ch.benibuehler.BaseClasses;

import java.util.List;

public abstract class SolutionBase {
    public List<String> ContentsLineByLine;
    public SolutionBase(List<String> contentsLineByLine){
        ContentsLineByLine = contentsLineByLine;
    }

    public abstract void DoAOC();
}
