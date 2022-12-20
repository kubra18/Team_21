package proje02_KimlikYap;

public class Persons {

    public String name ;
    public String adress ;
    public String telNo ;

    public Persons(String nameSurname, String adressInfo, String telNumber){

        this.name = nameSurname;
        this.adress = adressInfo;
        this.telNo = telNumber;

    }
    @Override
    public String toString() {
        return "Persons{" +

                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", telNo='" + telNo + '\'' +
                '}';
    }
}
