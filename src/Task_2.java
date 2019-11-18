import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Task_2 {

    public void show_menu_2(){
        String main_menu_text = "1. Создать новые объекты и файл\n" +
                "2. \n0. Выход\n";
        int job_task_2 = -1;
        while (job_task_2!=0){
            System.out.println(main_menu_text);
            Scanner m_sc = new Scanner(System.in);
            job_task_2 = m_sc.nextInt();
            switch (job_task_2){
                case 1:
                    append_file_and_object();
                    break;

                case 2:

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Введена неверная команда, повторите ввод");
                    break;
            }
        }
    }

    //создание объека и добвление в файл
    private void append_file_and_object(){
        try {
        Scanner inp = new Scanner(System.in);

        System.out.println("Сколько новыйх объектов вы хотите создать?");
        int count_oblect = inp.nextInt();


        System.out.println("\nВведите название будущего файла: ");
        String file_name = inp.next();
        file_name += ".bin";

        String t_number, sername, name, adress, num_child, gender, date;

            //открывем файл для записи
            DataOutputStream doc = new DataOutputStream(new FileOutputStream(file_name));

        for(int i=0; i<count_oblect; i++) {
            System.out.println("\nВведите табельный номер");
            t_number = inp.next();

            System.out.println("\nВведите фамилию");
            sername = inp.next();

            System.out.println("\nВведите имя");
            name = inp.next();

            System.out.println("\nВведите адрес");
            adress = inp.next();

            System.out.println("\nВведите количепство детей(цифрой)");
            num_child = inp.next();

            System.out.println("\nВведите пол (одной буквой)");
            gender = inp.next();

            System.out.println("\nВведите дату рождения");
            date = inp.next();


            //создаем объект
            Worker_university wor = new Worker_university(t_number, sername,
                    name, adress, num_child, gender, date);

            //записываем
            doc.writeUTF(wor.getT_number());
            doc.writeUTF(wor.getSername());
            doc.writeUTF(wor.getName());
            doc.writeUTF(wor.getAdress());
            doc.writeInt(wor.getNum_child());
            doc.writeUTF(wor.getGender());
            doc.writeUTF(wor.getDate());

        }
            //и закрываем поток
            doc.close();
            //проверим появление файла
            File f = new File(file_name);
            if(f.exists())
                System.out.println("\nФайл был найден в директории!");
            else
                System.out.println("\nФайл НЕ был найден в директории((...");

        } catch (InputException io){
            System.out.println("\nОшибка ввода объекта");
        }
        catch (Exception io){
            System.out.println("\nОшибка записи в файл");
        }
    }




}
