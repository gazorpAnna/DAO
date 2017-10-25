public class Track extends DAO {
    public int id;
    public String name, desc;

    public Track(){
        id = 1;
        name = "hola";
        desc = "Descripción de la Track";
    }

    public Track(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static void main(String[] Args) throws Exception{

        Track t1=new Track();
        Track t2=new Track(2,"abc","def");
        t2.getInsert();


    }
}
