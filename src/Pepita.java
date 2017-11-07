public class Pepita extends DAO {
    public int numeroTal;
    public String co;
    public boolean pop;
    public double tre;

    public Pepita(int numeroTal, String co, boolean pop, double tre) {
        this.numeroTal = numeroTal;
        this.co = co;
        this.pop = pop;
        this.tre = tre;
    }

    public int getNumeroTal() {
        return numeroTal;
    }

    public String getCo() {
        return co;
    }

    public boolean getPop() {
        return pop;
    }

    public double getTre() {
        return tre;
    }

    public void setNumeroTal(int numeroTal) {
        this.numeroTal = numeroTal;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public void setPop(boolean pop) {
        this.pop = pop;
    }

    public void setTre(double tre) {
        this.tre = tre;
    }
}
