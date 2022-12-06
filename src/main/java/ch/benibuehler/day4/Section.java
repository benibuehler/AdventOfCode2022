package ch.benibuehler.day4;

public class Section {
    private final int min;
    private final int max;
    public Section(String sectionInput)
    {
        String[] splitted = sectionInput.split("-");
        this.min = Integer.parseInt(splitted[0]);
        this.max = Integer.parseInt(splitted[1]);
    }

    public boolean PartiallyContains(Section other)
    {
        return this.min <= other.max && other.min <= this.max;
    }

    public boolean FullyContains(Section other)
    {
        return other.min >= this.min && other.max <= this.max ||
                this.min >= other.min && this.max <= other.max;
    }
}
