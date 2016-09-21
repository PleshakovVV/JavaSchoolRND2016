package homeWorks.homeWork19.command;

/**
 * Created by Master on 14.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Evaluator[] evaluators = new Evaluator[4];
        evaluators[0] = new Evaluator(new Sinus());
        evaluators[1] = new Evaluator(new Cosinus());
        evaluators[2] = new Evaluator(new Tangens());
        evaluators[3] = new Evaluator(new AlphaSinus());
        Double[] arguments = {3D, 0.5};
        for (Evaluator eval : evaluators) {
            System.out.println(eval.evaluate(arguments));
        }
    }
}
