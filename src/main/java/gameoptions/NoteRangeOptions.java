package gameoptions;

public class NoteRangeOptions implements Optionable{

    private Integer minBass = null;
    private Integer maxBass = null;
    private Integer minTreble = null;
    private Integer maxTreble = null;

    @Override
    public boolean isValid() {
        // todo: implement NoteRangeOptions.isValid()
        return false;
    }

    // getters ===================================================

    public Integer getMinBass() {
        return minBass;
    }

    public Integer getMaxBass() {
        return maxBass;
    }

    public Integer getMinTreble() {
        return minTreble;
    }

    public Integer getMaxTreble() {
        return maxTreble;
    }

    // setters ===================================================

    // todo: code validation, when setting values

    public void setMinBass(Integer minBass) {
        this.minBass = minBass;
    }

    public void setMaxBass(Integer maxBass) {
        this.maxBass = maxBass;
    }

    public void setMinTreble(Integer minTreble) {
        this.minTreble = minTreble;
    }

    public void setMaxTreble(Integer maxTreble) {
        this.maxTreble = maxTreble;
    }
}
