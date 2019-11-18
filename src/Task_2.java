/*Создать класс, указанный в варианте. Предусмотреть конструктор с
параметрами для создания объекта, контролирующий поступающие данные.
Данные состояния объекта вводятся с клавиатуры. Дополнительные методы,
указанные в варианте
2. Создать класс по управлению файлом, который должен обеспечить
следующие функции:
3. Формирование файла данных
3.1. Создать выходной поток для записи объекта в файл, располагая файл в
папке приложения. Имя файла пользователь вводит с клавиатуры.

3.2. Обеспечить проверку существования файла с таким именем и вывод
сообщения о его существовании.
3.3. Выполнить запись в файл данных нескольких объектам. Данные для
полей объекта вводятся с клавиатуры и записываются в файл.
Расположите их в файле так, чтобы потом можно было написать
алгоритм чтения из файла данных и формирование объектов..
Помните, что при вводе вы будете вводить данные и строковых и
примитивных типов (смешанный ввод).
3.4. Закрыть выходной поток.
4. Чтение данных
4.1. Создать входной поток для чтения данных из созданного файла.
4.2. Создать массив с данными о состоянии объектов, используя оду из
коллекций Java: для нечетного варианта ArrayList, для четного –
LinkedList.
4.3. Прочитать данные из файла и разместить в коллекции те объекты,
которые, удовлетворяют критериям дополнительного задания варианта
(задание 1).
5. Используя класс RandomAccessFile произвольного доступа к записям файла
обеспечить:
5.1. Создание нового файла из записей фиксированной длины,
содержащий сведения по объектам, прочитанных в массив объектов в
задании 4.3. Так как поток RandomAccessFile в качестве источника
может иметь только массивы примитивного типа, необходимо
предусмотреть структуру записи – строка и ее размер. Для этого
расширяйте строковые значения пробелами справа, так, чтобы в сумме
с примитивными значениями получить нужный размер. При таком
условии метод seek можно использовать для перемещения по записям.
5.2. Выполнить над новым файлом операцию задания 2 из
дополнительного задания варианта.*/


import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Task_2 {


    public void show_menu_2(){
        String main_menu_text = "\n1. Создать новые объекты и файл\n" +
                "2. Считать и создать список\n0. Выход\n";
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
                    input_file_objects();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Введена неверная команда, повторите ввод");
                    break;
            }
        }
    }

    //создание объектов и добвление в файл + проверка существования файла
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
            doc.writeUTF(wor.getNum_child());
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

    private void input_file_objects(){
        try {
            Scanner inp = new Scanner(System.in);

            System.out.println("\nВведите имя файла, из которого необходимо считать информацию: ");
            String file_name = inp.next();
            file_name += ".bin";

            //проверим есть ли такой файл
            File f = new File(file_name);
            if(!f.exists()){
                System.out.println("\nФайл НЕ был найден в директории!");
                return;
            }

            //создаем LinkedList для хранения объектов
            LinkedList<Worker_university> list_worker = new LinkedList<>();

            //дополнительное задание моего варианта: список мужчин. Значит, буду считывать каждый объект и
            //если он мужчина - вносить в список
            DataInputStream doc = new DataInputStream(new FileInputStream(file_name));

            String t_number, sername, name, adress, gender, date;
            int num_child;

            while(doc.available() > 0) {

                Worker_university work = new Worker_university(doc.readUTF(), doc.readUTF(),doc.readUTF(),doc.readUTF(),
                        doc.readUTF(), doc.readUTF(),doc.readUTF());

                if(work.getGender().equals("M"))
                    list_worker.add(work);
            }

            System.out.println("\nВаш список:");
            for(Worker_university wor : list_worker){
                System.out.print(wor.getWorker());
            }

        }catch (Exception io){
            System.out.println(io.toString());
        }
    }




}
