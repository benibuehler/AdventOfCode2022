package ch.benibuehler.day5;

import ch.benibuehler.BaseClasses.SolutionBase;
import ch.benibuehler.day5.Models.Command;
import ch.benibuehler.day5.Models.Stack;

import java.util.List;
import java.util.Optional;

public class Solution extends SolutionBase {

    public Solution(List<String> contentsLineByLine) {
        super(contentsLineByLine);
    }

    @Override
    public void DoAOC() {
        Day5Helper helper = new Day5Helper();
        List<Stack> allStacks = helper.ReadStacks(super.ContentsLineByLine);

        List<Stack> allStacksAfterPlanSorting = SortStacksAccordingToPlan(allStacks);

        System.out.println("All Elements which are on top of each Stack Part 1: ");
        for(Stack element : allStacksAfterPlanSorting) {
            System.out.print(element.Elements.get(0).replace("[", "").replace("]", ""));
        }
        System.out.println();
    }

    private List<Stack> SortStacksAccordingToPlan(List<Stack> allStacks) {
        for(int i = 10; i < super.ContentsLineByLine.size(); i++) {
            Command cmd = new Command(super.ContentsLineByLine.get(i));
            MoveStackElementsSingle(allStacks, cmd);
        }
        return allStacks;
    }

    private void MoveStackElementsSingle(List<Stack> allStacks, Command cmd) {
        Optional<Stack> stackToMoveFrom = allStacks.stream().filter(stack -> stack.getStackNumber() == cmd.from).findFirst();
        Optional<Stack> stackToMoveTo = allStacks.stream().filter(stack -> stack.getStackNumber() == cmd.to).findFirst();
        for(int i = 0; i < cmd.amount; i++)
        {
            try {
                String element = stackToMoveFrom.get().Elements.get(0);
                stackToMoveFrom.get().Elements.remove(0);
                stackToMoveTo.get().Elements.add(0, element);
            }
            catch(Exception e){
                System.out.println("error");
            }
        }
    }
}
