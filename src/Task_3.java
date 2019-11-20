import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Task_3 {

    public void start_task_3(){
        work_1();
    }

    /*Упражнение 1. Чтение из одного файла текстового файла и запись в
другой
 Создайте два текстовых файл средствами среды или другого текстового
редактора: T1.txt и T2.txt. В файл T1.txt запишите несколько символов.
Файл T2.txt не заполняйте.
 Определите один поток для чтения из файла T1.txt, а второй выходной
с добавлением символов в конец.
 Прочитайте из файла T1.txt значение методом read и перепишите его в
файл T2.txt методом write. Перепишите все значения из файла T1.txt в
T2.txt. Для выполнения операции создайте цикл, пока метод read не
вернет -1.
 При разработке кода используйте исключения на корректность
операций ввода и вывода IOException.
 Выполните отладку программы упражнения. Проверьте заполнение
файла T2.txt.*/
    private void work_1(){
        try {
            //создаем 2 файла
            File T1 = new File("T1.txt");
            File T2 = new File("T2.txt");

            T1.deleteOnExit();
            T2.deleteOnExit();
            //несколько символов в T1
            FileWriter file_1 = new FileWriter("T1.txt");
            file_1.append('e');
            file_1.append('1');
            file_1.append('h');
            file_1.append('5');
            file_1.append('d');

            file_1.close();

            //переписываем
            FileReader t1 = new FileReader("T1.txt");
            FileWriter t2 = new FileWriter("T2.txt");


            int ch = t1.read();
            while (ch != -1){
                t2.write((char)ch);
                ch = t1.read();
            }

            t1.close();
            t2.close();

            //проверка заполненности второго файла
            System.out.print("Во втором файле: ");
            FileReader file_2 = new FileReader("T2.txt");
            ch = file_2.read();
            while (ch != -1){
                System.out.print((char)ch);
                ch = file_2.read();
            }
            System.out.println();
            file_2.close();


        }catch (Exception io){
            System.out.println(io.toString());
        }


    }
}
