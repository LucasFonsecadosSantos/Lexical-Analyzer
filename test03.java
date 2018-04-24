public abstract class Fire {

    private Gasoline gasoline;

    public Fire(Gasoline gasoline) {
        setGasoline(gasoline);
    }

    public Explosion fireInTheHole() {
        return this.gasoline*2;
    }
}