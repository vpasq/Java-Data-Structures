
import java.util.Scanner;

public class DecisionTree {
  private static Scanner stdin = new Scanner(System.in);

  public static void main (String[] args) {
    BTNode<String> root;

    //instruct();
    root = beginningTree();
    do
      play(root);
    while (query("Shall we play again?"));
    System.out.println("Thanks for teaching me a thing or two.");
  }

  public static void play(BTNode<String> current) {
    while (!current.isLeaf()) {
      if (query(current.getData()))
        current = current.getLeft();
      else
        current = current.getRight();
    }

    System.out.println("My guess is " + current.getData() + ". ");
    if (!query("Am I right?"))
      learn(current);
    else
      System.out.println("I knew it all along!");
  }


  public static boolean query(String prompt) {
    String answer;
    System.out.println(prompt + " [Y or N]: ");
    answer = stdin.nextLine().toUpperCase();

    while (!answer.startsWith("Y") && !answer.startsWith("N")) {
      System.out.println("Invalid response. Please type Y or N: ");
      answer = stdin.nextLine().toUpperCase();
    }

    return answer.startsWith("Y");
  }

  public static void learn(BTNode<String> current) {
    System.out.println("No, " + current.getData() + " is not correct.");
    String guessedAnimal = current.getData();
    String newQuestion;
    String correctAnswer;

    // user could answer... Racoon
    System.out.println("What is the correct animal?");
    correctAnswer = stdin.nextLine();

    // user could answer... Are you a marsupial?
    System.out.println("What is a yes/no question that can distinguish the right animal " +
        "from the animal that was guessed?");
    newQuestion = stdin.nextLine();

    // create new branch
    current.setData(newQuestion);
    current.setLeft(new BTNode<String>(correctAnswer, null, null));
    current.setRight(new BTNode<String>(guessedAnimal, null, null));
  }

  public static BTNode<String> beginningTree() {
    BTNode<String> root;
    BTNode<String> child;

    final String ROOT_QUESTION = "Are you a mamal?";
    final String LEFT_QUESTION = "Are you bigger than a cat?";
    final String RIGHT_QUESTION = "Do you live underwater?";
    final String Animal1 = "Kangaroo";
    final String Animal2 = "Mouse";
    final String Animal3 = "Trout";
    final String Animal4 = "Robin";

    root = new BTNode<String>(ROOT_QUESTION, null, null);

    // create and attach the left subtree
    child = new BTNode<String>(LEFT_QUESTION, null, null);
    child.setLeft(new BTNode<String>(Animal1, null, null));
    child.setRight(new BTNode<String>(Animal2, null, null));
    root.setLeft(child);

    // create and attach the right subtree
    child = new BTNode<String>(RIGHT_QUESTION, null, null);
    child.setLeft(new BTNode<String>(Animal3, null, null));
    child.setRight(new BTNode<String>(Animal4, null, null));
    root.setRight(child);

    return root;
  }

}
