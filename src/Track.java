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


        Pepita t1=new Pepita(1,"ciao",false,1.3);
        t1.getInsert();
        Object[] a = null;
        t1.update("co",a) ;
        t1.insert();

        Track t2=new Track(2,"abc","def");
        t2.getInsert();

        t2.update("id",a) ;
        t2.insert();

    }
}
