import java.io.*;

public class Task_3 {

    public void start_task_3(){
        work_1();
        work_2();
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
            System.out.println("\nУпражнение 1:");
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
            System.out.println("\n");
            file_2.close();

        }catch (Exception io){
            System.out.println(io.toString());
        }
    }

    /*Упражнение 2. Применение буферизированных потоков для чтения и записи
текстовых файлов.

Используйте буфер в 128 байтов.
 Создайте текстовый файл A.txt и запишите в него 512 символов.
 Определите поток inb класса BufferReader и свяжите его с созданным
файлом, установив размер буфера равным 128 байтам (файл должен быть
прочитан за четыре раза).
 Создайте пустой текстовый файл B.txt
 Создайте поток outb класса BufferWriter и свяжите его с файлом B.txt
установив размер буфера 128 байтов.
 Определите буферную переменную buf размером 128 символов –
массив из 128 символов.
 Перепишите все данные из файла A.txt в файл B.txt, используя буфер и
методы: read(buf) и write(buf). Располагая каждый вывод буфера на
отдельной строке файла.*/

    private void work_2(){
        try {
            System.out.println("\nУпражнение 2:");
            //создаем файл и заполняем его 512 символами
            File A = new File("A.txt");
            //A.deleteOnExit();

            FileWriter file_a = new FileWriter("A.txt");

            for(int i=0; i<512; i++){
                file_a.append('r');
            }
            file_a.close();

            //определяе поток inb
            FileReader in = new FileReader("A.txt");
            BufferedReader inb = new BufferedReader(in, 128);

            //пустой текстовый файл В
            File B = new File("B.txt");
            //B.deleteOnExit();

            //поток outb
            FileWriter out = new FileWriter("B.txt");
            BufferedWriter outb = new BufferedWriter(out, 128);

            //переписать из А в В
            char[] arr = new char[128];

            for(int i=0; i<4; i++) {
                inb.read(arr);
                outb.write(arr);
                outb.newLine();
            }

            inb.close();
            in.close();
            outb.close();
            out.close();

        }catch (Exception io){
            System.out.println(io.toString());
        }
    }

    /*Упражнение 3. Настройка кодировки символов для входного и
выходного потоков.
Создайте файл с именем A.txt, используя возможности среды
(щелкните по csr правой кнопкой и в контекстном меню выполните newFile
введите имя). Подготовьте в файле A.txt предложение на русском языке. Вы
подготовили текст в кодировке UTF-8.
Определите в поток in чтения из файла
BufferedReader in = new BufferedReader(new InputStreamReader(new
FileInputStream(&quot;Путь к файлу A.txt&quot;), &quot;Cp1251&quot;));
Отобразите название кодировки, действующей в системе
System.out.println(Charset.defaultCharset().name());
Реализуйте алгоритм чтения из файла текста через строковую
переменну, пока вся информация не будет прочитана.*/
}
