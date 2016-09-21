import java.util.List;

/**
 * Created by Master on 16.08.2016.
 */
public class CountTask implements Runnable {
    private SumHolder sumHolder;
    private int innerSum = 0;
    
    private List<String> workList;
    private int indexFrom;
    private int indexEnd;
    
    public CountTask(SumHolder sumHolder, List<String> list, int indexFrom, int indexEnd) {
        this.sumHolder = sumHolder;
        this.workList = list;
        this.indexFrom = indexFrom;
        this.indexEnd = indexEnd;
    }
    
    @Override
    public void run() {
        for (int i = indexFrom; i < indexEnd; i++) {
            int letterCount = 0;
            for (int j = 0; j < workList.get(i).codePointCount(0, workList.get(i).length()); j++) {
                if (Character.isLetter(workList.get(i).codePointAt(j))) {
                    letterCount++;
                }
            }
            innerSum += letterCount;
        }
        if (innerSum != 0) {
            sumHolder.add(innerSum);
        }
    }
}
