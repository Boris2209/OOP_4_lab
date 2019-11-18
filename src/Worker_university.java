import java.util.Locale;

//создаем класс исключения Ошибка Ввода
class InputException extends Exception{}

public class Worker_university {
    private String t_number;    //табельный номер
    private String sername;     //фамилия
    private String name;        //имя
    private String adress;      //адресс
    private int num_child;      //количество детей
    private String gender;      //пол
    private String date;        //дата

    Worker_university(String t_number, String sername, String name, String adress, String num_child, String gender, String date) throws InputException{
        if (!(gender.toUpperCase()).equals("М") && !(gender.toUpperCase()).equals("Ж")
                && !(gender.toUpperCase()).equals("M") && !(gender.toUpperCase()).equals("W"))
            throw new InputException();
        else{
            this.t_number = t_number;
            this.sername = sername;
            this.name = name;
            this.adress = adress;
            try {
                this.num_child = Integer.parseInt(num_child);
            } catch (Exception io){
                throw new InputException();
            }
            if(this.num_child<0)
                throw new InputException();

            //обрабатывается ввод латинсницей или кирилицей, заглавной и строчной. Хранится заглавной латиницей
            if((gender.toUpperCase()).equals("М") ||(gender.toUpperCase()).equals("M"))
                this.gender = "M";
            else
                this.gender = "W";

            this.date = date;
        }
    }

    public String getT_number() {
        return t_number;
    }

    public String getSername() {
        return sername;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public int getNum_child() {
        return num_child;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return date;
    }
}
