package ch.benibuehler.day5;

import ch.benibuehler.BaseClasses.SolutionBase;
import ch.benibuehler.day5.Models.Command;
import ch.benibuehler.day5.Models.Stack;

import java.util.List;
import java.util.Optional;

public class Solution2 extends SolutionBase {

    public Solution2(List<String> contentsLineByLine) {
        super(contentsLineByLine);
    }

    @Override
    public void DoAOC() {
        Day5Helper helper = new Day5Helper();
        List<Stack> allStacks = helper.ReadStacks(super.ContentsLineByLine);
        List<Stack> allStacksAfterPlanSorting = SortStacksAccordingToPlan(allStacks);
        System.out.println("All Elements which are on top of each Stack Part 2: ");
        for(Stack element : allStacksAfterPlanSorting) {
            System.out.print(element.Elements.get(0).replace("[", "").replace("]", ""));
        }
    }

    private List<Stack> SortStacksAccordingToPlan(List<Stack> allStacks) {
        for(int i = 10; i < super.ContentsLineByLine.size(); i++) {
            Command cmd = new Command(super.ContentsLineByLine.get(i));
            MoveStackElementsInGroups(allStacks, cmd);
        }
        return allStacks;
    }

    private void MoveStackElementsInGroups(List<Stack> allStacks, Command cmd) {
        Optional<Stack> stackToMoveFrom = allStacks.stream().filter(stack -> stack.getStackNumber() == cmd.from).findFirst();
        Optional<Stack> stackToMoveTo = allStacks.stream().filter(stack -> stack.getStackNumber() == cmd.to).findFirst();
            try {
                List<String> elements = stackToMoveFrom.get().Elements.subList(0, cmd.amount);
                stackToMoveTo.get().Elements.addAll(0, elements);
                RemoveElementsFromStack(cmd.amount, stackToMoveFrom.get());
            }
            catch(Exception e){
                System.out.println("error");
            }
    }

    private void RemoveElementsFromStack(int amount, Stack stackToMoveFrom) {
        if (amount > 0) {
            stackToMoveFrom.Elements.subList(0, amount).clear();
        }
    }
}
