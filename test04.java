public class Durelli {

    private String name;
    private float points;

    public Durelli(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public float PleaseGiveMePoints(Student student, float points) {
        if (student.wantPoints()) {
            return points;
        } else {
            System.out.println("Hmmm, next semester!");
            return 0;
        }
    }
}