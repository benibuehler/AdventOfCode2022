package ch.benibuehler.day7.Parser;

import ch.benibuehler.day7.Models.Node;

import java.util.List;

public class TerminalParser {
    public static Node<String> GetNodeTree(List<String> contentsLineByLine)
    {
        Node<String> actualNode = null;
        Node<String> rootNode = null;
        for (String line : contentsLineByLine) {
            // means it's a command
            if(line.startsWith("$"))
            {
                if (line.contains("cd /")) {
                    rootNode = new Node<>("root");
                    actualNode = rootNode;
                }
                else if (line.contains("cd ..")) {
                    actualNode = actualNode.getParent();
                }
                else if (line.contains("cd")) {
                    String folderName = line.substring(5);
                    actualNode = actualNode.getChildren().stream()
                            .filter(data -> data.getData().contentEquals(folderName))
                            .toList()
                            .get(0);
                }
                // do nothing with ls
            }
            else
            {
                if(line.startsWith("dir"))
                {
                    AddChildNode(actualNode, line);
                }
                else
                {
                    SetActualNodeValue(actualNode, line);
                }
            }
        }
        return rootNode;
    }
    private static void AddChildNode(Node<String> actualNode, String line) {
        int beginIndex = 4;
        Node<String> childNode = new Node<>(line.substring(beginIndex));
        actualNode.addChild(childNode);
    }

    private static void SetActualNodeValue(Node<String> actualNode, String line) {
        StringBuilder fullSize = new StringBuilder();
        int index = 0;
        for (char c : line.toCharArray())
        {
            if(Character.isDigit(c)) {
                fullSize.append(c);
                index++;
            }
        }
        Node<String> file = new Node<>(line.substring(index+1));
        actualNode.addChild(file);
        actualNode.setSize(actualNode.getSize() + Integer.parseInt(fullSize.toString().trim()));
    }
}
