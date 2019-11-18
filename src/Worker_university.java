/*
* Вариант 8, Класс - Сотрудник вуза
* Поля: Табельный номер, Фамилия, Имя, Адрес, Количество детей,
Пол, Дата рождения
* Дополнительные операции
1) По табельному номеру, вернуть Фамилия, Имя, Пол, дату
рождения
2) Определить, одинаковое ли количество детей у двух
сотрудников.
* Доп заданиея
* 1. Вывести список мужчин
* 2. Удалить первую запись, заменив на последнюю*/
//создаем класс исключения Ошибка Ввода
class InputException extends Exception{}

public class Worker_university {
    private String t_number;    //табельный номер
    private String sername;     //фамилия
    private String name;        //имя
    private String adress;      //адресс
    private String num_child;      //количество детей
    private int n_c;
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
                this.n_c = Integer.parseInt(num_child);
            } catch (Exception io){
                throw new InputException();
            }
            if(this.n_c<0)
                throw new InputException();
            this.num_child = String.valueOf(n_c);

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

    public String getNum_child() {
        return num_child;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return date;
    }

    public String getWorker(){
        return (t_number + " " + sername  + " " + name + " " + adress + " " + num_child + " " + getGender() + " " + date +"\n");
    }
}
