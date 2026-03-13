public class Worker {
    private String pib;
    private String position;
    private short year;

    public Worker() {
    }

    public Worker(String pib, String position, short year) {
        this.pib = pib;
        this.position = position;
        this.year = year;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short yearEntryEmployment) {
        this.year = yearEntryEmployment;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "pib ='" + pib + '\'' +
                ", posotion ='" + position + '\'' +
                ", year =" + year +
                '}';
    }
}
