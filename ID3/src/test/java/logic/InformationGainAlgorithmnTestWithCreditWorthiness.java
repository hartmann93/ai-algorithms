package logic;

import model.TrainingExample;
import model.TrainingExampleHeadline;
import model.TrainingExampleRow;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InformationGainAlgorithmnTestWithCreditWorthiness {
    TrainingExample trainingExample;

    @Before
    public void prepare() {
        List<TrainingExampleRow> exampleRows = new ArrayList<>();
        exampleRows.add(new TrainingExampleRow(0, "high", "old", "clerk", "sufficient"));
        exampleRows.add(new TrainingExampleRow(0, "high", "old", "clerk", "sparse"));
        exampleRows.add(new TrainingExampleRow(0, "average", "young", "clerk", "sparse"));
        exampleRows.add(new TrainingExampleRow(0, "high", "average", "clerk", "sufficient"));
        exampleRows.add(new TrainingExampleRow(0, "low", "young", "self-employed", "sparse"));
        exampleRows.add(new TrainingExampleRow(0, "low", "young", "self-employed", "sufficient"));
        exampleRows.add(new TrainingExampleRow(0, "average", "average", "self-employed", "sufficient"));
        exampleRows.add(new TrainingExampleRow(0, "low", "average", "self-employed", "sparse"));
        exampleRows.add(new TrainingExampleRow(0, "average", "old", "self-employed", "sparse"));
        exampleRows.add(new TrainingExampleRow(0, "high", "old", "self-employed", "sufficient"));
        trainingExample = new TrainingExample(new TrainingExampleHeadline(0, "worthy", "age", "occupation", "security"), exampleRows);
    }

    @Test
    public void testOriginalEntropy() {
        Assert.assertEquals(1.5709505944546684, InformationGainAlgorithmn.calculateOriginalEntropy(trainingExample), 0.0001);
    }

    @Test
    public void testRelativeEntropy() {
        double relativeEntropy = InformationGainAlgorithmn.calculateRelativeEntropy(trainingExample, 1);
        Assert.assertEquals(1.0754744789463977, relativeEntropy, 0.0001);
    }

    @Test
    public void testInformationGainOfAge() {
        double informationGain = InformationGainAlgorithmn.calculateInformationGain(trainingExample, 1);
        Assert.assertEquals(0.4955, informationGain, 0.001);
    }

    @Test
    public void testInformationGainOfOccupation() {
        double informationGain = InformationGainAlgorithmn.calculateInformationGain(trainingExample, 2);
    }

    @Test
    public void testInformationGainOfSecurity() {
        double informationGain = InformationGainAlgorithmn.calculateInformationGain(trainingExample, 3);
    }
}
