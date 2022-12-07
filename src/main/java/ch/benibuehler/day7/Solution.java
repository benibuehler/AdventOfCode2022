package ch.benibuehler.day7;

import ch.benibuehler.BaseClasses.SolutionBase;
import ch.benibuehler.day7.Models.Node;
import ch.benibuehler.day7.Parser.TerminalParser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Solution extends SolutionBase {
    private int sumOfAllDirectoriesPart1;
    private final List<Node<String>> nodesToDelete = new ArrayList<>();
    private int totalSpaceToFree;

    public Solution(List<String> contentsLineByLine) {
        super(contentsLineByLine);
    }

    @Override
    public void DoAOC() {
        Node<String> rootNode;
        rootNode = TerminalParser.GetNodeTree(super.ContentsLineByLine);

        SetSizesOfDirectories(rootNode);
        System.out.println("Sum of all directories smaller than 100'000 added up: ");
        System.out.println(sumOfAllDirectoriesPart1);

        DoAOCPart2(rootNode);
    }
    private int SetSizesOfDirectories(Node<String> node) {
        int folderSize = node.getSize();
        for(Node<String> child : node.getChildren())
        {
            folderSize += SetSizesOfDirectories(child);
        }
        if(folderSize <= 100000)
        {
            sumOfAllDirectoriesPart1 += folderSize;
        }
        node.setSize(folderSize);
        return folderSize;
    }

    public void DoAOCPart2(Node<String> rootNode) {
        CalculateTotalSpaceToFree(rootNode);

        for(Node<String> child : rootNode.getChildren())
        {
            GetFoldersBigEnough(child);
        }

        Node<String> bestFitting = FindBestFittingNode();
        System.out.println("Directory size of the best fitting Node being the closest to the needed size of: " + totalSpaceToFree);
        System.out.println(bestFitting.getData() + " with size of " + bestFitting.getSize());
    }

    private void CalculateTotalSpaceToFree(Node<String> rootNode) {
        int neededUnusedSpace = 30000000;
        int actualUnusedSpace = 70000000 - rootNode.getSize();
        totalSpaceToFree = neededUnusedSpace - actualUnusedSpace;
    }

    private void GetFoldersBigEnough(Node<String> node)
    {
        for(Node<String> child : node.getChildren())
        {
            GetFoldersBigEnough(child);
        }
        if(node.getSize() >= totalSpaceToFree)
        {
            nodesToDelete.add(node);
        }
    }
    private Node<String> FindBestFittingNode()
    {
        Optional<Node<String>> min = nodesToDelete.stream()
                .min(Comparator.comparing(Node::getSize));
        return min.orElse(null);
    }
}
