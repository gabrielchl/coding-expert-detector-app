package sample;

public class FeaturesData {
    private final String filename;
    private final String classification;
    private final String numLines;
    private final String emptyLines;
    private final String avgLenLines;
    private final String numVariables;
    private final String avgLenVariables;
    private final String numIf;
    private final String numFor;
    private final String numDo;
    private final String numWhile;
    private final String numSwitch;
    private final String numCast;
    private final String condSpaceRatio;
    private final String bracketLineRatio;
    private final String numSpace;

    public FeaturesData(String filename, String classification, String numLines, String emptyLines, String avgLenLines, String numVariables, String avgLenVariables, String numIf, String numFor, String numDo, String numWhile, String numSwitch, String numCast, String condSpaceRatio, String bracketLineRatio, String numSpace) {
        this.filename = filename;
        this.classification = classification;
        this.numLines = numLines;
        this.emptyLines = emptyLines;
        this.avgLenLines = avgLenLines;
        this.numVariables = numVariables;
        this.avgLenVariables = avgLenVariables;
        this.numIf = numIf;
        this.numFor = numFor;
        this.numDo = numDo;
        this.numWhile = numWhile;
        this.numSwitch = numSwitch;
        this.numCast = numCast;
        this.condSpaceRatio = condSpaceRatio;
        this.bracketLineRatio = bracketLineRatio;
        this.numSpace = numSpace;
    }

    public String getFilename() {
        return filename;
    }

    public String getClassification() {
        return classification;
    }

    public String getNumLines() {
        return numLines;
    }

    public String getEmptyLines() {
        return emptyLines;
    }

    public String getAvgLenLines() {
        return avgLenLines;
    }

    public String getNumVariables() {
        return numVariables;
    }

    public String getAvgLenVariables() {
        return avgLenVariables;
    }

    public String getNumIf() {
        return numIf;
    }

    public String getNumFor() {
        return numFor;
    }

    public String getNumDo() {
        return numDo;
    }

    public String getNumWhile() {
        return numWhile;
    }

    public String getNumSwitch() {
        return numSwitch;
    }

    public String getNumCast() {
        return numCast;
    }

    public String getCondSpaceRatio() {
        return condSpaceRatio;
    }

    public String getBracketLineRatio() {
        return bracketLineRatio;
    }

    public String getNumSpace() {
        return numSpace;
    }
}
